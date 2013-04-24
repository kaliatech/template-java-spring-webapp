package com.mycompany.myproj.shared.util.web.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.UserAgent;

import org.apache.commons.lang3.StringUtils;

/**
 * This filter exists to deal with Internet Explorer's deficiency when doing AJAX POST requests in a crossdomain
 * situation. This filter assumes the client-side is using IE's XHR replace for XMLHttpRequest. See
 * https://github.com/Malvolio/ie.xhr for more info. The main issue is that IE.XHR will always POST requests using
 * plain-text even though it should be x-www-form-urlencoded.<br/>
 * <br/>
 * This filter sniffs the user-agent to apply the filter's workaround only for IE9 or earlier. The expectation is that
 * IE10's XMLHttpRequest will work correctly. When IE is detected AND the request is a POST method, then this filter
 * does two things. First, it converts the request body from plain-text to x-www-form-urlencoded. It then changes the
 * "Content-Type" header to application/x-www-form-urlencoded. By doing these two things, subsequent filters and
 * servlets can treat the request as a normal and valid HTTP REST request like with any other browser.<br/>
 * <br/>
 * In order to do these workarounds within the servlet API, this filter wraps the HttpServletRequest with an anonymous
 * request wrapper so that calls to request.getContentType, request.getParameter, request.getHeader, etc. will work per
 * expectations.
 * 
 */
public class InternetExplorerRestFilter implements Filter {

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
      ServletException {

    final HttpServletRequest httpRequest = (HttpServletRequest) req;

    if (!StringUtils.equals(httpRequest.getMethod(), "POST")) {
      chain.doFilter(req, resp);
      return;
    }

    UserAgent userAgent = UserAgent.parseUserAgentString(httpRequest.getHeader("User-Agent"));

    if (userAgent.getBrowser().getGroup().getId() != Browser.IE.getId()) {
      chain.doFilter(req, resp);
      return;
    }

    String majorVersionStr = userAgent.getBrowserVersion().getMajorVersion();
    int majorVersion = 0;
    try {
      Integer.parseInt(majorVersionStr);
    } catch (NumberFormatException nfe) {
      majorVersion = 0;
    }

    // Hopefully IE v10+ will not require these workarounds
    if (majorVersion >= 10) {
      chain.doFilter(req, resp);
      return;
    }

    // IF we're here then we can assume IE pre v10

    // If the above user-agent sniffing for IE isn't sufficient, then we could
    // use the request file extension to do the determination. For example:

    // if (!StringUtils.endsWith(httpRequest.getRequestURL(), ".json")
    // && !StringUtils.endsWith(httpRequest.getRequestURL(), ".xml")) {
    // chain.doFilter(req, resp);
    // return;
    // }

    HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpRequest) {

      InputStream in = httpRequest.getInputStream();
      BufferedReader buffReader = new BufferedReader(new InputStreamReader(in));
      String line = buffReader.readLine();

      Map<String, List<String>> params = getPostParameters(line);
      Map<String, String[]> paramsAsArray = getPostParametersAsArray(line);

      @Override
      public String getContentType() {

        // This is IE workaround since ie8/9 will only send text/plain in XHRDomainRequest
        return "application/x-www-form-urlencoded";
      }

      @Override
      public Enumeration<String> getHeaders(String name) {

        List<String> tmp = new ArrayList<String>();

        if (StringUtils.equalsIgnoreCase(name, "Content-Type")) {
          tmp.add("application/x-www-form-urlencoded");
          return Collections.enumeration(tmp);
        }

        return super.getHeaders(name);
      }

      @Override
      public String getHeader(String name) {

        if (StringUtils.equalsIgnoreCase(name, "Content-Type")) {
          return "application/x-www-form-urlencoded";
        }

        return super.getHeader(name);
      }

      @Override
      public String getParameter(String name) {
        if (params.containsKey(name)) {
          return params.get(name).get(0);
        } else {
          return null;
        }
      }

      @Override
      public Map<String, String[]> getParameterMap() {
        return paramsAsArray;
      }

      @Override
      public Enumeration<String> getParameterNames() {
        return Collections.enumeration(params.keySet());
      }

      @Override
      public String[] getParameterValues(String name) {
        return paramsAsArray.get(name);
      }

    };
    chain.doFilter(wrapper, resp);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {

  }

  private Map<String, List<String>> getPostParameters(String query) throws UnsupportedEncodingException {
    Map<String, List<String>> params = new HashMap<String, List<String>>();

    for (String param : query.split("&")) {
      String pair[] = param.split("=");
      String key = URLDecoder.decode(pair[0], "UTF-8");
      String value = "";
      if (pair.length > 1) {
        value = URLDecoder.decode(pair[1], "UTF-8");
      }
      List<String> values = params.get(key);
      if (values == null) {
        values = new ArrayList<String>();
        params.put(key, values);
      }
      values.add(value);
    }
    return params;
  }

  private Map<String, String[]> getPostParametersAsArray(String queryString) throws UnsupportedEncodingException {
    Map<String, List<String>> mapOfLists = getPostParameters(queryString);

    Map<String, String[]> mapOfArrays = new HashMap<String, String[]>();
    for (String key : mapOfLists.keySet()) {
      mapOfArrays.put(key, mapOfLists.get(key).toArray(new String[] {}));
    }

    return mapOfArrays;
  }

}

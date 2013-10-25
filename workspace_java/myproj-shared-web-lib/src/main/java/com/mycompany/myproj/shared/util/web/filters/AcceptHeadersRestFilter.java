package com.mycompany.myproj.shared.util.web.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;

/**
 * This filter exists to workaround issues with Accept headers when doing AJAX requests from browsers to a REST backend.
 * This filter is partly a workaround to current Spring MVC issues where-by the content type of the response is not
 * configurable in any elegant way. A true REST API expects the Accepts header to indicate the format of the response.
 * However, browsers will send a mangled Accepts headers that is not changeable in most browsers (especially when
 * working cross domain.) This filter functions by examining the Accepts header. If it is not a clean value, then this
 * filter looks at the URL's "file extension". If the extension is .json or .xml, this filter will wrap the request and
 * return corresponding values for the getHeader method. This means that true REST clients can simply use Accept headers
 * as they would normally. But browser clients can append .json or .xml to the request URLs to manually control the
 * response format.<br/>
 * <br/>
 * By putting this filter in front of REST based controllers, the controllers can be implemented as pure REST providers
 * and make use of Spring's automatic content negotiation for response formats.
 * 
 */
public class AcceptHeadersRestFilter implements Filter {

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
      ServletException {

    final HttpServletRequest httpRequest = (HttpServletRequest) req;

    // Don't bother if there isn't a known file extension
    if (!StringUtils.endsWith(httpRequest.getRequestURL(), ".json")
        && !StringUtils.endsWith(httpRequest.getRequestURL(), ".xml")) {
      chain.doFilter(req, resp);
      return;
    }

    // Don't bother wrapping if accept header is already a valid value
    if (StringUtils.equals(httpRequest.getHeader("Accept"), "application/json")
        || StringUtils.equals(httpRequest.getHeader("Accept"), "application/xml")) {
      chain.doFilter(req, resp);
      return;
    }

    // If here, we have a known file extension and the Accept header isn't clean. So
    // we wrap the request anonousmly to override calls to getheader and getHeaders.
    HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpRequest) {

      @Override
      public Enumeration<String> getHeaders(String name) {

        List<String> tmp = new ArrayList<String>();

        if (StringUtils.equalsIgnoreCase(name, "Accept")) {
          if (StringUtils.endsWith(httpRequest.getRequestURL(), ".json")) {
            tmp.add("application/json");
            return Collections.enumeration(tmp);
          } else if (StringUtils.endsWith(httpRequest.getRequestURL(), ".xml")) {
            tmp.add("application/xml");
            return Collections.enumeration(tmp);
          } else {
            return super.getHeaders(name);
          }
        }
        return super.getHeaders(name);
      }

      @Override
      public String getHeader(String name) {

        if (StringUtils.equalsIgnoreCase(name, "Accept")) {
          if (StringUtils.endsWith(httpRequest.getRequestURL(), ".json")) {
            return "application/json";
          } else if (StringUtils.endsWith(httpRequest.getRequestURL(), ".xml")) {
            return "application/xml";
          }
        }
        return super.getHeader(name);
      }
    };
    chain.doFilter(wrapper, resp);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {

  }
}

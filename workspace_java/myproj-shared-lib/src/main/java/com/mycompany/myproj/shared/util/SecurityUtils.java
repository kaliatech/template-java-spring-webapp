package com.mycompany.myproj.shared.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.PortMapper;

public class SecurityUtils {

  public String convertHttpsUrl(String origUrl, PortMapper portMapper) {
    String secureUrl = null;

    if (origUrl == null) {
      return null;
    }

    if (portMapper == null) {
      secureUrl = origUrl.replace("http", "https");
      return secureUrl;
    }

    // Compile the regex.
    String regex = ".*http:.*:(\\d*)"; // good enough for this, but probably
                                       // not good enough for more generic
                                       // usage
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(origUrl);

    // Find all the matches.
    String portStr = null;
    if (matcher.find()) {
      portStr = matcher.group(1);
    }

    if (StringUtils.isEmpty(portStr)) {
      secureUrl = origUrl.replace("http", "https");
      return secureUrl;
    }

    Integer securePort = portMapper.lookupHttpsPort(Integer.parseInt(portStr));
    if (securePort == null) {
      secureUrl = origUrl.replace("http", "https");
      return secureUrl;
    }

    String tmpUrl = origUrl.replace(portStr, securePort.toString());
    secureUrl = tmpUrl.replace("http", "https");

    return secureUrl;
  }
}
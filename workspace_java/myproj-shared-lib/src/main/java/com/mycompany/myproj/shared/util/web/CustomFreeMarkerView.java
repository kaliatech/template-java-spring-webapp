package com.mycompany.myproj.shared.util.web;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DurationFormatUtils;

import com.mycompany.myproj.shared.util.SharedConfigSettings;
import com.mycompany.myproj.shared.util.MiscUtils;
import com.mycompany.myproj.shared.util.SecurityUtils;

public class CustomFreeMarkerView extends org.springframework.web.servlet.view.freemarker.FreeMarkerView {

  private SharedConfigSettings sharedConfigSettings = null;

  @SuppressWarnings("unused")
  private SecurityUtils securityUtils;

  private MiscUtils miscUtils;

  @Override
  protected void doRender(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    // These might be better as shared variables?
    model.put("contextPath", request.getContextPath());

    // Temporary Probably
    model.put("request", request);

    model.put("now", new Date());

    model.put("durationFormatUtils", DurationFormatUtils.class);

    model.put("miscUtils", miscUtils);

    model.put("config", sharedConfigSettings);

    // Per request
    // User loggedInUser = securityUtils.getLoggedInUser();
    // if (loggedInUser != null) {
    // model.put("loggedInUser", loggedInUser);
    // }

    super.doRender(model, request, response);
  }

  public void setSharedConfigSettings(SharedConfigSettings sharedConfigSettings) {
    this.sharedConfigSettings = sharedConfigSettings;
  }

  public void setSecurityUtils(SecurityUtils securityUtils) {
    this.securityUtils = securityUtils;
  }

  public void setMiscUtils(MiscUtils miscUtils) {
    this.miscUtils = miscUtils;
  }

}

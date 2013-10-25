package com.mycompany.myproj.shared.util.web;

import com.mycompany.myproj.shared.util.MiscUtils;
import com.mycompany.myproj.shared.util.SecurityUtils;
import com.mycompany.myproj.shared.util.SharedConfigSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

public class CustomFreeMarkerViewResolver extends FreeMarkerViewResolver {

  @Autowired
  private SharedConfigSettings sharedConfigSettings = null;

  @Autowired
  private SecurityUtils securityUtils;

  @Autowired
  private MiscUtils miscUtils;

  public void setSharedConfigSettings(SharedConfigSettings sharedConfigSettings) {
    this.sharedConfigSettings = sharedConfigSettings;
  }

  @Override
  protected Class<CustomFreeMarkerView> requiredViewClass() {
    return CustomFreeMarkerView.class;
  }

  @Override
  protected AbstractUrlBasedView buildView(String viewName) throws Exception {
    CustomFreeMarkerView view = (CustomFreeMarkerView) super.buildView(viewName);
    view.setSharedConfigSettings(sharedConfigSettings);
    view.setSecurityUtils(securityUtils);
    view.setMiscUtils(miscUtils);
    return view;

  }

  public void setSecurityUtils(SecurityUtils securityUtils) {
    this.securityUtils = securityUtils;
  }

}

package com.mycompany.myproj.shared.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.PortMapper;

public class SharedConfigSettings {

  private String myprojWebAppUrl;

  private String myprojWebAppUrlSecure; // calculated

  private String myprojWebStaticUrl;

  private String myprojWebStaticUrlSecure; // calculated

  private boolean enableClientSideLogging;

  @Autowired(required = false)
  private PortMapper portMapper;

  @Autowired
  private SecurityUtils securityUtils;

  public String getMyprojWebAppUrl() {
    return myprojWebAppUrl;
  }

  /**
   * Note that this class makes assumption that myprojWebAppUrl never changes at
   * runtime. It calculates the secure version of the URL only once and then
   * caches it.
   */
  public String getMyprojWebAppUrlSecure() {
    if (myprojWebAppUrlSecure != null) {
      return myprojWebAppUrlSecure;
    }

    myprojWebAppUrlSecure = securityUtils.convertHttpsUrl(myprojWebAppUrl, portMapper);

    return myprojWebAppUrlSecure;
  }

  public void setMyprojWebAppUrl(String myprojWebAppUrl) {
    this.myprojWebAppUrl = myprojWebAppUrl;
  }

  public void setMyprojWebAppUrlSecure(String myprojWebAppUrlSecure) {
    this.myprojWebAppUrlSecure = myprojWebAppUrlSecure;
  }

  public String getMyprojWebStaticUrl() {
    return myprojWebStaticUrl;
  }

  public void setMyprojWebStaticUrl(String myprojCdnUrl) {
    this.myprojWebStaticUrl = myprojCdnUrl;
  }

  public String getMyprojWebStaticUrlSecure() {
    if (myprojWebStaticUrlSecure != null) {
      return myprojWebStaticUrlSecure;
    }

    myprojWebStaticUrlSecure = securityUtils.convertHttpsUrl(myprojWebStaticUrl, portMapper);

    return myprojWebStaticUrlSecure;
  }

  public void setMyprojWebStaticUrlSecure(String myprojCdnUrlSecure) {
    this.myprojWebStaticUrlSecure = myprojCdnUrlSecure;
  }

  public boolean isEnableClientSideLogging() {
    return enableClientSideLogging;
  }

  public void setEnableClientSideLogging(boolean enableClientSideLogging) {
    this.enableClientSideLogging = enableClientSideLogging;
  }

}

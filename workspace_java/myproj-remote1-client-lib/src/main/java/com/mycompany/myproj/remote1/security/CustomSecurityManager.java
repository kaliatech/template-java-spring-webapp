package com.mycompany.myproj.remote1.security;

import java.security.Permission;


public class CustomSecurityManager extends SecurityManager {

  @Override
  public void checkPermission(Permission arg0, Object arg1) {
  }

  @Override
  public void checkPermission(Permission arg0) {
  }


}
package com.mycompany.myproj.remote1.security;

import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.util.PropertyPermission;


public class MinimalPolicy extends Policy {

  private static PermissionCollection perms;

  public MinimalPolicy() {
      super();
      if (perms == null) {
          perms = new Permissions();
          addPermissions();
      }
  }

  @Override
  public PermissionCollection getPermissions(CodeSource codesource) {
      return perms;
  }

  private void addPermissions() {
      SocketPermission socketPermission = new SocketPermission("*:1199", "connect, resolve");
      PropertyPermission propertyPermission = new PropertyPermission("*", "read, write");
      FilePermission filePermission = new FilePermission("<<ALL FILES>>", "read");

      perms.add(socketPermission);
      perms.add(propertyPermission);
      perms.add(filePermission);
  }

}
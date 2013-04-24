package com.mycompany.myproj.remote1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.mycompany.myproj.remote1.RemoteRemote1Service;
import com.mycompany.myproj.remote1.security.CustomSecurityManager;

public class MyProjRemote1Client {

  private RemoteRemote1Service matlabSrvc;

  public MyProjRemote1Client() {

  }

  public RemoteRemote1Service connect(String hostname) throws RemoteException, NotBoundException {

    // Policy.setPolicy(new MinimalPolicy());
    // System.setSecurityManager(new RMISecurityManager());

    System.setSecurityManager(new CustomSecurityManager());

    Registry registry = LocateRegistry.getRegistry(hostname, 1199);

    // Remote remote = registry.lookup("RemoteMatlabService");

    matlabSrvc = (RemoteRemote1Service) registry.lookup("RemoteRemote1Service");

    return matlabSrvc;

  }

  public static void main(String[] args) {

    try {

      MyProjRemote1Client client = new MyProjRemote1Client();
      RemoteRemote1Service srvc = client.connect("localhost");

      String testStr = srvc.getTest1();
      System.out.println("result:" + testStr);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

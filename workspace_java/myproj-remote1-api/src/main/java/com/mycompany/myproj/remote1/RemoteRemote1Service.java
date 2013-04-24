package com.mycompany.myproj.remote1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteRemote1Service extends Remote {

  public String getTest1() throws RemoteException;
  
  
}

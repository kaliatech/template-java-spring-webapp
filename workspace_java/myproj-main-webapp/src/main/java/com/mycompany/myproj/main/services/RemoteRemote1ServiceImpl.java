package com.mycompany.myproj.main.services;

import java.rmi.RemoteException;
import java.util.Date;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.mycompany.myproj.remote1.RemoteRemote1Service;

@Service
public class RemoteRemote1ServiceImpl implements RemoteRemote1Service {

  private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

  @Override
  public String getTest1() throws RemoteException {

    logger.info("getTest1");

    return "Response from remote1 service:" + new Date().getTime();
  }

}

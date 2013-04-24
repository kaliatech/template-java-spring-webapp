package com.mycompany.myproj.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myproj.entities.MySimpleEntityDao;
import com.mycompany.myproj.shared.util.SharedConfigSettings;

@Service(value = "scheduledService")
public class ScheduledService {

  @Autowired
  private MySimpleEntityDao mySimpleEntityDao;

  @Autowired
  private SharedConfigSettings settings;

  @Transactional
  public void doScheduledTask() {

    mySimpleEntityDao.toString();
  }
}

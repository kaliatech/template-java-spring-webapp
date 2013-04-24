package com.mycompany.myproj.database;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myproj.entities.MySimpleEntityRepository;
import com.mycompany.myproj.shared.util.SharedConfigSettings;

@Component
public class DatabaseManager {

  @Autowired
  private SharedConfigSettings configSettings;

  @Autowired
  private MySimpleEntityRepository mySimpleEntityRepo;

  @PostConstruct
  @Transactional
  public void postConstruct() {

  }

}

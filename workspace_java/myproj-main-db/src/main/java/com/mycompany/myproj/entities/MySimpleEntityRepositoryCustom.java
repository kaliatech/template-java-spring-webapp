package com.mycompany.myproj.entities;

import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myproj.enums.MySimpleEntityStatus;

@Repository
@Transactional
public interface MySimpleEntityRepositoryCustom {

  public MySimpleEntity findMostRecent(String testIdent1, String testIdent2, String roleCode,
      MySimpleEntityStatus status, Date dataCutoffTimestamp);

}

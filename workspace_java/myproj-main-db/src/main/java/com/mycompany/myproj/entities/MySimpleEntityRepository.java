package com.mycompany.myproj.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mycompany.myproj.enums.MySimpleEntityStatus;

public interface MySimpleEntityRepository extends CrudRepository<MySimpleEntity, Long> {

  @Query("FROM MySimpleEntity"
      + " WHERE testIdent1=?1 AND testIdent2=?2 AND roleCode=?3 AND entityStatus=?4 AND endTimestamp <= ?5"
      + " ORDER BY endTimestamp DESC")
  public List<MySimpleEntity> findRecent(String testIdent1, String testIdent2, String roleCode,
      MySimpleEntityStatus entityStatus, Date endTimestamp, Pageable pageable);

  @Query("UPDATE MySimpleEntity" + " SET entityStatus=?6"
      + " WHERE testIdent1=?1 AND testIdent2=?2 AND roleCode=?3 AND uploadStatus=?5 AND endTimestamp <= ?4")
  @Modifying
  public void updateStatuses(String testIdent1, String testIdent2, String roleCode, Date endTimestamp,
      MySimpleEntityStatus oldStatus, MySimpleEntityStatus newStatus);

}

package com.mycompany.myproj.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myproj.enums.MySimpleEntityStatus;

@Repository
@Transactional
public class MySimpleEntityRepositoryImpl implements MySimpleEntityRepositoryCustom {

  @PersistenceContext
  private EntityManager em;

  @Override
  public MySimpleEntity findMostRecent(String testIdent1, String testIdent2, String roleCode,
      MySimpleEntityStatus status, Date dataCutoffTimestamp) {

    StringBuffer sqlBuff = new StringBuffer();
    sqlBuff.append("SELECT o ");
    sqlBuff.append(" FROM DataPoint o");
    sqlBuff.append(" WHERE testIdent1=?1 AND testIdent2=?2 AND roleCode=?3 AND entityStatus=?4 AND endTimestamp < ?5");
    sqlBuff.append(" ORDER BY endTimestamp DESC");

    TypedQuery<MySimpleEntity> q = em.createQuery(sqlBuff.toString(), MySimpleEntity.class);
    q.setMaxResults(1);

    q.setParameter(1, testIdent1);
    q.setParameter(2, testIdent2);
    q.setParameter(3, roleCode);
    q.setParameter(4, status);
    q.setParameter(5, dataCutoffTimestamp, TemporalType.TIMESTAMP);

    List<MySimpleEntity> msgs = q.setMaxResults(1).getResultList();

    if (msgs.size() == 0) {
      return null;
    } else {
      return msgs.get(0);
    }

  }

}

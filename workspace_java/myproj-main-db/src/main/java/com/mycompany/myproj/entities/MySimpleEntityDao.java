package com.mycompany.myproj.entities;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myproj.enums.MySimpleEntityStatus;

@Component
@Transactional
public class MySimpleEntityDao {

  @Autowired
  private DataSource datasource;

  private JdbcTemplate jdbcTemplate;

  // @PersistenceContext
  // private EntityManager em;

  private String findDistinctMySimpleEntityIdentsSql;

  private String findDistinctTest2IdentsSql;

  public MySimpleEntityDao() {

    StringBuffer sqlBuff = new StringBuffer();

    sqlBuff.setLength(0);
    sqlBuff.append("SELECT DISTINCT(testIdent1) FROM MySimpleEntity WHERE entityStatus=? ORDER BY testIdent1 ASC");
    findDistinctMySimpleEntityIdentsSql = sqlBuff.toString();

    sqlBuff.setLength(0);
    sqlBuff
        .append("SELECT testIdent1, testIdent2, roleCode FROM MySimpleEntity WHERE receiverIdent=? AND uploadStatus=? GROUP BY receiverIdent, nodeIdent, nodeSensorRoleCode;");
    findDistinctTest2IdentsSql = sqlBuff.toString();

  }

  @PostConstruct
  private void init() {
    jdbcTemplate = new JdbcTemplate(datasource);
  }

  public List<String> findDistinctReceiverIdentsWithStatus(MySimpleEntityStatus dataPointStatus) {

    return jdbcTemplate.queryForList(findDistinctMySimpleEntityIdentsSql, new Object[] { dataPointStatus.name() },
        String.class);

  }

  /**
   * Return list of maps. Map keys are 'testIdent1', 'testIdent2', and
   * 'roleCode'.
   * 
   * @param receiverIdent
   * @param dataPointStatus
   * @return
   */
  public List<Map<String, Object>> findDistinctNodeIdents(String testIdent2, MySimpleEntityStatus entityStatus) {

    List<Map<String, Object>> resultMaps = jdbcTemplate.queryForList(findDistinctTest2IdentsSql, new Object[] {
        testIdent2, entityStatus.name() });

    return resultMaps;

  }

}

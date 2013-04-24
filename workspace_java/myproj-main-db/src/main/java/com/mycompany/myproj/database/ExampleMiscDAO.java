package com.mycompany.myproj.database;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ExampleMiscDAO {

  @Autowired
  private DataSource ds;

  private JdbcTemplate jt;

  @PostConstruct
  private void init() {
    jt = new JdbcTemplate(ds);
  }

  public int[] getTotalRecordCounts() {

    int[] totals = new int[4];

    totals[0] = jt.queryForObject("SELECT COUNT(*) FROM MySimpleEntity", int.class);

    return totals;
  }

  public void exportData(Date startDateTime, Date endDateTime, RowCallbackHandler rowcb) {

    Object[] args = new Object[] { startDateTime, endDateTime };
    jt.query("SELECT id, timestamp FROM MySimpleEntity WHERE timestamp >= ? AND timestamp <=? ORDER BY timestamp ASC",
        args, rowcb);

  }

  public void truncate(Date endDateTime) {
    Object[] args = new Object[] { endDateTime };
    jt.update("DELETE FROM MySimpleEntity WHERE timestamp < ?", args);
  }

}

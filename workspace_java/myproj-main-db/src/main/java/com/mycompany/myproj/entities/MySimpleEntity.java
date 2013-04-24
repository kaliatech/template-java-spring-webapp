package com.mycompany.myproj.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mycompany.myproj.enums.MySimpleEntityStatus;

@Entity
public class MySimpleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date timestamp;

  @Enumerated(value = EnumType.STRING)
  @Column(nullable = false)
  private MySimpleEntityStatus status;

  public MySimpleEntity() {

  }

  public MySimpleEntity(boolean initDefaults) {
    this.timestamp = new Date();
    this.status = MySimpleEntityStatus.ACTIVE;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public MySimpleEntityStatus getStatus() {
    return status;
  }

  public void setStatus(MySimpleEntityStatus status) {
    this.status = status;
  }

}

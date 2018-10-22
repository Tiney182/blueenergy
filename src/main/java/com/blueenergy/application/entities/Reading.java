package com.blueenergy.application.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reading {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private BigDecimal mpxn;
  private String customerId;
  private String readType;
  private Integer registerId;
  private Integer value;
  private Date readDate;
  
  public Reading() {}

  public Reading(
      BigDecimal mpxn,
      String customerId,
      String readType,
      Integer registerId,
      Integer value,
      Date date) {
    super();
    this.mpxn = mpxn;
    this.customerId = customerId;
    this.readType = readType;
    this.registerId = registerId;
    this.value = value;
    this.readDate = date;
  }

  public BigDecimal getMpxn() {
    return mpxn;
  }

  public void setMpxn(BigDecimal mpxn) {
    this.mpxn = mpxn;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getReadType() {
    return readType;
  }

  public void setReadType(String readType) {
    this.readType = readType;
  }

  public Integer getRegisterId() {
    return registerId;
  }

  public void setRegisterId(Integer registerId) {
    this.registerId = registerId;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Date getReadDate() {
    return readDate;
  }

  public void setReadDate(Date readDate) {
    this.readDate = readDate;
  }
}

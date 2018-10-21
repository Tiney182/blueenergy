package com.blueenergy.application.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
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
  private LocalDate readDate;

  public Reading(
      BigDecimal mpxn,
      String customerId,
      String readType,
      Integer registerId,
      Integer value,
      LocalDate readDate) {
    super();
    this.mpxn = mpxn;
    this.customerId = customerId;
    this.readType = readType;
    this.registerId = registerId;
    this.value = value;
    this.readDate = readDate;
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

  public LocalDate getReadDate() {
    return readDate;
  }

  public void setReadDate(LocalDate readDate) {
    this.readDate = readDate;
  }
}

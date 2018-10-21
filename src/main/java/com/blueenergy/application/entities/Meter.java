package com.blueenergy.application.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Meter {

  @Id private BigDecimal mpxn;
  private BigDecimal serialNumber;
  private String meterType;

  public Meter() {}

  public Meter(BigDecimal mpxn, BigDecimal serialNumber, String meterType) {
    super();
    this.mpxn = mpxn;
    this.serialNumber = serialNumber;
    this.meterType = meterType;
  }

  public BigDecimal getMpxn() {
    return mpxn;
  }

  public void setMpxn(BigDecimal mpxn) {
    this.mpxn = mpxn;
  }

  public BigDecimal getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(BigDecimal serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getMeterType() {
    return meterType;
  }

  public void setMeterType(String meterType) {
    this.meterType = meterType;
  }
}

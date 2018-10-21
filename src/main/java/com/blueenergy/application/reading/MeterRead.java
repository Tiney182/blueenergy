package com.blueenergy.application.reading;

import com.blueenergy.application.reading.type.ReadingType;

public class MeterRead {

  private ReadingType type;
  private Integer registerId;
  private Integer value;

  public MeterRead(ReadingType type, Integer registerId, Integer value) {
    this.type = type;
    this.registerId = registerId;
    this.value = value;
  }

  public ReadingType getType() {
    return type;
  }

  public void setType(ReadingType type) {
    this.type = type;
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
}

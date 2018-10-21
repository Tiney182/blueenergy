package com.blueenergy.application.reading;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MeterRequest {

  private String customerId;
  private BigDecimal serialNumber;
  private BigDecimal mpxn;
  private List<MeterRead> read;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDate readDate;

  public MeterRequest(
      String customerId,
      BigDecimal serialNumber,
      BigDecimal mpxn,
      List<MeterRead> read,
      LocalDate readDate) {
    super();
    this.customerId = customerId;
    this.serialNumber = serialNumber;
    this.mpxn = mpxn;
    this.read = read;
    this.readDate = readDate;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public BigDecimal getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(BigDecimal serialNumber) {
    this.serialNumber = serialNumber;
  }

  public BigDecimal getMpxn() {
    return mpxn;
  }

  public void setMpxn(BigDecimal mpxn) {
    this.mpxn = mpxn;
  }

  public List<MeterRead> getRead() {
    return read;
  }

  public void setRead(List<MeterRead> read) {
    this.read = read;
  }

  public LocalDate getReadDate() {
    return readDate;
  }

  public void setReadDate(LocalDate readDate) {
    this.readDate = readDate;
  }
}

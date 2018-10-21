package com.blueenergy.application.response;

import java.util.List;
import com.blueenergy.application.reading.MeterRead;

public class PresentMeterResponse {

  private List<MeterRead> meterReadings;

  public List<MeterRead> getMeterReadings() {
    return meterReadings;
  }

  public void setMeterReadings(List<MeterRead> meterReadings) {
    this.meterReadings = meterReadings;
  }
}

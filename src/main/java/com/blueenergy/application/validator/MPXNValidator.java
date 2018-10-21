package com.blueenergy.application.validator;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.blueenergy.application.reading.type.MeterType;

@Component
public class MPXNValidator {

  public MeterType validateMpxn(final BigDecimal mpxn) {
    int mpxnLength = String.valueOf(mpxn).length();
    if (mpxnLength == 11) {
      return MeterType.GAS;
    } else if (mpxnLength == 21) {
      return MeterType.ELECTRICITY;
    }
    return null;
  }
}

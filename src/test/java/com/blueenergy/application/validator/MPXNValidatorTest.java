package com.blueenergy.application.validator;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import com.blueenergy.application.reading.type.MeterType;

public class MPXNValidatorTest {

  @Test
  public void validateMpxn_singleValueDecimalPassed_returnsNull() {
    MPXNValidator validator = new MPXNValidator();
    Assert.assertNull(validator.validateMpxn(new BigDecimal("1")));
  }

  @Test
  public void validateMpxn_GasValueDecimalPassed_returnsMeterTypeGas() {
    MPXNValidator validator = new MPXNValidator();
    Assert.assertEquals(MeterType.GAS, validator.validateMpxn(new BigDecimal("99999999999")));
  }

  @Test
  public void validateMpxn_ElectricValueDecimalPassed_returnsMeterTypeElectricity() {
    MPXNValidator validator = new MPXNValidator();
    Assert.assertEquals(
        MeterType.ELECTRICITY, validator.validateMpxn(new BigDecimal("555555555555555555555")));
  }

  @Test
  public void validateMpxn_ElevenLengthDecimalPointedNumberPassed_returnsNull() {
    MPXNValidator validator = new MPXNValidator();
    Assert.assertNull(validator.validateMpxn(new BigDecimal("9.9999999999")));
  }

  @Test
  public void validateMpxn_TwentyOneLengthDecimalPointedNumberPassed_returnsNull() {
    MPXNValidator validator = new MPXNValidator();
    Assert.assertNull(validator.validateMpxn(new BigDecimal("5.55555555555555555555")));
  }
}

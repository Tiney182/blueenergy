package com.blueenergy.application.service;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.blueenergy.application.entities.Meter;
import com.blueenergy.application.entities.Reading;
import com.blueenergy.application.reading.MeterRead;
import com.blueenergy.application.reading.MeterRequest;
import com.blueenergy.application.reading.type.MeterType;
import com.blueenergy.application.repository.MeterRepository;
import com.blueenergy.application.repository.ReadingRepository;
import com.blueenergy.application.validator.CustomerIdentifierValidator;
import com.blueenergy.application.validator.MPXNValidator;

@Service
public class MeterRequestService {

  private CustomerIdentifierValidator customerValidator;
  private MPXNValidator mpxnValidator;

  @Autowired private MeterRepository meterRepository;

  @Autowired private ReadingRepository readingRepository;

  @Autowired
  public MeterRequestService(
      CustomerIdentifierValidator customerValidator, MPXNValidator mpxnValidator) {
    super();
    this.customerValidator = customerValidator;
    this.mpxnValidator = mpxnValidator;
  }

  public ResponseEntity<String> processMeterRequest(MeterRequest meterRequest)
      throws URISyntaxException {
    boolean doesCustomerExist = customerValidator.validateCustomer(meterRequest.getCustomerId());
    if (doesCustomerExist == false) {
      ResponseEntity<String> responseEntity =
          new ResponseEntity<>(
              "Customer with Id" + meterRequest.getCustomerId() + " does not exist",
              HttpStatus.BAD_REQUEST);
      return responseEntity;
    }

    MeterType meterType = mpxnValidator.validateMpxn(meterRequest.getMpxn());
    if (meterType == null) {
      ResponseEntity<String> responseEntity =
          new ResponseEntity<>("Invalid mpxn supplied", HttpStatus.BAD_REQUEST);
      return responseEntity;
    }

    saveMeter(meterRequest, meterType);
    saveReading(meterRequest);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void saveMeter(MeterRequest meterRequest, MeterType meterType) {
    Meter meter =
        new Meter(meterRequest.getMpxn(), meterRequest.getSerialNumber(), meterType.toString());
    meterRepository.save(meter);
  }

  private void saveReading(MeterRequest meterRequest) {
    List<MeterRead> readings = meterRequest.getRead();
    for (MeterRead meterRead : readings) {
      Reading reading =
          new Reading(
              meterRequest.getMpxn(),
              meterRequest.getCustomerId(),
              meterRead.getType().toString(),
              meterRead.getRegisterId(),
              meterRead.getValue(),
              meterRequest.getReadDate());
      readingRepository.save(reading);
    }
  }
}

package com.blueenergy.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.blueenergy.application.entities.Reading;
import com.blueenergy.application.repository.ReadingRepository;
import com.blueenergy.application.validator.CustomerIdentifierValidator;

@Service
public class PresentMeterResponseService {

  @Autowired private ReadingRepository readingRepository;

  private CustomerIdentifierValidator customerValidator;

  @Autowired
  public PresentMeterResponseService(CustomerIdentifierValidator customerValidator) {
    this.customerValidator = customerValidator;
  }

  public ResponseEntity<List<Reading>> getMeterReadingsForCustomerId(String customerId) {

    boolean doesCustomerExist = customerValidator.validateCustomer(customerId);
    if (doesCustomerExist == false) {
      ResponseEntity<List<Reading>> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      return responseEntity;
    }

    List<Reading> readings = readingRepository.findByCustomerId(customerId);

    return new ResponseEntity<>(readings, HttpStatus.OK);
  }
}

package com.blueenergy.application.validator;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.blueenergy.application.dao.CustomerDaoImpl;

@Component
public class CustomerIdentifierValidator {

  private CustomerDaoImpl customerDao;
  
  @Autowired
  public CustomerIdentifierValidator(final CustomerDaoImpl customerDao) {
    this.customerDao = customerDao;
  }
  
  public boolean validateCustomer(String customerId) {
    try {
      customerDao.getCustomer(customerId);
    } catch(NoSuchElementException e) {
      return false;
    }
    return true;
  }
}

package com.blueenergy.application.validator;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.blueenergy.application.dao.CustomerDaoImpl;
import com.blueenergy.application.entities.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerIdentifierValidatorTest {

  @Mock private CustomerDaoImpl customerDaoImpl;

  @Test
  public void validateCustomer_customerIdInvalid_returnsFalse() {
    Mockito.when(customerDaoImpl.getCustomer(Mockito.anyString()))
        .thenThrow(NoSuchElementException.class);
    CustomerIdentifierValidator validator = new CustomerIdentifierValidator(customerDaoImpl);

    Assert.assertFalse(validator.validateCustomer("TestString"));
  }

  @Test
  public void validateCustomer_customerIdValid_returnsTrue() {
    Mockito.when(customerDaoImpl.getCustomer(Mockito.anyString())).thenReturn(new Customer());
    CustomerIdentifierValidator validator = new CustomerIdentifierValidator(customerDaoImpl);

    Assert.assertTrue(validator.validateCustomer("TestString"));
  }
}

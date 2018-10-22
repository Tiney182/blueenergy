package com.blueenergy.application.dao;

import com.blueenergy.application.entities.Customer;

public interface CustomerDao {
  public Customer getCustomer(String customerId);
}

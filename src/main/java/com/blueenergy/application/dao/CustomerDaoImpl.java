package com.blueenergy.application.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.blueenergy.application.entities.Customer;
import com.blueenergy.application.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

  @Autowired private CustomerRepository customerRepository;

  @Override
  public Customer getCustomer(final String customerId) {
    Customer customer = customerRepository.findById(customerId).get();
    return customer;
  }
}

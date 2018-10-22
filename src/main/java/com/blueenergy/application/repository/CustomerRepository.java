package com.blueenergy.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.blueenergy.application.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {}

package com.blueenergy.application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

  @Id private String customerId;

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }
}

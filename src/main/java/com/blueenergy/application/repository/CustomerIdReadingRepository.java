package com.blueenergy.application.repository;

import java.util.List;
import com.blueenergy.application.entities.Reading;

public interface CustomerIdReadingRepository<T1, T2> {
  public List<Reading> findByCustomerId(String customerId);
}

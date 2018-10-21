package com.blueenergy.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.blueenergy.application.entities.Reading;

public interface ReadingRepository extends CrudRepository<Reading, Integer> {
  
}

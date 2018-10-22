package com.blueenergy.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.blueenergy.application.entities.Meter;

public interface MeterRepository extends CrudRepository<Meter, Long> {}

package com.blueenergy.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories("com.blueenergy.application.repository")

public class MeterReadApplication {

  public static void main(String[] args) {
    SpringApplication.run(MeterReadApplication.class, args);
  }
}

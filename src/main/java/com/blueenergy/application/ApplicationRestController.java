package com.blueenergy.application;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blueenergy.application.entities.Customer;
import com.blueenergy.application.entities.Reading;
import com.blueenergy.application.reading.MeterRequest;
import com.blueenergy.application.repository.CustomerRepository;
import com.blueenergy.application.service.MeterRequestService;
import com.blueenergy.application.service.PresentMeterResponseService;

@RestController
@RequestMapping("/api")
public class ApplicationRestController {

  @Autowired private CustomerRepository customerRepository;

  private MeterRequestService meterRequestService;
  private PresentMeterResponseService presentMeterResponseService;

  @Autowired
  public ApplicationRestController(
      final MeterRequestService meterRequestService,
      final PresentMeterResponseService presentMeterResponseService) {
    this.meterRequestService = meterRequestService;
    this.presentMeterResponseService = presentMeterResponseService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<List<Reading>> getReadings(@RequestParam String customerId) {

    return presentMeterResponseService.getMeterReadingsForCustomerId(customerId);
  }

  @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/meter-read")
  public ResponseEntity<String> submitMeterRead(@RequestBody MeterRequest meterRead)
      throws URISyntaxException {

    return meterRequestService.processMeterRequest(meterRead);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/create")
  public ResponseEntity<Void> createCustomer(@RequestParam String customerId) {

    Customer c = new Customer();
    c.setCustomerId(customerId);
    customerRepository.save(c);

    return ResponseEntity.ok().build();
  }
}

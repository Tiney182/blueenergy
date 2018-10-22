package com.blueenergy.application;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationRestController.class)
public class ApplicationRestControllerTest {

  @Autowired private MockMvc mvc;

  @Test
  public void givenValidCustomerId_whenGetMeterReads_thenReturnListOfMeterReads() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/api/1"))
        .andExpect(content().string(containsString("Hello")));
  }

  @Test
  public void givenMeterRead_whenPostMeterReads_ReturnSuccess() throws Exception {
    MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/api/meter-read");
    mvc.perform(post).andExpect(status().isOk());
  }

  @Test
  public void givenMeterRead_whenPostMeterReads_ReturnMethodNotAllowed() throws Exception {
    mvc.perform(MockMvcRequestBuilders.post("/api/mooter-read"))
        .andExpect(status().is4xxClientError());
  }
}

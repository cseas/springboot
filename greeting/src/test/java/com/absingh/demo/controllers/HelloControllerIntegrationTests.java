package com.absingh.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTests {
  @Autowired
  private MockMvc mvc;

  @Test
  public void testHelloWithoutName() throws Exception {
    mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
      .andExpect(status().isOk())
      .andExpect(view().name("hello"))
      .andExpect(model().attribute("user", is("world")));
  }

  @Test
  public void testHelloWithName() throws Exception {
    mvc.perform(get("/hello").param("name", "Abhijeet").accept(MediaType.TEXT_PLAIN))
      .andExpect(status().isOk())
      .andExpect(view().name("hello"))
      .andExpect(model().attribute("user", is("Abhijeet")));
  }
}

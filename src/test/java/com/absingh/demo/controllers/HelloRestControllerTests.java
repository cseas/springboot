package com.absingh.demo.controllers;

import com.absingh.demo.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTests {
  @Autowired
  private TestRestTemplate template;

  @Test
  public void greetWithoutName() {
//    Get the entire HTTP response so we can check status code, headers, etc.
    ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
    Greeting response = entity.getBody();
    assertEquals("Hello, world!", response.getMessage());
  }

  @Test
  public void greetWithName() {
//    Get response and convert it to an instance of class Greeting
    Greeting response = template.getForObject("/rest?name=Abhijeet", Greeting.class);
    assertEquals("Hello, Abhijeet!", response.getMessage());
  }
}

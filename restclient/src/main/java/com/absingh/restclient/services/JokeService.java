package com.absingh.restclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

  private RestTemplate restTemplate;

  @Autowired
  public JokeService(RestTemplateBuilder builder) {
    restTemplate = builder.build();
  }
}

// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-resttemplate

package com.rodrigo.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BasicAuthenticationController {

  @GetMapping(path = "/basicauth")
  public AuthenticationBean basicAuthenticationController() {
    return new AuthenticationBean("You are authenticated");
  }
}

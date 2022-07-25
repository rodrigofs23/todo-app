package com.rodrigo.rest.webservices.restfulwebservices.jwt.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenRequest implements Serializable {

  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
  private String password;

  /*  public JwtTokenRequest() {
    super();
  }*/
}

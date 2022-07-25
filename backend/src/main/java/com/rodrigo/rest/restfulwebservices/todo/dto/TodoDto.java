package com.rodrigo.rest.restfulwebservices.todo.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
public class TodoDto {
  private Long id;
  private String username;
  private String description;
  private Date targetDate;
  private boolean isDone;
}

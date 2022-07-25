package com.rodrigo.rest.webservices.restfulwebservices.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
  @Id @GeneratedValue private Long id;
  private String username;
  private String description;
  private Date targetDate;
  private boolean isDone;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Todo todo = (Todo) o;
    return id != null && Objects.equals(id, todo.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}

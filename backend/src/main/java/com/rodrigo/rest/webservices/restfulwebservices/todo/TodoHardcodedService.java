package com.rodrigo.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class TodoHardcodedService {

  private static List<Todo> todos = new ArrayList<>();
  private static long idCounter = 0;

  static {
    todos.add(
        new Todo(
            ++idCounter,
            "Rodrigo",
            "Learn Spring Boot",
            new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(),
            false));
    todos.add(new Todo(++idCounter, "joao", "Learn angular", new Date(), false));
    todos.add(new Todo(++idCounter, "paulo", "Learn react", new Date(), false));
  }

  public List<Todo> findAll() {
    return todos;
  }

  public Todo save(Todo todo) {
    if (todo.getId() == -1 || todo.getId() == 0) {
      todo.setId(++idCounter);
      todos.add(todo);
    } else {
      deleteById(todo.getId());
      todos.add(todo);
    }
    return todo;
  }

  public Todo deleteById(long id) {
    Todo todo = findById(id);

    if (todo == null) return null;

    if (todos.remove(todo)) {
      return todo;
    }

    return null;
  }

  public Todo findById(long id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        return todo;
      }
    }

    return null;
  }
}

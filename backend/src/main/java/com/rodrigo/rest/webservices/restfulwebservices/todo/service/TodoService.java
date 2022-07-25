package com.rodrigo.rest.webservices.restfulwebservices.todo.service;

import com.rodrigo.rest.webservices.restfulwebservices.todo.entity.Todo;
import com.rodrigo.rest.webservices.restfulwebservices.todo.repository.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

  private final TodoJpaRepository todoRepository;

  @Autowired
  public TodoService(TodoJpaRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> findAll(String username) {
    return todoRepository.findByUsername(username);
  }

  public Todo findById(long id) {
    return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
  }

  public void deleteById(long id) {
    if (todoRepository.existsById(id)) {
      todoRepository.deleteById(id);
    } else {
      throw new IllegalArgumentException("Todo not found");
    }
  }

  public Todo addTodo(Todo todo, String username) {
    todo.setUsername(username);
    return todoRepository.save(todo);
  }

  public void update(Todo todo, String username, long id) {
    todo.setUsername(username);
    todo.setId(id);
    todoRepository.save(todo);
  }
}

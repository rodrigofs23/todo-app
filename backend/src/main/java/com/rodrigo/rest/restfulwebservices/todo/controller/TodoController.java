package com.rodrigo.rest.restfulwebservices.todo.controller;

import com.rodrigo.rest.restfulwebservices.todo.entity.Todo;
import com.rodrigo.rest.restfulwebservices.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoController {

  private final TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/users/{username}/todos")
  public List<Todo> getAllTodos(@PathVariable String username) {
    return todoService.findAll(username);
  }

  @GetMapping("/users/{username}/todos/{id}")
  public Todo getTodo(@PathVariable String username, @PathVariable long id) {
    return todoService.findById(id);
  }

  @DeleteMapping("/users/{username}/todos/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
    todoService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/users/{username}/todos/{id}")
  public ResponseEntity<Todo> updateTodo(
      @PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
    todoService.update(todo, username, id);
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }

  @PostMapping("/users/{username}/todos")
  public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {

    Todo createdTodo = todoService.addTodo(todo, username);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdTodo.getId())
            .toUri();

    return ResponseEntity.created(uri).build();
  }
}

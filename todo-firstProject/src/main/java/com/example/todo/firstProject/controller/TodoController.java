package com.example.todo.firstProject.controller;

import com.example.todo.firstProject.model.Todo;
import com.example.todo.firstProject.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.findAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @RequestMapping("/find/{id}")
    public ResponseEntity<Optional<Todo>> getTaskById(@PathVariable("id") Long id) {
        Optional<Todo> todo = todoService.findTodoById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        Todo todo1 = todoService.addTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        Todo updateTodo = todoService.updateTodo(todo);
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Todo> deleteTodo(@RequestParam("id") Long id){
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

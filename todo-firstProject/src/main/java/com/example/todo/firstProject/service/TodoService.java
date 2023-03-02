package com.example.todo.firstProject.service;

import com.example.todo.firstProject.model.Todo;
import com.example.todo.firstProject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findAllTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> findTodoById(Long id){
        return todoRepository.findById(id);
    }

    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }


    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}

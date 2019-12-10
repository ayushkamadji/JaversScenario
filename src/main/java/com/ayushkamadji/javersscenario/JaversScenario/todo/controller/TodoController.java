package com.ayushkamadji.javersscenario.JaversScenario.todo.controller;

import com.ayushkamadji.javersscenario.JaversScenario.entity.Todo;
import com.ayushkamadji.javersscenario.JaversScenario.repository.TodoRepository;
import com.ayushkamadji.javersscenario.JaversScenario.todo.form.TodoForm;
import com.ayushkamadji.javersscenario.JaversScenario.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> index() {
        return todoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Todo showTodo(@PathVariable Long id) throws Exception{
        return todoService.findById(id);
    }

    @PostMapping
    public Todo createTodo(@Valid @RequestBody TodoForm todoForm) {
        return todoService.create(todoForm);
    }

    @PatchMapping(value = "/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody TodoForm todoForm) throws Exception {
        return todoService.update(id, todoForm);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }
}

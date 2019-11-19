package com.ayushkamadji.javersscenario.JaversScenario.todo.service;

import com.ayushkamadji.javersscenario.JaversScenario.entity.Todo;
import com.ayushkamadji.javersscenario.JaversScenario.repository.TodoRepository;
import com.ayushkamadji.javersscenario.JaversScenario.todo.form.TodoForm;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo create(TodoForm todoForm) {
        Todo todo = new Todo();
        todo.setTitle(todoForm.getTitle());
        return todoRepository.save(todo);
    }

    public Todo update(Long id, TodoForm todoForm) throws Exception {
        Todo todo = todoRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        todo.setTitle(
            isNull(todoForm.getTitle()) || todoForm.getTitle().trim().isEmpty() ?
                todo.getTitle() :
                todoForm.getTitle()
        );

        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}

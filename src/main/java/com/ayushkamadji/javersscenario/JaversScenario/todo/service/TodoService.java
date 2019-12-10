package com.ayushkamadji.javersscenario.JaversScenario.todo.service;

import com.ayushkamadji.javersscenario.JaversScenario.entity.Project;
import com.ayushkamadji.javersscenario.JaversScenario.entity.Todo;
import com.ayushkamadji.javersscenario.JaversScenario.project.service.ProjectService;
import com.ayushkamadji.javersscenario.JaversScenario.repository.ProjectRepository;
import com.ayushkamadji.javersscenario.JaversScenario.repository.TodoRepository;
import com.ayushkamadji.javersscenario.JaversScenario.todo.form.TodoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Transactional
    public Todo create(TodoForm todoForm) {
        Todo todo = new Todo();
        todo.setTitle(todoForm.getTitle());
        if (Optional.of(todoForm.getProjectId()).isPresent()) {
            Project project = projectRepository.findById(todoForm.getProjectId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
            todo.setProject(project);
        }
        return todoRepository.save(todo);
    }

    @Transactional
    public Todo update(Long id, TodoForm todoForm) throws Exception {
        Todo todo = todoRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        todo.setTitle(
            isNull(todoForm.getTitle()) || todoForm.getTitle().trim().isEmpty() ?
                todo.getTitle() :
                todoForm.getTitle()
        );

        if (Optional.of(todoForm.getProjectId()).isPresent()) {
            Project project = projectRepository.findById(todoForm.getProjectId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));
            todo.setProject(project);
        }

        return todoRepository.save(todo);
    }

    @Transactional
    public Todo findById(Long id) {
        return todoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}

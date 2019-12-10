package com.ayushkamadji.javersscenario.JaversScenario.project.controller;

import com.ayushkamadji.javersscenario.JaversScenario.entity.Project;
import com.ayushkamadji.javersscenario.JaversScenario.project.form.ProjectForm;
import com.ayushkamadji.javersscenario.JaversScenario.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> index() {
        return projectService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Project showProject(@PathVariable Long id) throws Exception{
        return projectService.findById(id);
    }

    @PostMapping
    public Project createProject(@Valid @RequestBody ProjectForm projectForm) {
        return projectService.create(projectForm);
    }
}

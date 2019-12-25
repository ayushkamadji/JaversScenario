package com.ayushkamadji.javersscenario.JaversScenario.project.service;

import com.ayushkamadji.javersscenario.JaversScenario.entity.Project;
import com.ayushkamadji.javersscenario.JaversScenario.project.form.ProjectForm;
import com.ayushkamadji.javersscenario.JaversScenario.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public Project findById(Long id) {
        return projectRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Project create(ProjectForm form) {
        Project newProject = new Project();
        newProject.setName(form.getName());
        return projectRepository.save(newProject);
    }

    @Transactional
    public Project update(Long id, ProjectForm projectForm) throws Exception {
        Project project = projectRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        project.setName(
            isNull(projectForm.getName()) || projectForm.getName().trim().isEmpty() ?
                project.getName() :
                projectForm.getName()
        );

        return projectRepository.save(project);
    }
}

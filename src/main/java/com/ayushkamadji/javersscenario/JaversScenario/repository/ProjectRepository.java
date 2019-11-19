package com.ayushkamadji.javersscenario.JaversScenario.repository;

import com.ayushkamadji.javersscenario.JaversScenario.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

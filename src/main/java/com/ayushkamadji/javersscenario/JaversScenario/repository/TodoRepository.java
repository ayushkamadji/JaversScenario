package com.ayushkamadji.javersscenario.JaversScenario.repository;

import com.ayushkamadji.javersscenario.JaversScenario.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

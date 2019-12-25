package com.ayushkamadji.javersscenario.JaversScenario.repository;

import com.ayushkamadji.javersscenario.JaversScenario.entity.Chore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoreRepository extends JpaRepository<Chore, Long> {
}

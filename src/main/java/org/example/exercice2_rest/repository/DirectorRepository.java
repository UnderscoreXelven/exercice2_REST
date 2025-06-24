package org.example.exercice2_rest.repository;

import org.example.exercice2_rest.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}

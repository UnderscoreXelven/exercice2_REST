package org.example.exercice2_rest.repository;

import org.example.exercice2_rest.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

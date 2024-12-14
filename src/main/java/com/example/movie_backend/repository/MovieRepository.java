package com.example.movie_backend.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{
    // Find by name
    Optional<Movie> findByName(String name);
}

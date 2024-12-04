package com.example.movie_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{

}

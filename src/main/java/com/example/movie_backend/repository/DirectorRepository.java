package com.example.movie_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.Director;

public interface DirectorRepository extends JpaRepository<Director,Long>{

}

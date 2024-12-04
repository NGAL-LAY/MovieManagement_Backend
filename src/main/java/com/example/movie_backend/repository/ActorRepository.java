package com.example.movie_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor,Long> {
    
}

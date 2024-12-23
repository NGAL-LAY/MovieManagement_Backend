package com.example.movie_backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor,Long> {
    // Custom query to delete actors by a list of IDs
    void deleteByIdIn(List<Long> ids);
}

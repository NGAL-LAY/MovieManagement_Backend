package com.example.movie_backend.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.Director;

public interface DirectorRepository extends JpaRepository<Director,Long>{
    // Custom query to delete directors by a list of IDs
    void deleteByIdIn(List<Long> ids);
}

package com.example.movie_backend.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    // Custom query to delete users by a list of IDs
    void deleteByIdIn(List<Long> ids);
}

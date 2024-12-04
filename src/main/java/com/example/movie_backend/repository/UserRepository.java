package com.example.movie_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}

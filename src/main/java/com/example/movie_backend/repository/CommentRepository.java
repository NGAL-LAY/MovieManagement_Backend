package com.example.movie_backend.repository;
import com.example.movie_backend.entity.Comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    
    // Custom query to delete comments by a list of IDs
    void deleteByIdIn(List<Long> ids);
}

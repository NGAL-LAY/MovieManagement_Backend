package com.example.movie_backend.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.entity.Comment;
import com.example.movie_backend.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // get all comments
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // get comment by name
    // public Comment getCommentByName(String Name) {
    //     return commentRepository.findByName(Name).orElse(null);
    // }

    // get comment by id
    public Comment getCommentById(Long Id) {
        return commentRepository.findById(Id).orElse(null);
    }

    // register comment
    public Comment regComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // delete comment by id
    public void delCommentById(Long id)  {
        commentRepository.deleteById(id);
    }

}

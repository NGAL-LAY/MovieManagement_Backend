package com.example.movie_backend.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie_backend.service.CommentService;
import com.example.movie_backend.entity.Comment;;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    // Fetch All Comments
    @GetMapping
    public ResponseEntity<List<Comment>> getAllMovies() {
        try {
            List<Comment> comments = commentService.getAllComments();
            if(comments != null){
                return new ResponseEntity<>(comments, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Fetch Comment by ID
    // @GetMapping("/{name}")
    // public ResponseEntity<Comment> getCommentById(@PathVariable String name) {
    //     try {
    //         Movie movie = commentService.getMovieByName(name);
    //         if(movie != null){
    //             return new ResponseEntity<>(movie, HttpStatus.OK);
    //         }else{
    //             return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // commment register
    @PostMapping
    public ResponseEntity<Comment> registerComment(@RequestBody Comment comment) {
        System.out.println("Comment backend");
        try {
            Comment regComment = commentService.regComment(comment);
            if(regComment != null){
                return new ResponseEntity<>(regComment, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete comment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Long id) {
        try {
                commentService.delCommentById(id);
                return new ResponseEntity<>(null,HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

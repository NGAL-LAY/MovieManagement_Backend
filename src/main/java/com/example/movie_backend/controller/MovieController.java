package com.example.movie_backend.controller;
import com.example.movie_backend.entity.Movie;
import com.example.movie_backend.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/movies")

public class MovieController {

    @Autowired
    private MovieService movieService;
    
    // Fetch All Movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            List<Movie> movies = movieService.getAllMovies();
            if(movies != null){
                return new ResponseEntity<>(movies, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Fetch Movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        try {
            Movie movie = movieService.getMovieById(id);
            if(movie != null){
                return new ResponseEntity<>(movie, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // movie register
    @PostMapping
    public ResponseEntity<Movie> registerMovie(@RequestBody Movie movie) {
        try {
            Movie regMovie = movieService.regMovie(movie);
            if(regMovie != null){
                return new ResponseEntity<>(regMovie, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete movie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        try {
            Movie deleteMovie = movieService.getMovieById(id);
            if(deleteMovie != null){
                movieService.delMovieById(id);
                return new ResponseEntity<>(null,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable Long id, @RequestBody Movie updateMovie) {
        try {
            Movie existMovie = movieService.getMovieById(id);
            if (existMovie != null) {
                Movie updatedMovie = this.movieService.updMovieById(id, updateMovie);
                return new ResponseEntity<>(updatedMovie, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

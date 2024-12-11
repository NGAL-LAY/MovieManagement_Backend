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
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // Fetch Movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        // System.out.println("Received request for Movie ID: " + id); 
        try {
            Movie movie = movieService.getMovieById(id);
            if (movie != null) {
                return new ResponseEntity<>(movie, HttpStatus.OK);
            } else {
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
        
        System.out.println("Data from frontend" + movie.getYear()); 
        try {
            Movie regMovie = movieService.regMovie(movie);
            return new ResponseEntity<>(regMovie, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace for debugging
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

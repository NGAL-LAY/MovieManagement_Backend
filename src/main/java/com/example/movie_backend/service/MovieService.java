package com.example.movie_backend.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.repository.MovieRepository;
import com.example.movie_backend.entity.Movie;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    // get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // get movie by name
    public Movie getMovieByName(String Name) {
        return movieRepository.findByName(Name).orElse(null);
    }

    // get movie by id
    public Movie getMovieById(Long Id) {
        return movieRepository.findById(Id).orElse(null);
    }

    // register movie
    public Movie regMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // delete movie by id
    public void delMovieById(Long id)  {
        movieRepository.deleteById(id);
            // Optional<Movie> movieOptional = movieRepository.findById(id);
            // if (movieOptional.isEmpty()) {
            //     throw new RuntimeException("Movie not found with ID: " + id);
            // }
            // Movie movieToDelete = movieOptional.get();
            // movieRepository.deleteById(id); 
            // return movieToDelete; 
    }

    // update movie by id
    public Movie updMovieById(Long id, Movie updateMovie){

        Optional<Movie> existingMovieOptional = movieRepository.findById(id);
        if(existingMovieOptional.isPresent()){
        Movie existMovie = existingMovieOptional.get();
            if(updateMovie.getName() != null){
                existMovie.setName(updateMovie.getName());
            }
            if(updateMovie.getType() != null){
                existMovie.setType(updateMovie.getType());
            }
            if(updateMovie.getYear() != null)
            {
                existMovie.setYear(updateMovie.getYear());
            }
            return movieRepository.save(existMovie);
        }else{
            throw new IllegalArgumentException("Movie not found with ID: " + id);
        }
    }
}

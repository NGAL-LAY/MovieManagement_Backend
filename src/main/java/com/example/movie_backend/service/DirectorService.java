package com.example.movie_backend.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.entity.Director;
import com.example.movie_backend.repository.DirectorRepository;


@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    //fetch all director
    public List<Director> getAllDirectors(){
        return this.directorRepository.findAll();
    }

    //fetch director by Id
    public Director getDirectorById(Long Id){
        return this.directorRepository.findById(Id).orElse(null);
    }

    //register director info
    public Director regDirector(Director director){
        return this.directorRepository.save(director);
    }
}

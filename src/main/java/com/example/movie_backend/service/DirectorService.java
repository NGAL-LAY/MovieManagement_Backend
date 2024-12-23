package com.example.movie_backend.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.entity.Director;
import com.example.movie_backend.repository.DirectorRepository;
import jakarta.transaction.Transactional;


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

    // delete director by id
    @Transactional
    public void delDirectorById(List<Long> ids)  {
        directorRepository.deleteByIdIn(ids);
    }

    // update director by id
    public Director updDirectorById(Long id, Director updateDirector){

        Optional<Director> existingDirectorOptional = directorRepository.findById(id);
        if(existingDirectorOptional.isPresent()){
        Director existDirector = existingDirectorOptional.get();
            if(updateDirector.getName() != null){
                existDirector.setName(updateDirector.getName());
            }
            if(updateDirector.getGentle() != null){
                existDirector.setGentle(updateDirector.getGentle());
            }
            if(updateDirector.getNationality() != null)
            {
                existDirector.setNationality(updateDirector.getNationality());
            }
            return directorRepository.save(existDirector);
        }else{
            throw new IllegalArgumentException("Director not found with ID: " + id);
        }
    }
}

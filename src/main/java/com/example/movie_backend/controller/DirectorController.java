package com.example.movie_backend.controller;
import java.util.List;
import com.example.movie_backend.entity.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie_backend.service.DirectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/directors")

public class DirectorController {

    @Autowired
    private DirectorService directorService;

    //fetch all director
    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectors() {
        try {
            List<Director> directors = this.directorService.getAllDirectors();
            if (directors != null) {
                return new ResponseEntity<>(directors,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //fetch director by Id
    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        try {
            Director director = this.directorService.getDirectorById(id);
            if (director != null) {
                return new ResponseEntity<>(director,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //register director info
    @PostMapping
    public ResponseEntity<Director> registerDirector(@RequestBody Director director) {
        try {
            Director regDirector = this.directorService.regDirector(director);
            if (regDirector != null) {
                return new ResponseEntity<>(regDirector,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update director
    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirectorById(@PathVariable Long id, @RequestBody Director updateDirector) {
        try {
            Director existDirector = directorService.getDirectorById(id);
            if (existDirector != null) {
                Director updatedDirector = this.directorService.updDirectorById(id, updateDirector);
                return new ResponseEntity<>(updatedDirector, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete director
    @DeleteMapping
    public ResponseEntity<Void> deleteDirectorById(@RequestBody List<Long> ids) {
        try {
            if(ids != null){
                directorService.delDirectorById(ids);
                return new ResponseEntity<>(null,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
                
        }catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    

}

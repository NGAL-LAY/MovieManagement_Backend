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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie_backend.entity.Actor;
import com.example.movie_backend.service.ActorService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/actors")

public class ActorController {
    
    @Autowired
    private ActorService actorService;

    //fetch all actor
    @GetMapping
    public ResponseEntity <List<Actor>> getAllActors(){
        try {
            List<Actor> actors = this.actorService.getAllActors();
            if(actors != null){
                return new ResponseEntity<>(actors,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //fetch actor by Id
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getMethodName(@PathVariable Long id) {
        try {
            Actor actor = this.actorService.getActorById(id);
            if(actor != null){
                return new ResponseEntity<>(actor,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //register actor info
    @PostMapping
    public ResponseEntity <Actor> registerActor(@RequestBody Actor actor){
        try {
            Actor regActor = this.actorService.regActor(actor);
            if(regActor != null){
                return new ResponseEntity<>(regActor,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update actor
    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActorById(@PathVariable Long id, @RequestBody Actor updateActor) {
        try {
            Actor existActor = actorService.getActorById(id);
            if (existActor != null) {
                Actor updatedActor = this.actorService.updActorById(id, updateActor);
                return new ResponseEntity<>(updatedActor, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete actor
    @DeleteMapping
    public ResponseEntity<Void> deleteActorById(@RequestBody List<Long> ids) {
        try {
            if(ids != null){
                actorService.delActorById(ids);
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

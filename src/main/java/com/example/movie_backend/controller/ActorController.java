package com.example.movie_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
    @RequestMapping
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
}

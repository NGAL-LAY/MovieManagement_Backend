package com.example.movie_backend.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.entity.Actor;
import com.example.movie_backend.repository.ActorRepository;

@Service
public class ActorService {
    
    @Autowired
    private ActorRepository actorRepository;

    //fetch all actor
    public List<Actor> getAllActors(){
        return this.actorRepository.findAll();
    }

    //fetch actor by Id
    public Actor getActorById(Long Id){
        return this.actorRepository.findById(Id).orElse(null);
    }

    //register actor info
    public Actor regActor(Actor actor){
        return this.actorRepository.save(actor);
    }
}

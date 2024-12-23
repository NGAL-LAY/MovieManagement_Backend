package com.example.movie_backend.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.entity.Actor;
import com.example.movie_backend.repository.ActorRepository;
import jakarta.transaction.Transactional;

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

    // delete actor by id
    @Transactional
    public void delActorById(List<Long> ids)  {
        actorRepository.deleteByIdIn(ids);
    }

    // update actor by id
    public Actor updActorById(Long id, Actor updateActor){

        Optional<Actor> existingActorOptional = actorRepository.findById(id);
        if(existingActorOptional.isPresent()){
        Actor existActor = existingActorOptional.get();
            if(updateActor.getName() != null){
                existActor.setName(updateActor.getName());
            }
            if(updateActor.getGentle() != null){
                existActor.setGentle(updateActor.getGentle());
            }
            if(updateActor.getNationality() != null)
            {
                existActor.setNationality(updateActor.getNationality());
            }
            return actorRepository.save(existActor);
        }else{
            throw new IllegalArgumentException("Actor not found with ID: " + id);
        }
    }
}

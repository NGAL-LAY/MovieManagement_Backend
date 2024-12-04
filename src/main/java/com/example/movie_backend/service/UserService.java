package com.example.movie_backend.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.repository.UserRepository;
import com.example.movie_backend.entity.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRespository;

    // fet all users
    public List<User> getAllUsers(){
        return userRespository.findAll();
    }

    //fet user by Id
    public User getUserById(Long Id){
        return userRespository.findById(Id).orElse(null);
    }

    //register user info
    public User regUser(User user){
        return userRespository.save(user);
    }
}

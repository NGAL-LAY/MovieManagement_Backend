package com.example.movie_backend.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import com.example.movie_backend.entity.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // fet all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //fet user by Id
    public User getUserById(Long Id){
        return userRepository.findById(Id).orElse(null);
    }

    //register user info
    public User regUser(User user){
        return userRepository.save(user);
    }

    // delete user by id
    @Transactional
    public void delUserById(List<Long> ids)  {
        userRepository.deleteByIdIn(ids);
    }

    // update user by id
    public User updUserById(Long id, User updateUser){

        Optional<User> existingUserOptional = userRepository.findById(id);
        if(existingUserOptional.isPresent()){
        User existUser = existingUserOptional.get();
            if(updateUser.getName() != null){
                existUser.setName(updateUser.getName());
            }
            if(updateUser.getEmail() != null){
                existUser.setEmail(updateUser.getEmail());
            }
            if(updateUser.getNationality() != null){
                existUser.setNationality(updateUser.getNationality());
            }
            if(updateUser.getAge() > 15){
                existUser.setAge(updateUser.getAge());
            }
            if(updateUser.getGentle() != null){
                existUser.setGentle(updateUser.getGentle());
            }
            if(updateUser.getRole() != null){
                existUser.setRole(updateUser.getRole());
            }
            return userRepository.save(existUser);
        }else{
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
    }
}
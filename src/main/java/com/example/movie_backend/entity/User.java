package com.example.movie_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String country;
    private String gentle;
    private int age;

    //getter and setter
    public Long getId(){
        return id;
    }

    public void setId(Long Id){
        this.id = Id;
    }

    public String getName(){
        return name;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String Email){
        this.email = Email;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String Country){
        this.country = Country;
    }

    public String getGentle(){
        return gentle;
    }

    public void setGentle(String Gentle){
        this.gentle = Gentle;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int Age){
        this.age = Age;
    }

    public User orElse(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElse'");
    }
}

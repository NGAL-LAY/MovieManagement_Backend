package com.example.movie_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gentle;
    private String nationality;

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

    public String getGentle(){
        return gentle;
    }
    public void setGentle(String Gentle){
        this.gentle = Gentle;
    }

    public String getNationality(){
        return nationality;
    }
    public void setNationality(String Nationality){
        this.nationality = Nationality;
    }
}

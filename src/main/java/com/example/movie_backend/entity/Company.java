package com.example.movie_backend.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="companies")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "release_movies")
    private int releaseMovies;
    private String country;
    @Column(name = "open_date")
    private LocalDate openDate;
    
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

    public int getReleaseMovies(){
        return releaseMovies;
    }
    public void setReleaseMovies(int ReleaseMovies){
        this.releaseMovies = ReleaseMovies;
    }

    public String getCountry(){
        return country;
    }
    public void setCountry(String Country){
        this.country = Country;
    }

    public LocalDate getOpenDate(){
        return openDate;
    }
    public void setOpenDate(LocalDate OpenDate){
        this.openDate = OpenDate;
    }
}

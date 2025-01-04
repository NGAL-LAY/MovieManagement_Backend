package com.example.movie_backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String actorids;
    private Number directorid;
    private Number companyid;
    private String language;
    private String year;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActorids() {
        return actorids;
    }

    public void setActorids(String Actorids) {
        this.actorids = Actorids;
    }

    public Number getDirectorid() {
        return directorid;
    }

    public void setDirectorid(Number Directorid) {
        this.directorid = Directorid;
    }

    public Number getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Number Companyid) {
        this.companyid = Companyid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String Language) {
        this.language = Language;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

package com.example.movie_backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("movieid")
    private Integer movieid;
    @JsonProperty("userid")
    private Integer userid;
    private String comments;
    private Integer rating;

    //getter and setter
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @JsonProperty("movieid")
    public Integer getMovieId(){
        return movieid;
    }
    public void setMovieId(Integer movieid){
        this.movieid = movieid;
    }

    @JsonProperty("userid")
    public Integer getUserId(){
        return userid;
    }
    public void setUserId(Integer userid){
        this.userid = userid;
    }

    public String getComments(){
        return comments;
    }
    public void setComments(String comments){
        this.comments = comments;
    }
    public Integer getRating(){
        return rating;
    }
    public void setNationality(Integer rating){
        this.rating = rating;
    }
}

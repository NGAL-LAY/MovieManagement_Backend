package com.example.movie_backend.entity;

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

    private Integer movieid;
    private Integer userid;
    private String comments;
    private Integer rating;

    //getter and setter
    public Long getId(){
        return id;
    }
    public void setId(Long Id){
        this.id = Id;
    }

    public Integer getMovieId(){
        return movieid;
    }
    public void setMovieId(Integer MovieId){
        this.movieid = MovieId;
    }

    public Integer getUserId(){
        return userid;
    }
    public void setUserId(Integer UserId){
        this.userid = UserId;
    }

    public String getComments(){
        return comments;
    }
    public void setComments(String Comments){
        this.comments = Comments;
    }
    public Integer getRating(){
        return rating;
    }
    public void setNationality(Integer Rating){
        this.rating = Rating;
    }
}

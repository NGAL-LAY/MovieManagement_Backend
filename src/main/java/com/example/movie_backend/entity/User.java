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
    private String password;
    private String email;
    private String nationality;
    private int age;
    private String gentle;
    private String role;

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

    public String getPassword(){
        return password;
    }

    public void setPassword(String Password){
        this.password = Password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String Email){
        this.email = Email;
    }

    public String getNationality(){
        return nationality;
    }

    public void setNationality(String Nationality){
        this.nationality = Nationality;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int Age){
        this.age = Age;
    }

    public String getGentle(){
        return gentle;
    }

    public void setGentle(String Gentle){
        this.gentle = Gentle;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String Role){
        this.role = Role;
    }
}

package com.example.movie_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{
    
}

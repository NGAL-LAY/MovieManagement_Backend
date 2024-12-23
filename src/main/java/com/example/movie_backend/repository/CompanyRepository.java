package com.example.movie_backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movie_backend.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{
    // Custom query to delete companies by a list of IDs
    void deleteByIdIn(List<Long> ids);
}

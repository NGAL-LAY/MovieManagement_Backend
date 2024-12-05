package com.example.movie_backend.service;
import java.util.List;
import com.example.movie_backend.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.repository.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    //fetch all companies
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    //fetch company by Id
    public Company getMovieById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    //register company
    public Company regCompany(Company company){
        return companyRepository.save(company);
    }
}

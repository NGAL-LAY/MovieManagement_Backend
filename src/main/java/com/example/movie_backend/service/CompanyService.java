package com.example.movie_backend.service;
import java.util.List;
import java.util.Optional;
import com.example.movie_backend.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movie_backend.repository.CompanyRepository;
import jakarta.transaction.Transactional;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    //fetch all companies
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    //fetch company by Id
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    //register company
    public Company regCompany(Company company){
        return companyRepository.save(company);
    }

    // delete company by id
    @Transactional
    public void delCompanyById(List<Long> ids)  {
        companyRepository.deleteByIdIn(ids);
    }

    // update company by id
    public Company updCompanyById(Long id, Company updateCompany){

        Optional<Company> existingCompanyOptional = companyRepository.findById(id);
        if(existingCompanyOptional.isPresent()){
        Company existCompany = existingCompanyOptional.get();
            if(updateCompany.getName() != null){
                existCompany.setName(updateCompany.getName());
            }
            if(updateCompany.getReleaseMovies() != 0){
                existCompany.setReleaseMovies(updateCompany.getReleaseMovies());
            }
            if(updateCompany.getCountry() != null)
            {
                existCompany.setCountry(updateCompany.getCountry());
            }
            if(updateCompany.getOpenDate() != null)
            {
                existCompany.setOpenDate(updateCompany.getOpenDate());
            }
            return companyRepository.save(existCompany);
        }else{
            throw new IllegalArgumentException("Company not found with ID: " + id);
        }
    }
}

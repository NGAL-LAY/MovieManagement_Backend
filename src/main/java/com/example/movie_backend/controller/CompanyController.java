package com.example.movie_backend.controller;
import java.util.List;
import com.example.movie_backend.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie_backend.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/companies")

public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    //fetch all companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        try {
            List<Company> companies = this.companyService.getAllCompanies();
        if(companies != null){
            return new ResponseEntity<>(companies,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    //fetch company by Id
    @GetMapping("/{id}")
    public ResponseEntity getCompanyById(@PathVariable Long id) {
        try {
            Company company = this.companyService.getMovieById(id);
            if(company != null){
                return new ResponseEntity<>(company,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //register company info
    @PostMapping
    public ResponseEntity<Company> registerCompany(@RequestBody Company company) {
        try {
            Company regCompany = this.companyService.regCompany(company);
            if (regCompany != null) {
                return new ResponseEntity<>(regCompany,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    
}

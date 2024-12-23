package com.example.movie_backend.controller;
import java.util.List;
import com.example.movie_backend.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie_backend.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
            Company company = this.companyService.getCompanyById(id);
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
    
    // update company
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompanyById(@PathVariable Long id, @RequestBody Company updateCompany) {
        try {
            Company existCompany = companyService.getCompanyById(id);
            if (existCompany != null) {
                Company updatedCompany = this.companyService.updCompanyById(id, updateCompany);
                return new ResponseEntity<>(updatedCompany, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete company
    @DeleteMapping
    public ResponseEntity<Void> deleteCompanyById(@RequestBody List<Long> ids) {
        try {
            if(ids != null){
                companyService.delCompanyById(ids);
                return new ResponseEntity<>(null,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
                
        }catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

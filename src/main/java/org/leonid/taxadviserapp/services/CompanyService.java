package org.leonid.taxadviserapp.services;

import org.leonid.taxadviserapp.dao.CompanyDAO;
import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyDAO companyRepository;

    public CompanyService(CompanyDAO companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }


    public boolean addCompany(Company company) {
        return companyRepository.addCompany(company);
    }

    public Company findCompanyById(int id) {
        return companyRepository.getCompanyById(id);
    }

    public Company findCompanyByName(String name) {
        return companyRepository.findCompanyByName(name);
    }

    public boolean updateCompany(Company company){
        return companyRepository.updateCompany(company);
    }

    public List<User> getUsersByCompanyId(int id){
        return companyRepository.getUsersByCompanyId(id);
    }

    public boolean deleteCompany(Company company) {
        return companyRepository.deleteCompany(company);
    }

}

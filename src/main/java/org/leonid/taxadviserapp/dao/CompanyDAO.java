package org.leonid.taxadviserapp.dao;

import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.User;

import java.util.List;

public interface CompanyDAO {

    List<Company> getAllUCompanies();
    List<Company> getCompanyById(int id);
    List<Company> findCompanyByName(String name);
    boolean addCompany(Company company);
    boolean updateCompany(Company company);
    boolean deleteCompany(Company company);
    List<User> getUsersByCompanyId(Long id);

}

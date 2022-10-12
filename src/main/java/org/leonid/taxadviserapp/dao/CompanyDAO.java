package org.leonid.taxadviserapp.dao;

public interface CompanyDAO {

    List<Company> getAllUCompanies();
    List<Company> getCompanyById(int id);
    List<Company> findCompanyByName(String name);
    boolean addCompany(Company company);
    boolean updateCompany(Company company);
    boolean deleteCompany(Company company);
    List<User> getUsersByCompanyId(Long id);

}

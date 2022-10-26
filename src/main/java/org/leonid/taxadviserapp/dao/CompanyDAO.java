package org.leonid.taxadviserapp.dao;

import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.User;

import javax.sql.DataSource;
import java.util.List;

public interface CompanyDAO {

    void setDataSource(DataSource dataSource);

    List<Company> getAllCompanies();

    Company getCompanyById(int id);

    Company findCompanyByName(String name);

    boolean addCompany(Company company);

    boolean updateCompany(Company company);

    boolean deleteCompany(Company company);

    List<User> getUsersByCompanyId(int id);

}

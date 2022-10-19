package org.leonid.taxadviserapp.dao.postgresql;

import org.leonid.taxadviserapp.dao.CompanyDAO;
import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.User;

import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {
    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company getCompanyById(int id) {
        return null;
    }

    @Override
    public Company findCompanyByName(String name) {
        return null;
    }

    @Override
    public boolean addCompany(Company company) {
        return false;
    }

    @Override
    public boolean updateCompany(Company company) {
        return false;
    }

    @Override
    public boolean deleteCompany(Company company) {
        return false;
    }

    @Override
    public List<User> getUsersByCompanyId(int id) {
        return null;
    }
}

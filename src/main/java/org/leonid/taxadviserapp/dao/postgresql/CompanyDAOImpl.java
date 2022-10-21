package org.leonid.taxadviserapp.dao.postgresql;

import org.leonid.taxadviserapp.dao.CompanyDAO;
import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static Logger LOGGER = Logger.getLogger(CompanyDAOImpl.class.getName());

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

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
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("company_name", company.getCompanyName());
        params.put("address", company.getAddress());
        params.put("company_type", company.getCompanyType());

        String sqlQuery = "INSERT INTO companies(company_name, address, company_type)\n" +
                "VALUES (:company_name, :address, :company_type);";

        try {
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }

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

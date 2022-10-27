package org.leonid.taxadviserapp.dao.postgresql;

import org.leonid.taxadviserapp.dao.CompanyDAO;
import org.leonid.taxadviserapp.dao.mappers.CompanyRowMapper;
import org.leonid.taxadviserapp.dao.mappers.UserRowMapper;
import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
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
        CompanyRowMapper mapper = new CompanyRowMapper();
        List<Company> list;

        String sqlQuery = "SELECT * FROM companies ORDER BY id DESC;";

        try {
            list = namedParameterJdbcTemplate.query(sqlQuery, mapper);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            list = new ArrayList<>();
        }

        return list;
    }

    @Override
    public Company getCompanyById(int id) {
        CompanyRowMapper mapper = new CompanyRowMapper();
        Map<String, Object> params = new HashMap<>();

        params.put("id", id);

        String sqlQuery = "SELECT * FROM companies WHERE id = :id;";

        try {
            return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, mapper);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.info(e.getMessage());
            return null;
        }

    }

    @Override
    public Company findCompanyByName(String name) {
        CompanyRowMapper mapper = new CompanyRowMapper();
        Map<String, Object> params = new HashMap<>();


        params.put("name", name);

        String sqlQuery = "SELECT * FROM companies WHERE name = :name;";

        try {
            return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, mapper);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean addCompany(Company company) {
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("company_name", company.getCompanyName());
        params.put("address", company.getAddress());
        params.put("company_type", company.getCompanyType());

        String sqlQuery = "INSERT INTO companies(company_name, company_type, address )\n" +
                "VALUES (:company_name, :company_type, :address);";

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
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("id", company.getId());
        params.put("company_name", company.getCompanyName());
        params.put("company_type", company.getCompanyType());
        params.put("address", company.getAddress());

        String sqlQuery = "UPDATE companies SET company_name = :company_name," +
                "company_type = :company_type, address = :address WHERE id = :id;";

        try {
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean deleteCompany(Company company) {
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("id", company.getId());

        String sqlUserQuery = "DELETE FROM users WHERE company_id = :id;";
        String sqlQuery = "DELETE FROM companies WHERE id = :id;";

        try {
            namedParameterJdbcTemplate.update(sqlUserQuery, params);
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }

    }

    @Override
    public List<User> getUsersByCompanyId(int id) {
        UserRowMapper mapper = new UserRowMapper();
        Map<String, Object> params = new HashMap<>();
        List<User> list;

        params.put("id", id);

        String sqlQuery = "SELECT u.id as id, name, birth_date, company_id, position, tax_incentive_id\n" +
                "FROM companies JOIN users u on companies.id = u.company_id " +
                "WHERE companies.id = :id;";

        try {
            list = namedParameterJdbcTemplate.query(sqlQuery, params, mapper);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            list = new ArrayList<>();
        }
        return list;
    }
}

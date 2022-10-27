package org.leonid.taxadviserapp.dao.postgresql;

import org.leonid.taxadviserapp.dao.TaxIncentivesDAO;
import org.leonid.taxadviserapp.dao.mappers.CompanyRowMapper;
import org.leonid.taxadviserapp.dao.mappers.TaxIncentiveRowMapper;
import org.leonid.taxadviserapp.dao.mappers.UserRowMapper;
import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.TaxIncentive;
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
public class TaxIncentiveDAOImpl implements TaxIncentivesDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static Logger LOGGER = Logger.getLogger(CompanyDAOImpl.class.getName());

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public List<TaxIncentive> getAllTaxIncentives() {
        TaxIncentiveRowMapper mapper = new TaxIncentiveRowMapper();
        List<TaxIncentive> list;

        String sqlQuery = "SELECT * FROM tax_incentives ORDER BY id DESC;";

        try {
            list = namedParameterJdbcTemplate.query(sqlQuery, mapper);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            list = new ArrayList<>();
        }

        return list;
    }

    @Override
    public TaxIncentive getTaxIncentiveById(int id) {
        TaxIncentiveRowMapper mapper = new TaxIncentiveRowMapper();
        Map<String, Object> params = new HashMap<>();

        params.put("id", id);

        String sqlQuery = "SELECT * FROM tax_incentives WHERE id = :id;";

        try {
            return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, mapper);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }

    @Override
    public TaxIncentive findTaxIncentiveByName(String name) {
        TaxIncentiveRowMapper mapper = new TaxIncentiveRowMapper();
        Map<String, Object> params = new HashMap<>();

        params.put("name", name);

        String sqlQuery = "SELECT * FROM tax_incentives WHERE name = :name;";

        try {
            return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, mapper);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean addTaxIncentive(TaxIncentive taxIncentive) {
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("tax_incentive_name", taxIncentive.getTaxIncentiveName());
        params.put("tax_incentive_percentage", taxIncentive.getTaxIncentivePercentage());
        params.put("company_type_for_tax_incentive", taxIncentive.getCompanyTypeForTaxIncentive());
        params.put("age_Range_for_tax_incentive", taxIncentive.getAgeRangeForTaxIncentive());

        String sqlQuery = "INSERT INTO tax_incentives(tax_incentive_name, tax_incentive_percentage, company_type_for_tax_incentive, age_Range_for_tax_incentive)\n" +
                "VALUES (:tax_incentive_name, :tax_incentive_percentage, :company_type_for_tax_incentive, :age_Range_for_tax_incentive);";

        try {
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateTaxIncentive(TaxIncentive taxIncentive) {
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("tax_incentive_id", taxIncentive.getTaxIncentiveId());
        params.put("tax_incentive_name", taxIncentive.getTaxIncentiveName());
        params.put("tax_incentive_percentage", taxIncentive.getTaxIncentivePercentage());
        params.put("company_type_for_tax_incentive", taxIncentive.getCompanyTypeForTaxIncentive());
        params.put("age_Range_for_tax_incentive", taxIncentive.getAgeRangeForTaxIncentive());

        String sqlQuery = "UPDATE  tax_incentives SET tax_incentive_name = :tax_incentive_name, " +
                "tax_incentive_percentage = :tax_incentive_percentage, " +
                "company_type_for_tax_incentive = :company_type_for_tax_incentive, " +
                "age_Range_for_tax_incentive = :age_Range_for_tax_incentive " +
                "WHERE id = :id;";


        try {
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteTaxIncentive(TaxIncentive taxIncentive) {
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("id", taxIncentive.getTaxIncentiveId());

        String sqlQuery = "DELETE FROM tax_incentives WHERE tax_incentive_id = :id;";

        try {
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    @Override
    public List<User> getUsersByTaxIncentiveId(int id) {
        UserRowMapper mapper = new UserRowMapper();
        Map<String, Object> params = new HashMap<>();
        List<User> list;

        params.put("id", id);

        String sqlQuery = "SELECT u.id as id, name, birth_date, company_id, tax_incentive_id\n" +
                "FROM tax_incentives JOIN users u on tax_incentives.id = u.tax_incentive_id\n" +
                "WHERE tax_incentives.id = null;";

        try {
            list = namedParameterJdbcTemplate.query(sqlQuery, params, mapper);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public List<Company> getCompaniesByTaxIncentiveId(int id) {
        CompanyRowMapper mapper = new CompanyRowMapper();
        Map<String, Object> params = new HashMap<>();
        List<Company> list;

        params.put("id", id);

        String sqlQuery = "SELECT companies.id as id, company_name, company_type, address " +
                "FROM companies JOIN tax_incentives ON companies.company_type=tax_incentives.company_type_for_tax_incentive " +
                "WHERE tax_incentives.id = 1";

        try {
            list = namedParameterJdbcTemplate.query(sqlQuery, params, mapper);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            list = new ArrayList<>();
        }
        return list;
    }
}

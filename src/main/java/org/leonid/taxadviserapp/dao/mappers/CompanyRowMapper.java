package org.leonid.taxadviserapp.dao.mappers;

import org.leonid.taxadviserapp.entities.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRowMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();

        company.setId(rs.getInt("id"));
        company.setCompanyName(rs.getString("company_name"));
        company.setCompanyType(rs.getString("company_type"));
        company.setAddress(rs.getString("address"));

        return company;
    }
}

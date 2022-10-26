package org.leonid.taxadviserapp.dao.mappers;

import org.leonid.taxadviserapp.entities.TaxIncentive;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxIncentiveRowMapper implements RowMapper<TaxIncentive> {

    @Override
    public TaxIncentive mapRow(ResultSet rs, int rowNum) throws SQLException {
        TaxIncentive taxIncentive = new TaxIncentive();

        taxIncentive.setTaxIncentiveId(rs.getInt("id"));
        taxIncentive.setTaxIncentiveName(rs.getString("tax_incentive_name"));
        taxIncentive.setTaxIncentivePercentage(rs.getFloat("tax_incentive_percentage"));
        taxIncentive.setCompanyTypeForTaxIncentive(rs.getString("company_type_for_tax_incentive"));
        taxIncentive.setAgeRangeForTaxIncentive(rs.getInt("age_range_for_tax_incentive"));

        return taxIncentive;
    }
}

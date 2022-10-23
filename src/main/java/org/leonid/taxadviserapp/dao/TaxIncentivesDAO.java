package org.leonid.taxadviserapp.dao;

import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.TaxIncentive;
import org.leonid.taxadviserapp.entities.User;

import javax.sql.DataSource;
import java.util.List;

public interface TaxIncentivesDAO {

    void setDataSource(DataSource dataSource);

    List<TaxIncentive> getAllTaxIncentives();

    TaxIncentive getTaxIncentiveById(int id);

    TaxIncentive findTaxIncentiveByName(String name);

    boolean addTaxIncentive(TaxIncentive taxIncentive);

    boolean updateTaxIncentive(TaxIncentive taxIncentive);

    boolean deleteTaxIncentive(TaxIncentive taxIncentive);

    List<User> getUsersByTaxIncentiveId(int id);

    List<Company> getCompaniesByTaxIncentiveId(int id);
}

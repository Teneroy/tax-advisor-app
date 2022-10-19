package org.leonid.taxadviserapp.dao.postgresql;

import org.leonid.taxadviserapp.dao.TaxIncentivesDAO;
import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.TaxIncentive;
import org.leonid.taxadviserapp.entities.User;

import java.util.List;

public class TaxIncentiveDAOImpl implements TaxIncentivesDAO {
    @Override
    public List<TaxIncentive> getAllTaxIncentives() {
        return null;
    }

    @Override
    public TaxIncentive getTaxIncentiveById(int id) {
        return null;
    }

    @Override
    public TaxIncentive findTaxIncentiveByName(String name) {
        return null;
    }

    @Override
    public boolean addTaxIncentive(TaxIncentive taxIncentive) {
        return false;
    }

    @Override
    public boolean updateTaxIncentive(TaxIncentive taxIncentive) {
        return false;
    }

    @Override
    public boolean deleteTaxIncentive(TaxIncentive taxIncentive) {
        return false;
    }

    @Override
    public List<User> getUsersByTaxIncentiveId(int id) {
        return null;
    }

    @Override
    public List<Company> getCompaniesByTaxIncentiveId(int id) {
        return null;
    }
}

package org.leonid.taxadviserapp.services;

import org.leonid.taxadviserapp.dao.TaxIncentivesDAO;
import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.TaxIncentive;
import org.leonid.taxadviserapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxIncentivesService {

    private final TaxIncentivesDAO taxIncentivesRepository;

    public TaxIncentivesService(TaxIncentivesDAO taxIncentivesRepository) {
        this.taxIncentivesRepository = taxIncentivesRepository;
    }

    public List<TaxIncentive> getAllTaxIncentives(){
        return taxIncentivesRepository.getAllTaxIncentives();
    }

    public boolean addTaxIncentive(TaxIncentive taxIncentive){
        return taxIncentivesRepository.addTaxIncentive(taxIncentive);
    }

    public TaxIncentive findTaxIncentiveById(int id) {
        return taxIncentivesRepository.getTaxIncentiveById(id);
    }

    public TaxIncentive findTaxIncentiveByName(String name) {
        return taxIncentivesRepository.findTaxIncentiveByName(name);
    }

    public boolean updateTaxIncentive(TaxIncentive taxIncentive){
        return taxIncentivesRepository.updateTaxIncentive(taxIncentive);
    }

    public List<User> getUsersByTaxIncentiveId(int id) {
        return taxIncentivesRepository.getUsersByTaxIncentiveId(id);
    }

    public List<Company> getCompaniesByTaxIncentiveId(int id) {
        return taxIncentivesRepository.getCompaniesByTaxIncentiveId(id);
    }
    public boolean deleteTaxIncentive(TaxIncentive taxIncentive) {
        return taxIncentivesRepository.deleteTaxIncentive(taxIncentive);
    }

}

package org.leonid.taxadviserapp.controllers;

import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.TaxIncentive;
import org.leonid.taxadviserapp.entities.User;
import org.leonid.taxadviserapp.services.TaxIncentivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TaxIncentiveController {

    private final TaxIncentivesService taxService;

    @Autowired
    public TaxIncentiveController(TaxIncentivesService taxService) {
        this.taxService = taxService;
    }


    @PostMapping("/addTaxIncentive")
    public Map<String, Object> writeTaxIncentiveParams(
            @RequestParam String taxIncentiveName,
            @RequestParam String companyTypeForTaxIncentive,
            @RequestParam float taxIncentivePercentage,
            @RequestParam int ageRangeForTaxIncentive
    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);

        if (taxIncentiveName == null) {
            response.put("error", "TaxIncentive's name can't be null");
            return response;
        }

        if (companyTypeForTaxIncentive == null) {
            response.put("error", "Company's type can't be null");
            return response;
        }

        if (taxIncentivePercentage == 0) {
            response.put("error", "TaxIncentive percentage can't be zero");
            return response;
        }

        if (ageRangeForTaxIncentive == 0) {
            response.put("error", "TaxIncentive age range can't be zero");
            return response;
        }

        if(!taxService.addTaxIncentive(new TaxIncentive(taxIncentiveName, companyTypeForTaxIncentive, taxIncentivePercentage, ageRangeForTaxIncentive))) {
            response.put("error", "An error has occurred during the writing to the database");
            return response;
        }

        response.put("success", true);
        response.put("error", "");
        return response;
    }

    @PostMapping("/getTaxIncentiveById")
    public TaxIncentive getTaxIncentiveById(@RequestParam int taxIncentiveId) {
        return taxService.findTaxIncentiveById(taxIncentiveId);
    }

    @PostMapping("/getAllTaxIncentives")
    public List<TaxIncentive> getAllTaxIncentives() {
        return taxService.getAllTaxIncentives();
    }

    @PostMapping("/getTaxIncentiveByName")
    public TaxIncentive findTaxIncentiveByName(@RequestParam String companyName) {
        return taxService.findTaxIncentiveByName(companyName);
    }

    @PostMapping("/getUsersByTaxIncentiveId")
    public List<User> getUsersByTaxIncentiveId(@RequestParam int taxIncentiveId) {
        return taxService.getUsersByTaxIncentiveId(taxIncentiveId);
    }

}

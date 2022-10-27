package org.leonid.taxadviserapp.controllers;

import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.services.CompanyService;
import org.leonid.taxadviserapp.services.TaxIncentivesService;
import org.leonid.taxadviserapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/addCompany")
    public Map<String, Object> writeCompanyParams(
            @RequestParam String companyName,
            @RequestParam String companyType,
            @RequestParam String address
    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);

        if (companyName == null) {
            response.put("error", "Company's name can't be null");
            return response;
        }

        if (companyType == null) {
            response.put("error", "Company's type can't be null");
            return response;
        }

        if (address == null) {
            response.put("error", "Address can't be null");
            return response;
        }

        if(!companyService.addCompany(new Company(companyName, companyType, address))) {
            response.put("error", "An error has occurred during the writing to the database");
            return response;
        }

        response.put("success", true);
        response.put("error", "");
        return response;

    }

}

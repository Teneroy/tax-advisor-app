package org.leonid.taxadviserapp.controllers;


import org.leonid.taxadviserapp.entities.Company;
import org.leonid.taxadviserapp.entities.TaxIncentive;
import org.leonid.taxadviserapp.entities.User;
import org.leonid.taxadviserapp.services.CompanyService;
import org.leonid.taxadviserapp.services.TaxIncentivesService;
import org.leonid.taxadviserapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@RestController
public class MainController {
    private final UserService userService;
    private final CompanyService companyService;
    private final TaxIncentivesService taxService;

    @Autowired
    public MainController(UserService userService, CompanyService companyService, TaxIncentivesService taxService) {
        this.userService = userService;
        this.companyService = companyService;
        this.taxService = taxService;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello, world";
    }

    @PostMapping("/addUser")
    public Map<String, Object> writeParams(
            @RequestParam String name,
            @RequestParam LocalDate birthDate,
            @RequestParam int companyId
    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);

        if (name == null) {
            response.put("error", "User's name can't be null");
            return response;
        }

        if (birthDate == null) {
            response.put("error", "User's birthDate can't be null");
            return response;
        }

        if (companyId < 0) {
            response.put("error", "Id can't be zero");
            return response;
        }

        if(!userService.addUser(new User(name, birthDate, companyId))) {
            response.put("error", "An error has occurred during the writing to the database");
            return response;
        }

        response.put("success", true);
        response.put("error", "");
        return response;

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

}

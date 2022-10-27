package org.leonid.taxadviserapp.controllers;

import org.leonid.taxadviserapp.entities.User;
import org.leonid.taxadviserapp.services.CompanyService;
import org.leonid.taxadviserapp.services.TaxIncentivesService;
import org.leonid.taxadviserapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
}

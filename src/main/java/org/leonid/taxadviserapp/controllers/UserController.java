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
import java.util.List;
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

    @PostMapping("/getUserById")
    public User getId(@RequestParam int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/getUserByName")
    public User getUserByName(@RequestParam String userName) {
        return userService.searchUserByName(userName);
    }

//    @PostMapping("/deleteUserById")
//    public User deleteUser(@RequestParam String userName) {
//        return userService.searchUserByName(userName);
//    }
//
//    @PostMapping("/updateUser")
//    public Map<String, Object> updateUser(@RequestParam String name,
//                                          @RequestParam LocalDate birthDate,
//                                          @RequestParam int companyId,
//                                          @RequestParam int taxIncentiveId,
//                                          @RequestParam String position) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("success", false);
//        if (name == null) {
//            response.put("error", "User's name can't be null");
//            return response;
//        }
//
//        if (birthDate == null) {
//            response.put("error", "User's birthDate can't be null");
//            return response;
//        }
//
//        if (companyId < 0) {
//            response.put("error", "Company id can't be zero");
//            return response;
//        }
//
//        if (taxIncentiveId < 0) {
//            response.put("error", "Tax incentive id can't be zero");
//            return response;
//        }
//
//        if (position == null) {
//            response.put("error", "User's position can't be null");
//            return response;
//        }
//
//        if(!userService.updateUser(new User(name,  companyId, position, birthDate, taxIncentiveId))) {
//            response.put("error", "An error has occurred during the writing to the database");
//            return response;
//        }
//
//        response.put("success", true);
//        response.put("error", "");
//
//        return response;
//    }


}

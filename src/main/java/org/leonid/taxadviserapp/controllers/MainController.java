package org.leonid.taxadviserapp.controllers;


import org.leonid.taxadviserapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello, world";
    }

    @GetMapping("/getUserById")
    public String getUserById(@RequestParam("id") int id){
        return userService.getUserById(id);
    }
}

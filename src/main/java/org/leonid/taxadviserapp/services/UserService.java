package org.leonid.taxadviserapp.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserById(int id){
        return "Leonid" + id;
    }
}

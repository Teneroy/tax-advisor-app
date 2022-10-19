package org.leonid.taxadviserapp.services;

import org.leonid.taxadviserapp.dao.UserDAO;
import org.leonid.taxadviserapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDAO userRepository;

    public UserService(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User searchUsersByName(String name) {


        return userRepository.findUserByName(name);
    }

    public boolean updateUser(User user){
        return userRepository.updateUser(user);
    }

    public boolean deleteUser(User user) {
        return userRepository.deleteUser(user);
    }



}
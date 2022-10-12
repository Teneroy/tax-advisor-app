package org.leonid.taxadviserapp.dao;

import org.leonid.taxadviserapp.entities.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
    List<User> getUserById(int id);
    List<User> findUserByName(String name);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);

}

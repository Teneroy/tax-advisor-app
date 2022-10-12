package org.leonid.taxadviserapp.dao;

import org.leonid.taxadviserapp.entities.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(int id);

    User findUserByName(String name);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);

}

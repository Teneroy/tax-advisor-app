package org.leonid.taxadviserapp.dao;

import org.leonid.taxadviserapp.entities.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserDAO {

    void setDataSource(final DataSource dataSource);

    List<User> getAllUsers();

    User getUserById(int id);

    User findUserByName(String name);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);

}

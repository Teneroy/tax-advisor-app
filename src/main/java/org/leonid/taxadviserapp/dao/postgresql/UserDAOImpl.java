package org.leonid.taxadviserapp.dao.postgresql;

import org.leonid.taxadviserapp.dao.UserDAO;
import org.leonid.taxadviserapp.dao.mappers.UserRowMapper;
import org.leonid.taxadviserapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class UserDAOImpl implements UserDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAllUsers() {
        UserRowMapper mapper = new UserRowMapper();
        List<User> list;

        String sqlQuery = "SELECT users.id as id, name, birth_date, company_id, company_name " +
                "FROM users JOIN companies c on users.company_id = c.id ORDER BY id DESC;";

        try {
            list = namedParameterJdbcTemplate.query(sqlQuery, mapper);
        } catch (DataAccessException e) {
            list = new ArrayList<>();
            LOGGER.info(e.getMessage());
        }
        return list;
    }

    @Override
    public User getUserById(int id) {
        UserRowMapper mapper = new UserRowMapper();
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        String sqlQuery = "SELECT users.id as id, name, birth_date, company_id " +
                "FROM users JOIN companies c on users.company_id = c.id " +
                "WHERE users.id = :id;";

        try {
            return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, mapper);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return null;
        }

    }

    @Override
    public User findUserByName(String name) {
        UserRowMapper mapper = new UserRowMapper();
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);

        String sqlQuery = "select";

        try {
            return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, mapper);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean addUser(User user) {
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("name", user.getName());
        params.put("birth_date", user.getBirthDate());
        params.put("company_id", user.getCompanyId());

        String sqlQuery = "INSERT INTO users (name, birth_date, company_id)\n" +
                "VALUES(:name, :birth_date, :company_id);";

        try {
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean updateUser(User user) {
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("id", user.getId());
        params.put("name", user.getName());;
        params.put("birth_date", user.getBirthDate());
        params.put("company_id", user.getCompanyId());

        String sqlQuery = "UPDATE users " +
                "SET name = :name, " +
                "birth_date = date(:birth_date), company_id = :company_id " +
                "WHERE id = :id;";

        try {
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean deleteUser(User user) {
        Map<String, Object> params = new HashMap<>();
        int affectedRows;

        params.put("id", user.getId());

        String sqlQuery = "DELETE FROM users WHERE id = :id;";

        try {
            affectedRows = namedParameterJdbcTemplate.update(sqlQuery, params);
            return (affectedRows == 1);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }
    }
}

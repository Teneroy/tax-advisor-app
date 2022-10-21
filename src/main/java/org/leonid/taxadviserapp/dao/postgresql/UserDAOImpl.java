package org.leonid.taxadviserapp.dao.postgresql;

import org.leonid.taxadviserapp.dao.UserDAO;
import org.leonid.taxadviserapp.dao.mappers.UserRawMapper;
import org.leonid.taxadviserapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
        return null;
    }

    @Override
    public User getUserById(int id) {
        UserRawMapper mapper = new UserRawMapper();
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
        return null;
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
            //e.printStackTrace();
            LOGGER.info(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}

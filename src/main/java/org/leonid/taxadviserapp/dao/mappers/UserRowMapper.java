package org.leonid.taxadviserapp.dao.mappers;

import org.leonid.taxadviserapp.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        Date date = (Date) rs.getObject("birth_date");
        user.setBirthDate(date.toLocalDate());

        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setCompanyId(rs.getInt("company_id"));

        user.setCompanyName(rs.getString("company_name"));
        user.setPosition(rs.getString("position"));

        return user;

    }

}

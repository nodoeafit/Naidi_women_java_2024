
package com.estramipyme.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estramipyme.repositories.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setActive(rs.getBoolean("isActive"));
            return user;
        }
    };

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM \"User\"";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    public User getUser(Integer id) {
        String sql = "SELECT * FROM \"User\" WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, userRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Transactional
    public void insertUser(User user) {
        String sql = "INSERT INTO \"User\" (\"username\", \"email\", \"isActive\") VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.isActive());
    }

    @Transactional
    public void updateUser(User user) {
        String sql = "UPDATE \"User\" SET \"username\" = ?, \"email\" = ?, \"isActive\" = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.isActive(), user.getId());
    }

    @Transactional
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM \"User\" WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

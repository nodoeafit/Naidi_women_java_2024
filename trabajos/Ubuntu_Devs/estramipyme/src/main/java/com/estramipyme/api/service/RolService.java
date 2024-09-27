package com.estramipyme.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.estramipyme.repositories.models.Rol;

import java.util.List;

@Service
public class RolService {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public RolService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Rol> getAllRol() {
        String sql = "SELECT * FROM \"Rol\"";
        jdbcTemplate.queryForList(sql);
        List<Rol> roles = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Rol rol = new Rol();
            rol.setId(rs.getInt("id"));
            rol.setNombreRol(rs.getString("nombreRol"));
            rol.setFechaCreacionRol(rs.getString("fechaCreacionRol"));
            rol.setActiveRol(rs.getBoolean("isActiveRol"));
            return rol;
        });
        return roles;
    }

    public Rol getRol(Integer id) {
        String sql = "SELECT * FROM \"Rol\" WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Rol rol = new Rol();
            rol.setId(rs.getInt("id"));
            rol.setNombreRol(rs.getString("nombreRol"));
            rol.setFechaCreacionRol(rs.getString("fechaCreacionRol"));
            rol.setActiveRol(rs.getBoolean("isActiveRol"));
            return rol;
        }, id);
    }

    public void insertRol(Rol rol) {
        String sql = "INSERT INTO \"Rol\" (\"nombreRol\", \"fechaCreacionRol\", \"isActiveRol\") VALUES (CURRENT_TIMESTAMP, ?, true)";
        jdbcTemplate.update(sql, rol.getNombreRol());
    }
}

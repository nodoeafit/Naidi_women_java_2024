package com.estramipyme.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.estramipyme.repositories.models.Rol;

import java.util.List;

@Service
public class RolService {
    private final JdbcTemplate jdbcTemplate;
    // Inyecta JdbcTemplate usando el constructor
    @Autowired
    public RolService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Ejemplo de un método para obtener todos los registros de la tabla Rol
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

    // Ejemplo de un método para insertar un nuevo Rol
    public void insertRol(Rol rol) {
        String sql = "INSERT INTO \"Rol\" (\"nombreRol\", \"fechaCreacionRol\", \"isActiveRol\") VALUES (CURRENT_TIMESTAMP, ?, true)";
        jdbcTemplate.update(sql, rol.getNombreRol());
    }
}

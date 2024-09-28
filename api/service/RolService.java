package com.estramipyme.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.estramipyme.api.dto.RolDto;
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
        try {
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
    }catch (Exception e) {
        System.err.println("Error al obtener todos los roles: " + e.getMessage());
        throw e;
    }
}

    public Rol getRol(Integer id) {
        String sql = "SELECT * FROM \"Rol\" WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Rol rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombreRol(rs.getString("nombreRol"));
                rol.setFechaCreacionRol(rs.getString("fechaCreacionRol"));
                rol.setActiveRol(rs.getBoolean("isActiveRol"));
                return rol;
            }, id);
        } catch (Exception e) {
            System.err.println("Error al obtener el rol: " + e.getMessage());
            throw e;
        }
    }

    
    public void insertRol(RolDto rol) {
        String sql = "INSERT INTO \"Rol\" (\"nombreRol\", \"fechaCreacionRol\", \"isActiveRol\") VALUES (?, CURRENT_TIMESTAMP, true)";

        try {
            jdbcTemplate.update(sql, rol.getNombreRol());
            
        } catch (Exception e) {
            System.err.println("Error al insertar el rol: " + e.getMessage());
            throw e;
        }
   
    }

    public void deleteRol(Integer id) {
        String sql = "DELETE FROM \"Rol\" WHERE \"id\" = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            System.err.println("Error al eliminar el rol: " + e.getMessage());
            throw e;
        }
  
    }

    public void updateRol(RolDto rol) {
       String sql = "UPDATE \"Rol\" SET \"nombreRol\" = ?, \"isActiveRol\" = ? WHERE \"id\"";
       try {
           jdbcTemplate.update(sql, rol.getNombreRol(), rol.getIsActiveRol());
       } catch (Exception e) {
           System.err.println("Error al actualizar el rol: " + e.getMessage());
           throw e;
       }
    }
}


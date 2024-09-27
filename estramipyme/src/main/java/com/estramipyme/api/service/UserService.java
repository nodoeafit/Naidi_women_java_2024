package com.estramipyme.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.estramipyme.api.dto.UserDto;
import com.estramipyme.repositories.models.Rol;
import com.estramipyme.repositories.models.User;

import java.util.List;

@Service
public class UserService {
    private final JdbcTemplate jdbcTemplate;
    // Inyecta JdbcTemplate usando el constructor
    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // Ejemplo de un método para obtener todos los registros de la tabla User
    public List<User> getAllUser() {
        String sql = "SELECT * FROM \"User\"";
        try {
        jdbcTemplate.queryForList(sql);
        List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNombre(rs.getString("nombre"));
            user.setApellido(rs.getString("apellido"));
            user.setCorreo(rs.getString("email"));
            user.setContrasena(rs.getString("password"));
            user.setIsActiveUser(rs.getBoolean("isActive"));
            user.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            user.setIsPyme(rs.getBoolean("isPyme"));
            user.setTelefono(rs.getString("telefono"));
            user.setDireccion(rs.getString("direccion"));
            user.setDocId(rs.getString("docId"));
            Rol role = new Rol();
            role.setNombreRol(rs.getString("role"));
            user.setRole(role);
            return user;
        });       
         return users;
    }catch (Exception e) {
        System.err.println("Error al obtener todos los usuarios: " + e.getMessage());
        throw e;
    }
}
    public User getUser(Integer id) {
        String sql = "SELECT * FROM \"User\" WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setCorreo(rs.getString("email"));
                user.setContrasena(rs.getString("password"));
                user.setIsActiveUser(rs.getBoolean("isActive"));
                user.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                user.setIsPyme(rs.getBoolean("isPyme"));
                user.setTelefono(rs.getString("telefono"));
                user.setDireccion(rs.getString("direccion"));
                user.setDocId(rs.getString("docId"));
                // Resolver la duda sobre la parte de rol en usuario
                Rol role = new Rol();
                user.setRole(role);
                return user;
            }, id);
        } catch (Exception e) {
            System.err.println("Error al obtener el usuario: " + e.getMessage());
            throw e;
        }
}
    public void insertUser(UserDto user) {
        String sql = "INSERT INTO \"User\" (nombre, apellido, email, password, isActive, fechaNacimiento, isPyme, telefono, direccion, docId, idRol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, user.getNombre());
        } catch (Exception e) {
            System.err.println("Error al insertar el usuario: " + e.getMessage());
            throw e;
        }
    }
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM \"User\" WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            System.err.println("Error al eliminar el usuario: " + e.getMessage());
            throw e;
        }
    }
   public void updateUser(UserDto user) {
        String sql = "UPDATE \"User\" SET nombre = ?, apellido = ?, email = ?, password = ?, isActive = ?, fechaNacimiento = ?, isPyme = ?, telefono = ?, direccion = ?, docId = ?, idRol = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, user.getNombre(), user.getApellido(), user.getCorreo(), user.getContrasena(), user.getIsActiveUser(), user.getFechaNacimiento(), user.getIsPyme(), user.getTelefono(), user.getDireccion(), user.getDocId(), user.getRole(), user.getId());
        } catch (Exception e) {
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
            throw e;
        }
    }
public UserDto getUserById(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
}
    

}

    

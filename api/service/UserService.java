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

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserDto> getAllUsers() {
        String sql = "SELECT * FROM \"User\"";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserDto userDto = new UserDto();
            userDto.setId(rs.getInt("id"));
            userDto.setNombre(rs.getString("nombre"));
            userDto.setApellido(rs.getString("apellido"));
            userDto.setCorreo(rs.getString("email"));
            userDto.setContrasena(rs.getString("password")); // Consider security
            userDto.setIsActiveUser(rs.getBoolean("isActive"));
            userDto.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            userDto.setIsPyme(rs.getBoolean("isPyme"));
            userDto.setTelefono(rs.getString("telefono"));
            userDto.setDireccion(rs.getString("direccion"));
            userDto.setDocId(rs.getString("docId"));
            Rol roleDto = new Rol();
            roleDto.setNombreRol(rs.getString("role"));
            userDto.setRole(roleDto);
            return userDto;
        });
    }

    public UserDto getUser(Integer id) {
        String sql = "SELECT * FROM \"User\" WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            UserDto userDto = new UserDto();
            userDto.setId(rs.getInt("id"));
            userDto.setNombre(rs.getString("nombre"));
            userDto.setApellido(rs.getString("apellido"));
            userDto.setCorreo(rs.getString("email"));
            userDto.setContrasena(rs.getString("password")); // Consider security
            userDto.setIsActiveUser(rs.getBoolean("isActive"));
            userDto.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            userDto.setIsPyme(rs.getBoolean("isPyme"));
            userDto.setTelefono(rs.getString("telefono"));
            userDto.setDireccion(rs.getString("direccion"));
            userDto.setDocId(rs.getString("docId"));
            Rol roleDto = new Rol();
            roleDto.setNombreRol(rs.getString("role"));
            userDto.setRole(roleDto);
            return userDto;
        }, id);
    }

    public void insertUser(UserDto userDto) {
        String sql = "INSERT INTO \"User\" (nombre, apellido, email, password, isActive, fechaNacimiento, isPyme, telefono, direccion, docId, idRol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, userDto.getNombre(), userDto.getApellido(), userDto.getCorreo(),
                userDto.getContrasena(), userDto.getIsActiveUser(),
                userDto.getFechaNacimiento(), userDto.getIsPyme(),
                userDto.getTelefono(), userDto.getDireccion(),
                userDto.getDocId(), userDto.getRole().getId());
    }

    public void deleteUser(Integer id) {
        String sql = "DELETE FROM \"User\" WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateUser(UserDto userDto) {
        String sql = "UPDATE \"User\" SET nombre = ?, apellido = ?, email = ?, password = ?, isActive = ?, fechaNacimiento = ?, isPyme = ?, telefono = ?, direccion = ?, docId = ?, idRol = ? WHERE id = ?";
        jdbcTemplate.update(sql, userDto.getNombre(), userDto.getApellido(), userDto.getCorreo(),
                userDto.getContrasena(), userDto.getIsActiveUser(),
                userDto.getFechaNacimiento(), userDto.getIsPyme(),
                userDto.getTelefono(), userDto.getDireccion(),
                userDto.getDocId(), userDto.getRole().getId(), userDto.getId());
    }

    public List<UserDto> getUserByRole(String rol) {
        String sql = "SELECT * FROM \"User\" WHERE idRol = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserDto userDto = new UserDto();
            userDto.setId(rs.getInt("id"));
            userDto.setNombre(rs.getString("nombre"));
            userDto.setApellido(rs.getString("apellido"));
            userDto.setCorreo(rs.getString("email"));
            userDto.setContrasena(rs.getString("password")); // Consider security
            userDto.setIsActiveUser(rs.getBoolean("isActive"));
            userDto.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            userDto.setIsPyme(rs.getBoolean("isPyme"));
            userDto.setTelefono(rs.getString("telefono"));
            userDto.setDireccion(rs.getString("direccion"));
            userDto.setDocId(rs.getString("docId"));
            Rol roleDto = new Rol();
            roleDto.setNombreRol(rs.getString("role"));
            userDto.setRole(roleDto);
            return userDto;
        }, rol);
    }
}

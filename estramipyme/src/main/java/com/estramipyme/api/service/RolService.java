package com.estramipyme.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.estramipyme.api.dto.RolDto;
import com.estramipyme.data.models.Rol;
import com.estramipyme.data.repositories.RolRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolService {

    private final RolRepository _rolRepository;

    // private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RolService(RolRepository rolRepository, JdbcTemplate jdbcTemplate) {
        _rolRepository = rolRepository;
        // this.jdbcTemplate = jdbcTemplate;
    }

    public List<RolDto> findAll() {
        List<RolDto> roles = new ArrayList();
        List<Rol> rols = _rolRepository.findAll();
        for (Rol rol : rols) {
            roles.add(
                    new RolDto(
                            rol.getId(),
                            rol.getNombreRol(),
                            rol.getFechaCreacionRol(),
                            rol.isActiveRol()));
        }
        return roles;
    }

    public Rol findById(Integer id) {
        // String sql = "SELECT * FROM Rol WHERE id = ?";
        try {
            var rol = _rolRepository.findById(id);
            rol.setId(id);
            rol.setNombreRol(rol.getNombreRol());
            rol.setActiveRol(rol.isActiveRol());
            rol.setFechaCreacionRol(rol.getFechaCreacionRol());
            return rol;
        } catch (Exception e) {
            System.err.println("Error al obtener el rol: " + e.getMessage());
            throw e;
        }
    }

    public void save(RolDto rolDto) {
        try {
            var rol = new Rol();
            rol.setNombreRol(rolDto.getNombreRol());
           // rol.setActiveRol(isActiveRol: true); 
            rol.setFechaCreacionRol(rolDto.getFechaCreacionRol());
            _rolRepository.save(rol);
    
        } catch (Exception e) {
            System.err.println("Error al insertar el rol: " + e.getMessage());
            throw e;
        }
    }

    public void delete(Integer id) {
        // String sql = "DELETE FROM Rol WHERE id = ?";
        try {
            _rolRepository.delete(id);

        } catch (Exception e) {
            System.err.println("Error al eliminar el rol: " + e.getMessage());
            throw e;
        }
    }

    public void update(RolDto roldDto) {
        // String sql = "UPDATE Rol SET nombreRol = ?, isActiveRol = ? WHERE id = ?";
        try {
            var rol = new Rol();
            rol.setNombreRol(roldDto.getNombreRol());
            rol.setActiveRol(roldDto.getIsActiveRol());
            rol.setId(rol.getId());
            _rolRepository.update(rol);
        } catch (Exception e) {
            System.err.println("Error al actualizar el rol: " + e.getMessage());
            throw e;
        }
    }
}

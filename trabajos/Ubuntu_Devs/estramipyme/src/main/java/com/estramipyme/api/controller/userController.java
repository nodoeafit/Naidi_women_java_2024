package com.estramipyme.api.controller;

import com.estramipyme.api.dto.RolDto;
import com.estramipyme.repositories.models.Rol;
import com.estramipyme.api.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Obtener todos los roles
    @GetMapping
    public ResponseEntity<List<RolDto>> getAllRoles() {
        List<Rol> roles = rolService.getAllRol();
        List<RolDto> rolDtos = roles.stream()
                .map(rol -> new RolDto(rol.getId(), rol.getNombreRol(), rol.getFechaCreacionRol(), rol.isActiveRol()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(rolDtos);
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<RolDto> getRol(@PathVariable Integer id) {
        Rol rol = rolService.getRol(id);
        if (rol != null) {
            RolDto rolDto = new RolDto(rol.getId(), rol.getNombreRol(), rol.getFechaCreacionRol(), rol.isActiveRol());
            return ResponseEntity.ok(rolDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo rol
    @PostMapping
    public ResponseEntity<RolDto> createRol(@RequestBody RolDto rolDto) {
        Rol rol = new Rol();
        rol.setNombreRol(rolDto.getNombreRol());
        rol.setActiveRol(rolDto.getIsActiveRol());
        // Aquí podrías establecer la fecha de creación según sea necesario
        rolService.insertRol(rol);
        rolDto.setId(rol.getId()); // Suponiendo que el ID se genera en la inserción
        return ResponseEntity.status(HttpStatus.CREATED).body(rolDto);
    }

    // Actualizar un rol existente
    @PutMapping("/{id}")
    public ResponseEntity<RolDto> updateRol(@PathVariable Integer id, @RequestBody RolDto rolDto) {
        Rol rol = new Rol();
        rol.setId(id);
        rol.setNombreRol(rolDto.getNombreRol());
        rol.setActiveRol(rolDto.getIsActiveRol());
        // Aquí podrías actualizar la fecha si es necesario
        rolService.updateRol(rol);
        return ResponseEntity.ok(rolDto);
    }

    // Eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}

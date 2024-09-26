package com.estramipyme.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estramipyme.api.dto.RolDto;
import com.estramipyme.api.service.RolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rol")
@Tag(name = "Rol Controller", description = "Operaciones para gestionar roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/")
    @Operation(summary = "Obtener Roles", description = "Usado para obtener todos los roles")
    public List<RolDto> getAllRoll() {
        List<RolDto> roles = new ArrayList<>();
        rolService.getAllRol().forEach(rol -> roles.add(new RolDto(
                rol.getId(),
                rol.getNombreRol(),
                rol.getFechaCreacionRol(),
                rol.isActiveRol())));
        return roles;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Rol", description = "Usado para obtener un rol específico")
    public ResponseEntity<RolDto> getRoll(@PathVariable Integer id) {
        var rol = rolService.getRol(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        RolDto rolDto = new RolDto(rol.getId(), rol.getNombreRol(), rol.getFechaCreacionRol(), rol.isActiveRol());
        return ResponseEntity.ok(rolDto);
    }

    @PostMapping()
    @Operation(summary = "Crea rol", description = "Usado para crear un rol")
    public ResponseEntity<RolDto> createUser(@Valid @RequestBody RolDto rolDto) {
        var nuevoRol = rolService.createRol(rolDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }
}

package com.estramipyme.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estramipyme.api.service.RolService;
import com.estramipyme.api.dto.RolDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;

//No remuevas las librerías de arriba, te van a servir :D

@RestController
@RequestMapping("/api/rol")
public class RolController {

	private final RolService rolService;

	// Constructor de nuestro servicio
	public RolController(RolService rolService) {
		this.rolService = rolService;
	}

	@GetMapping("/")
	@Operation(summary = "Obtener Rol", description = "Usado para obtener Rol")
	public List<RolDto> getAllRoll() {

		List<RolDto> roles = new ArrayList();
		rolService.getAllRol().forEach(rol -> roles.add(new RolDto(
				rol.getId(),
				rol.getNombreRol(),
				rol.getFechaCreacionRol(),
				rol.isActiveRol())));
		return roles;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener Rol", description = "Usado para obtener un Rol")
	public RolDto getRoll(@PathVariable Integer id) {
		RolDto rolDto = new RolDto();
		rolDto = rolService.getRol(id);
		return rolDto;
	}

	@PostMapping()
	@Operation(summary = "Crea rol", description = "Usado para crear un rol")
	public RolDto createUser(@RequestBody(description = "Crear Usuario", required = true) RolDto rolDto) {

		System.out.println(rolDto.getNombreRol());
		rolService.createRol(rolDto);
		return rolDto;
	}
}

package com.estramipyme.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estramipyme.api.service.RolService;
import com.estramipyme.api.dto.RolDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

//No remuevas las librerías de arriba, te van a servir :D

@RestController
@RequestMapping("/api/rol")
public class RolController {

	private final RolService rolService;

	// Constructor de nuestro servicio
	public RolController(RolService rolService) {
		this.rolService = rolService;
	}

	@GetMapping("/all")
	@Operation(summary = " Obtener Rol", description = "Usado para obtener Rol")
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
		var rol = rolService.getRol(id);
		rolDto.setId(rol.getId());
		rolDto.setNombreRol(rol.getNombreRol());
		rolDto.setFechaCreacionRol(rol.getFechaCreacionRol());
		rolDto.setIsActiveRol(rol.isActiveRol());
		return rolDto;
	}

	@PostMapping("/create")
	@Operation(summary = "Crea rol", description = "Usado para crear un rol")
	public RolDto insertRol(@RequestBody(description = "Crear Rol", required = true) RolDto rolDto) {
		rolService.insertRol(rolDto);
		return rolDto;
		
	}



	@PutMapping("/{id}")
	@Operation(summary = "Actualizar Rol", description = "Usado para actualizar un Rol")
	public RolDto updateRol(@PathVariable Integer id, @RequestBody RolDto rolDto) {
		//RolDto rol = new Rol();
			rolService.updateRol(rolDto);
		
		
		return rolDto; 
	}

	@DeleteMapping("api/rol/{id}")
	@Operation(summary = "Eliminar Rol", description = "Usado para eliminar un Rol")
	public void deleteRol(@PathVariable Integer id) {
		rolService.deleteRol(id);
	}

}



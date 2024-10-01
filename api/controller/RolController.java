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

	@GetMapping("/rol")
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

	@PostMapping("/create")
	@Operation(summary = "Crea rol", description = "Usado para crear un rol")
	public RolDto createUser(@RequestBody(description = "Crear Usuario", required = true) RolDto rolDto) {
		// RolDto RolDto = new RolDto();
		// rolDto.setId(rolDto.getId());
		// rolDto.setNombreRol(rolDto.getNombreRol());
		// rolDto.setFechaCreacionRol(rolDto.getFechaCreacionRol());
		// rolDto.setIsActiveRol(rolDto);
		rolService.insertRol(rolDto);
		return rolDto;

	}

	@PutMapping("/{id}")
	//documenta operaciomes de una API REST y proporciona una nueva description de que hara
	@Operation(summary = "Actualizar Rol", description = "Usado para actualizar un Rol")
	//Captura el valor del id desde la URL. 
	public RolDto updateRol(@PathVariable Integer id, @RequestBody RolDto rolDto) {
		// RolDto rol = new Rol();
		rolService.updateRol(rolDto);

		return rolDto;
	}

	@DeleteMapping("api/rol/{id}")
	@Operation(summary = "Eliminar Rol", description = "Usado para eliminar un Rol")
	public void deleteRol(@PathVariable Integer id) {
		rolService.deleteRol(id);
	}

}

package com.estramipyme.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/saludo")
public class SaludoController {
	
	@GetMapping()
	@Operation(summary="Obtener saludos", description="Usado para obtener un saludo")
	public String saludo() {
		return "Welcome! - Bienvenido!";
	}
	
	@GetMapping("/{id}")
	@Operation(summary="Obtener saludos para un id", description="Usado para obtener un saludo")
	public String saludoId(@RequestBody(description="id usuario", required=true, ref="123")
	@PathVariable Long id) {
		return "Welcome User: "
				.concat(id.toString())
				.concat("! - Bienvenido Usuario: ")
				.concat(id.toString()).concat("!");
	}
	
	@PostMapping()
	@Operation(summary="Crea Usuario", description="Usado para crear un usuario")
	public String createUser(@RequestBody(description="Crear Usuario", required=true)
	@RequestAttribute String user){
		return "Usuario creado: ".concat(user);
	}


}

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
import com.estramipyme.api.service.UserService;
import com.estramipyme.api.dto.RolDto;
import com.estramipyme.api.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todos los usuarios", description = "Usado para obtener la lista de usuarios")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    @Operation(summary = "Crear usuario", description = "Usado para crear un nuevo usuario")
    public UserDto createUser(@RequestBody(description = "Crear Usuario", required = true) UserDto userDto) {
        userService.insertUser(userDto);
        return userDto;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Usado para actualizar un usuario")
    public UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        userDto.setId(id); // Asegúrate de que el ID se establezca correctamente
        userService.updateUser(userDto);
        return userDto;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Usado para eliminar un usuario")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}

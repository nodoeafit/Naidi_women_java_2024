package com.estramipyme.api.controller;

import java.sql.Date; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estramipyme.api.service.UserService;
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

    @GetMapping("/all")
    @Operation(summary = "Obtener todos los usuarios")
    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<>();
        userService.getAllUser().forEach(user -> users.add(new UserDto(
                user.getId(),
                user.getNombre(),
                user.getApellido(),
                user.getDocId(), 
                user.getCorreo(),
                user.getContrasena(),
                new Date(user.getFechaNacimiento().getTime()),
                user.getTelefono(),
                user.getDireccion(),
                user.getRole(),
                user.getIsActiveUser(),
                user.getIsPyme()
        )));
        return users;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por su ID")
    public UserDto getUserById(@PathVariable Integer id) {
        var user = userService.getUserById(id);
        return new UserDto(
                user.getId(),
                user.getNombre(),
                user.getApellido(),
                user.getDocId(),
                user.getCorreo(),
                user.getContrasena(),
                new Date(user.getFechaNacimiento().getTime()),
                user.getTelefono(),
                user.getDireccion(),
                user.getRole(),
                user.getIsActiveUser(),
                user.getIsPyme()
        );
    }

    @PostMapping("/create")
    @Operation(summary = "Crear un nuevo usuario")
    public UserDto createUser(@RequestBody UserDto userDto) {
        userService.insertUser(userDto);
        return userDto;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario por su ID")
    public UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        userService.updateUser(userDto);
        return userDto;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario por su ID")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}

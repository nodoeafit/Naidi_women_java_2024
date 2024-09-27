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

 //   @GetMapping("/all")
   // @Operation(summary = "Obtener todos los usuarios")
//    public List<UserDto> getAllUsers() {
//     List<UserDto> users = new ArrayList();
  //    userService.getAllUser().forEach(user -> users.add(new UserDto(
//                user.getId(),
  //            user.getNombre(),
    //            user.getApellido(),
      //          user.getCorreo(),
        //        user.getContrasena(),
          //      user.getTelefono(),
            //    user.getDireccion(),
              //  user.getFechaNacimiento(),
   //             user.getIsActiveUser(),
     //           user.getDocId(),
       //         user.getIsPyme()
           

       // )));
       // return users;
    //}

  //  @GetMapping("/{id}")
   // @Operation(summary = "Obtener un usuario por su ID")
   // public UserDto getUserById(@PathVariable Integer id) {
     //   userService.getUserById(id);
    //}

    @PostMapping("/create")
    @Operation(summary = "Crear un nuevo usuario")
    public UserDto createUser(@RequestBody UserDto userDto) {
        userService.insertUser(userDto);
        return userDto;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario por su ID")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        return userDto;
    }

    @DeleteMapping
    @Operation(summary = "Eliminar un usuario por su ID")   
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }




}


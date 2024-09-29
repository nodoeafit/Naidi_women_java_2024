package com.estramipyme.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "docId")
    private String docId;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")    
    private Rol role;

    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)    
    private Date fechaNacimiento;

    @Column(name = "isPyme")   
    private Boolean isPyme;

    @Column(name = "isActiveUser")
    private Boolean isActiveUser;
}
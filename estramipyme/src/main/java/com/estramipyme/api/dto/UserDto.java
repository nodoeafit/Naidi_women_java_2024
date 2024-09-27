package com.estramipyme.api.dto;

import java.sql.Date;

import com.estramipyme.repositories.models.Rol;

public class UserDto {
    private int id;
    private String nombre;
    private String apellido;
    private String docId;
    private String correo;
    private String contrasena;
    private Date fechaNacimiento;
    private String telefono;
    private String direccion;
    private Rol role;
    private Boolean isActiveUser;
    private Boolean isPyme;

    public UserDto() {
    }

    public UserDto(int id, String nombre, String apellido, String docId, String correo, String contrasena, Date fechaNacimiento, String telefono, String direccion, Rol role, Boolean isActiveUser, Boolean isPyme) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.docId = docId;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.role = role;
        this.isActiveUser = isActiveUser;
        this.isPyme = isPyme;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDocId() {
        return docId;
    }
    public String getCorreo() {
        return correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public Rol getRole() {
        return role;
    }
    public Boolean getIsActiveUser() {
        return isActiveUser;
    }
    public Boolean getIsPyme() {
        return isPyme;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;

    }
    public void setDocId(String docId) {
        this.docId = docId;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setFechaNacimiento( Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;

    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setRole(Rol role) {
        this.role = role;
    }
    public void setIsActiveUser(Boolean isActiveUser) {
        this.isActiveUser = isActiveUser;
    }
    public void setIsPyme(Boolean isPyme) {
        this.isPyme = isPyme;
    }

}

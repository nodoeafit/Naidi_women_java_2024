package com.estramipyme.api.dto;

import java.time.LocalDateTime;

public class RolDto {
    private int id;
    private String nombreRol;
    private LocalDateTime fechaCreacionRol; // Cambié a LocalDateTime para manejar fechas correctamente
    private Boolean isActiveRol;

    public RolDto() {
    }

    public RolDto(int id, String nombreRol, LocalDateTime fechaCreacionRol, Boolean isActiveRol) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.fechaCreacionRol = fechaCreacionRol;
        this.isActiveRol = isActiveRol;
    }

    public int getId() {
        return id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public LocalDateTime getFechaCreacionRol() { // Cambié el tipo de retorno a LocalDateTime
        return fechaCreacionRol;
    }

    public Boolean getIsActiveRol() {
        return isActiveRol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public void setFechaCreacionRol(LocalDateTime fechaCreacionRol) { // Cambié el tipo de parámetro a LocalDateTime
        this.fechaCreacionRol = fechaCreacionRol;
    }

    public void setIsActiveRol(Boolean isActiveRol) {
        this.isActiveRol = isActiveRol;
    }
}

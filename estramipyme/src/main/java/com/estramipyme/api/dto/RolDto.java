package com.estramipyme.api.dto;

public class RolDto {
    private int id;
    private String nombreRol;
    private String fechaCreacionRol;
    private Boolean isActiveRol;

    public RolDto() {
    }

    public RolDto(int id, String nombreRol, String fechaCreacionRol, Boolean isActiveRol) {
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

    public String getFechaCreacionRol() {
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

    public void setFechaCreacionRol(String fechaCreacionRol) {
        this.fechaCreacionRol = fechaCreacionRol;
    }

    public void setIsActiveRol(Boolean isActiveRol) {
        this.isActiveRol = isActiveRol;
    }
}

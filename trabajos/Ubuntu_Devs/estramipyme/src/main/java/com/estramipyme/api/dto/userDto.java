package com.estramipyme.api.dto;

public class UserDto {
    private int id;
    private String username;
    private String email;
    private boolean isActive;

    // Constructor vacío
    public UserDto() {
    }

    // Constructor con parámetros
    public UserDto(int id, String username, String email, boolean isActive) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.isActive = isActive;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}

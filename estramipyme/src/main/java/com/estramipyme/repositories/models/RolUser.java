package com.estramipyme.repositories.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "RolUser")
public class RolUser {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idUsers")
    private int idUsers;
    
    @Column(name = "idRoles")
    private int idRoles;
    
    @Column(name = "isActive")
    private boolean isActive;

}
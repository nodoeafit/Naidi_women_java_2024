package com.estramipyme.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Logs")
public class Logs {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fechaCreacionLog")
    private String fechaCreacionLog;
    
    @Column(name = "descripcionLog")
    private String descripcionLog;
    
    @Column(name = "stackError")
    private String stackError;
}
package com.bedu.inventario.entity;

import jakarta.persistence.*;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;
    private String nombreMarca;

    public Marca( String nombreMarca){

        this.nombreMarca=nombreMarca;
    }
    protected Marca(){};
    public String getNombreMarca() {
        return nombreMarca;
    }

    public Long getIdMarca() {
        return idMarca;
    }
}

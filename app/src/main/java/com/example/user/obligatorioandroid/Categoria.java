package com.example.user.obligatorioandroid;

import java.io.Serializable;

public class Categoria implements Serializable {
    private String Nombre;
    private  Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public Categoria() {
    }

    public Categoria(String nombre, Integer id) {
        Nombre = nombre;
        Id = id;
    }
}

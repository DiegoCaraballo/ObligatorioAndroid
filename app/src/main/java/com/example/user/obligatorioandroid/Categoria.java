package com.example.user.obligatorioandroid;

import java.io.Serializable;

public class Categoria implements Serializable {
    private String Nombre;
    private  int Id;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Categoria() {
    this("UnaCat",1);
    }

    public Categoria(String nombre, int id) {
        Nombre = nombre;
        Id = id;
    }


}

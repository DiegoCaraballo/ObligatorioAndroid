package com.example.user.obligatorioandroid;

import android.content.Intent;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable {
    private Double Precio;
    private  String Foto ;
    private  String Descripcion ;
    private  String Nombre ;
    private  Categoria categoria ;
    private Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto(Double precio, String foto, String descripcion, String nombre, Categoria categoria, Integer id) {
        Precio = precio;
        Foto = foto;
        Descripcion = descripcion;
        Nombre = nombre;
        this.categoria = categoria;
        Id = id;
    }

    public Producto() {

    }
}

package com.example.user.obligatorioandroid;

import java.io.Serializable;

public class Producto implements Serializable {
    private  String Precio;
    private  String Foto ;
    private  String Descripcion ;
    private  String Nombre ;
    private  Categoria categoria ;

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
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

    public Producto(String precio, String foto, String descripcion, String nombre, Categoria categoria) {
        Precio = precio;
        Foto = foto;
        Descripcion = descripcion;
        Nombre = nombre;
        this.categoria = categoria;
    }

    public Producto() {
        this("100","asdas","asda","asd", null);//TODO ver como paso la categoria y la foto
    }
}

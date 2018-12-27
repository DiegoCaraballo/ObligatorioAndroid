package com.example.user.obligatorioandroid;

import android.text.BoringLayout;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {
    private  Boolean Pago_Adelantado ;
    private Boolean Entregado ;
    private  Integer Cantidad ;
    private  String Cliente ;
    private Producto Prod ;
    private Integer ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public Boolean getPago_Adelantado() {
        return Pago_Adelantado;
    }

    public void setPago_Adelantado(Boolean pago_Adelantado) {
        Pago_Adelantado = pago_Adelantado;
    }

    public Boolean getEntregado() {
        return Entregado;
    }

    public void setEntregado(Boolean entregado) {
        Entregado = entregado;
    }

    public Producto getProd() {
        return Prod;
    }

    public void setProd(Producto prod) {
        Prod = prod;
    }

    public Pedido() {
    }

    public Pedido(Boolean pago_Adelantado, Boolean entregado, Integer cantidad, String cliente, Producto prod, Integer ID) {
        Pago_Adelantado = pago_Adelantado;
        Entregado = entregado;
        Cantidad = cantidad;
        Cliente = cliente;
        Prod = prod;
        this.ID = ID;
    }
}

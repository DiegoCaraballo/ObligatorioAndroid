package com.example.user.obligatorioandroid;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {
    public  String Pago_Adelantado ;
    public  String Entregado ;
    public  String Cantidad ;
    public  String Cliente ;
    public List<Producto> ListaProd ;

    public String getPago_Adelantado() {
        return Pago_Adelantado;
    }

    public void setPago_Adelantado(String pago_Adelantado) {
        Pago_Adelantado = pago_Adelantado;
    }

    public String getEntregado() {
        return Entregado;
    }

    public void setEntregado(String entregado) {
        Entregado = entregado;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public List<Producto> getListaProd() {
        return ListaProd;
    }

    public void setListaProd(List<Producto> listaProd) {
        ListaProd = listaProd;
    }

    public Pedido() {
    }

    public Pedido(String pago_Adelantado, String entregado, String cantidad, String cliente, List<Producto> listaProd) {
        Pago_Adelantado = pago_Adelantado;
        Entregado = entregado;
        Cantidad = cantidad;
        Cliente = cliente;
        ListaProd = listaProd;
    }
}

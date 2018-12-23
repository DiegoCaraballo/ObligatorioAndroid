package com.example.user.obligatorioandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Detalle_Producto_Fragment extends Fragment {
    protected TextView tvNombre;
    protected TextView tvPrecio;
    protected TextView tvDescripcion;

    public static Detalle_Producto_Fragment newInstance() { return new Detalle_Producto_Fragment();}

    public Detalle_Producto_Fragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void mostrarProd(Producto prod){
        tvNombre.setText(String.valueOf(prod.getNombre()));
        tvDescripcion.setText(String.valueOf(prod.getDescripcion()));
        tvPrecio.setText(String.valueOf(prod.getPrecio()));
    }
}

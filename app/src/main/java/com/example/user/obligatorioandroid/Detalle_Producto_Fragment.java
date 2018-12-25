package com.example.user.obligatorioandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle_Producto_Fragment extends Fragment {

    public static Detalle_Producto_Fragment newInstance() { return new Detalle_Producto_Fragment();}

    protected TextView tvNombre;
    protected TextView tvPrecio;
    protected TextView tvDesc;
    protected ImageView imgFoto;


    public Detalle_Producto_Fragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_detalle_producto,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvPrecio = (TextView)getView().findViewById(R.id.tvPrecio);
        tvNombre = (TextView)getView().findViewById(R.id.tvNombre);
        tvDesc = (TextView)getView().findViewById(R.id.tvDescripcion);
       // imgFoto = (ImageView)getView().findViewById(R.id.imgFoto);
    }

    public void mostrarProd(Producto prod){
        tvNombre.setText(String.valueOf(prod.getNombre()));
        tvDesc.setText(String.valueOf(prod.getDescripcion()));
        tvPrecio.setText(String.valueOf(prod.getPrecio()));
       }
}

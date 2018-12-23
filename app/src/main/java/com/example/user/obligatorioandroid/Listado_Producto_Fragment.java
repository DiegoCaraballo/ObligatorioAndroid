package com.example.user.obligatorioandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class Listado_Producto_Fragment extends Fragment {

    public static  Listado_Producto_Fragment newTnstance(){ return  new Listado_Producto_Fragment();}

    protected ListView lvProd;

    public static final String MIS_LOGS = "MIS_LOGS";

    protected  OnProdSeleccionadoListener onProdSeleccionadoListener;

    private SimpleCursorAdapter adaptadorProducto;
    private BD_Helper bdHelper;
    private SQLiteDatabase baseDatos;


    public Listado_Producto_Fragment(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProdSeleccionadoListener){
            onProdSeleccionadoListener = (OnProdSeleccionadoListener)context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_lista_producto, container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e(MIS_LOGS, "OnActivityCrerated");

        bdHelper = new BD_Helper(getContext());
        baseDatos = bdHelper.getWritableDatabase();

        lvProd = (ListView)getView().findViewById(R.id.lvsProductos);

        List<Producto> productos = new ArrayList<>();

        adaptadorProducto = new SimpleCursorAdapter(getContext(),R.layout.lista_productos,listarProducto(), Base_Datos.Producto.Columnas,
                new int[]{R.id.tvId,R.id.tvPrecio,R.id.imgFoto,R.id.tvDescripcion,R.id.tvNombre,R.id.tvCategoria},0);

        Log.e(MIS_LOGS, "Antes de cargar el listado");
        lvProd.setAdapter(adaptadorProducto);
        Log.e(MIS_LOGS, "Despues de cargar el listado" + adaptadorProducto);

        lvProd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvProdOnItemClick(parent,view,position,id);
            }
        });

    }

    protected void lvProdOnItemClick(AdapterView<?> parent, View view, int position, long id){
        if (onProdSeleccionadoListener != null){
            onProdSeleccionadoListener.onProdSeleccionado((Producto)parent.getItemAtPosition(position));
        }
    }

    protected Cursor listarProducto(){
        return baseDatos.query(Base_Datos.PRODUCTO, Base_Datos.Producto.Columnas, null,null,null,null, Base_Datos.Producto._ID+ " DESC");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onProdSeleccionadoListener = null;
    }

    public interface  OnProdSeleccionadoListener{
        void onProdSeleccionado(Producto prod);
    }
}

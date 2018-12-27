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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Listado_Producto_Fragment extends Fragment {

    public static  Listado_Producto_Fragment newTnstance(){ return  new Listado_Producto_Fragment();}

    private SimpleCursorAdapter adaptadorProducto;
    private SimpleCursorAdapter adaptadorCategoria;
    private BD_Helper bdHelper;
    private SQLiteDatabase baseDatos;

    protected ListView lvProd;

    public static final String MIS_LOGS = "MIS_LOGS";

    protected  OnProdSeleccionadoListener onProdSeleccionadoListener;

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

        bdHelper = new BD_Helper(getContext());
        baseDatos = bdHelper.getReadableDatabase();

        lvProd = (ListView)getView().findViewById(R.id.lvsProductos);

       // List<Producto> productos = new ArrayList<>();

        //TODO ver si no jode mucho como podemos hacer para crear una lista de producto en lugar de cargarlos desde la bd
        adaptadorProducto = new SimpleCursorAdapter(getContext(),
                R.layout.fragment_lista_producto,
                listarProducto(), Base_Datos.Producto.Columnas,
                new int[]{R.id.tvId,R.id.tvPrecio,R.id.imgFoto,R.id.tvDescripcion,R.id.tvNombre,R.id.tvCategoria}
                ,0);

        lvProd.setAdapter(adaptadorProducto);

        lvProd.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvProdOnItemClick(parent,view,position,id);
            }
        });

    }

    protected void lvProdOnItemClick(AdapterView<?> parent, View view, int position, long id){
       // if (onProdSeleccionadoListener != null){
         //   onProdSeleccionadoListener.onProdSeleccionado((Producto)parent.getItemAtPosition(position));
       // }
        Cursor cursor = ((SimpleCursorAdapter)adaptadorProducto).getCursor();
        cursor.moveToPosition(position);

        int columnaID = cursor.getColumnIndex(Base_Datos.Producto._ID);
        int columnaNombre = cursor.getColumnIndex(Base_Datos.Producto.Nombre);
        int columnaDesc = cursor.getColumnIndex(Base_Datos.Producto.Descripcion);
        int columnaPrecio = cursor.getColumnIndex(Base_Datos.Producto.Precio);

        Producto pro = new Producto();
        pro.setId(cursor.getInt(columnaID));
        pro.setNombre(cursor.getString(columnaNombre));
        pro.setPrecio(cursor.getDouble(columnaPrecio));
        pro.setDescripcion(cursor.getString(columnaDesc));

        if (onProdSeleccionadoListener != null){
            onProdSeleccionadoListener.onProdSeleccionado(pro);
         }

    }

    protected Cursor listarProducto(){
        return baseDatos.query(Base_Datos.PRODUCTO, Base_Datos.Producto.Columnas,
                null,null,null,null,
                Base_Datos.Producto._ID+ " ASC");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onProdSeleccionadoListener = null;
    }

    public interface OnProdSeleccionadoListener {
        void onProdSeleccionado(Producto prod);
    }


}

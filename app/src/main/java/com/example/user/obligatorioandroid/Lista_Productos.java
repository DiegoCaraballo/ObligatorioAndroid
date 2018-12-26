package com.example.user.obligatorioandroid;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Lista_Productos extends AppCompatActivity implements  Listado_Producto_Fragment.OnProdSeleccionadoListener{

    private ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
    private ArrayList<String> categoriaList;
    private Spinner spCategoria;
    private BD_Helper bdHelper;
    private SQLiteDatabase baseDatos;
    public static final String MIS_LOGS = "MIS_LOGS";

    protected GridView gvProductos;
    public static final String EXTRA_PROD = "EXTRA_PROD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_productos);

        listarCategorias();
        spCategoria = (Spinner)findViewById(R.id.spCategoria);
        ArrayAdapter<String> adaptadorCategoria = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item, categoriaList);
        adaptadorCategoria.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spCategoria.setAdapter(adaptadorCategoria);

    }

    @Override
    public void onProdSeleccionado(Producto prod) {
        Detalle_Producto_Fragment frgDetalleProd = (Detalle_Producto_Fragment)getSupportFragmentManager().findFragmentById(R.id.frgDetalleProducto);

        if (frgDetalleProd != null) {
            frgDetalleProd.mostrarProd(prod);
        }
        else{
            Intent intencionDetalleProd = new Intent(this,Detalle_Producto.class);
            intencionDetalleProd.putExtra(EXTRA_PROD,prod);

            startActivity(intencionDetalleProd);
        }

    }

    private void listarCategorias(){

        bdHelper = new BD_Helper(this);
        baseDatos = bdHelper.getReadableDatabase();
        Categoria categoria = null;

        Cursor cursor = baseDatos.rawQuery("SELECT * FROM " + Base_Datos.CATEGORIA, null);

        while (cursor.moveToNext()){
            categoria = new Categoria();

            categoria.setId(cursor.getInt(0));
            categoria.setNombre(cursor.getString(1));

            listaCategorias.add(categoria);
        }

        obtenerListaCategorias();
    }

    private void obtenerListaCategorias(){

        categoriaList = new ArrayList<String>();
        categoriaList.add("Seleccione");

        for(int i = 0; i < listaCategorias.size(); i++){

            categoriaList.add((listaCategorias.get(i).getId() + " - " + listaCategorias.get(i).getNombre()));

        }

    }
}

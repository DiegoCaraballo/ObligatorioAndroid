package com.example.user.obligatorioandroid;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MIS_LOGS = "MIS_LOGS";

    private BD_Helper bdHelper;
    private SQLiteDatabase baseDatos;
    private SimpleCursorAdapter adaptadorArtistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(MIS_LOGS,"Entro al main activity OnCreate");
        bdHelper = new BD_Helper(this);
        baseDatos = bdHelper.getWritableDatabase();
        Log.e(MIS_LOGS,"Llego al final del OnCreate");

        agregarDatosPrueba();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){

            case R.id.action_Pendientes:
                Log.e(MIS_LOGS, "Entra en la actividad Pendientes");
                startActivity(new Intent(getApplicationContext(), Lista_Pendientes.class));
                return true;
            case R.id.action_Productos:
                Log.e(MIS_LOGS, "Entra en la actividad Productos");
                startActivity(new Intent(getApplicationContext(), Lista_Productos.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void agregarDatosPrueba(){
        ContentValues valores = new ContentValues();

        baseDatos.beginTransaction();

        Log.e(MIS_LOGS, "Ingreso a agregarDaosPrueba");

        try{
            //Categorias
            valores.put(Base_Datos.Categoria.Nombre,"BIJOUTERIE");
            baseDatos.insert(Base_Datos.CATEGORIA,null,valores);

            valores.clear();
            valores.put(Base_Datos.Categoria.Nombre,"PERFUME");
            baseDatos.insert(Base_Datos.CATEGORIA,null,valores);

            valores.clear();
            valores.put(Base_Datos.Categoria.Nombre,"COSMETICOS");
            baseDatos.insert(Base_Datos.CATEGORIA,null,valores);
            Log.e(MIS_LOGS,"Empieza carga datos");
            //Productos
            valores.clear();

            valores.put(Base_Datos.Producto.Precio,"100");
            valores.put(Base_Datos.Producto.Foto,("drawable://" + R.drawable.biju1));
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 1");
            valores.put(Base_Datos.Producto.Nombre,"Art 1");
            valores.put(Base_Datos.Producto.Id_Categoria,"1");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);
            Log.e(MIS_LOGS,"Cargo la 1");
            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"1500");
            valores.put(Base_Datos.Producto.Foto, ("drawable://" + R.drawable.biju2));
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 1");
            valores.put(Base_Datos.Producto.Nombre,"Art2");
            valores.put(Base_Datos.Producto.Id_Categoria,"1");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);

            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"3000");
            valores.put(Base_Datos.Producto.Foto,Uri.parse("res:///" + R.drawable.biju3).toString());
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 1");
            valores.put(Base_Datos.Producto.Nombre,"Art3");
            valores.put(Base_Datos.Producto.Id_Categoria,"1");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);


            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"68");
            valores.put(Base_Datos.Producto.Foto,Uri.parse("res:///" + R.drawable.perfume1).toString());
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 2");
            valores.put(Base_Datos.Producto.Nombre,"Art 5");
            valores.put(Base_Datos.Producto.Id_Categoria,"2");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);

            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"1204");
            valores.put(Base_Datos.Producto.Foto,Uri.parse("res:///" + R.drawable.perfume2).toString());
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 2");
            valores.put(Base_Datos.Producto.Nombre,"Art 6");
            valores.put(Base_Datos.Producto.Id_Categoria,"2");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);

            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"77");
            valores.put(Base_Datos.Producto.Foto,Uri.parse("res:///" + R.drawable.perfume3).toString());
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 2");
            valores.put(Base_Datos.Producto.Nombre,"Art 7");
            valores.put(Base_Datos.Producto.Id_Categoria,"2");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);


            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"150");
            valores.put(Base_Datos.Producto.Foto,Uri.parse("res:///" + R.drawable.cosmeticos1).toString());
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 3");
            valores.put(Base_Datos.Producto.Nombre,"Art 9");
            valores.put(Base_Datos.Producto.Id_Categoria,"3");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);

            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"120");
            valores.put(Base_Datos.Producto.Foto,Uri.parse("res:///" + R.drawable.cosmeticos2).toString());
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 3");
            valores.put(Base_Datos.Producto.Nombre,"Art 10");
            valores.put(Base_Datos.Producto.Id_Categoria,"3");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);

            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"50");
            valores.put(Base_Datos.Producto.Foto,Uri.parse("res:///" + R.drawable.cosmeticos3).toString());
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 3");
            valores.put(Base_Datos.Producto.Nombre,"Art 10");
            valores.put(Base_Datos.Producto.Id_Categoria,"3");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);

            valores.clear();
            valores.put(Base_Datos.Producto.Precio,"50");
            valores.put(Base_Datos.Producto.Foto,Uri.parse("res:///" + R.drawable.cosmeticos4).toString());
            valores.put(Base_Datos.Producto.Descripcion,"ARTICULO PRUEBA CAT 3");
            valores.put(Base_Datos.Producto.Nombre,"Art 10");
            valores.put(Base_Datos.Producto.Id_Categoria,"3");
            baseDatos.insert(Base_Datos.PRODUCTO,null,valores);

            Log.e(MIS_LOGS, "LLego al final deagregarDaosPrueba");

            baseDatos.setTransactionSuccessful();

        }
        catch (Exception ex){
            Log.e(MIS_LOGS,"No se puedieron cargar los datos");
        }
        finally {
            baseDatos.endTransaction();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        baseDatos.close();

       // bdHelper.eliminarBaseDatos();
    }

}

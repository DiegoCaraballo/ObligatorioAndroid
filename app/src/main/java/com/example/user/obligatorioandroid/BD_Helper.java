package com.example.user.obligatorioandroid;

import android.app.NotificationChannel;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.util.MissingFormatArgumentException;

public class BD_Helper extends SQLiteOpenHelper {

    private Context contexto;
    public static final String MIS_LOGS = "MIS_LOGS";
    private SQLiteDatabase baseDatos;


    @Override
    public void onCreate(SQLiteDatabase baseDatos) {

        baseDatos.execSQL(Base_Datos.Categoria.CREAR_TABLA);

        baseDatos.execSQL(Base_Datos.Producto.CREAR_TABLA);

        baseDatos.execSQL(Base_Datos.Pedido.CREAR_TABLA);
        baseDatos.execSQL(new StringBuilder("INSERT INTO ").append(Base_Datos.CATEGORIA).append(" VALUES (NULL,'BIJOUTERIE');").toString());
      //agregarDatosPrueba();

    }


    @Override
    public void onUpgrade(SQLiteDatabase baseDatos,  int oldVersion, int newVersion) {

          baseDatos.execSQL(Base_Datos.Categoria.ELIMINAR_TABLA);
          baseDatos.execSQL(Base_Datos.Producto.ELIMINAR_TABLA);
          baseDatos.execSQL(Base_Datos.Pedido.ELIMINAR_TABLA);
          onCreate(baseDatos);

      }
    public BD_Helper(Context contexto){
        super(contexto, Base_Datos.NOMBRE_BD,null, Base_Datos.VERSION_BD);
        this.contexto = contexto;
    }

    public void eliminarBaseDatos() {
        contexto.deleteDatabase(Base_Datos.NOMBRE_BD);
    }
}

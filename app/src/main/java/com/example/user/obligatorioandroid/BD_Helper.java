package com.example.user.obligatorioandroid;

import android.app.NotificationChannel;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.MissingFormatArgumentException;

public class BD_Helper extends SQLiteOpenHelper {

    private Context contexto;
    public static final String MIS_LOGS = "MIS_LOGS";

    @Override
    public void onCreate(SQLiteDatabase baseDatos) {

        Log.e(MIS_LOGS, "Entra en BD_HELPER");

        baseDatos.execSQL(Base_Datos.Categoria.CREAR_TABLA);

        Log.e(MIS_LOGS, "CREA LA TABLA CATEGORIA");

        baseDatos.execSQL(Base_Datos.Producto.CREAR_TABLA);

        Log.e(MIS_LOGS, "CREA LA TABLA PRODUCTO");

        baseDatos.execSQL(Base_Datos.Pedido.CREAR_TABLA);

        Log.e(MIS_LOGS, "CREA LA TABLA PEDIDO");

        //baseDatos.execSQL(new StringBuilder("INSERT INTO ").append(Base_Datos.CATEGORIA).append(" VALUES (NULL, 'Cosmeticos');").toString());
        //baseDatos.execSQL(new StringBuilder("INSERT INTO ").append(Base_Datos.CATEGORIA).append(" VALUES (NULL, 'Bijouterie');").toString());
        //baseDatos.execSQL(new StringBuilder("INSERT INTO ").append(Base_Datos.CATEGORIA).append(" VALUES (NULL, 'Perfumes');").toString());

        Log.e(MIS_LOGS, "Se agregaron datos categoria");

       //baseDatos.execSQL(new StringBuilder("INSERT INTO ").append(Base_Datos.PRODUCTO).append(" VALUES (NULL, '100', '"+ R.drawable.biju1+"', 'Articulo de test', 'test', '1');").toString());

        Log.e(MIS_LOGS, "Se agregaron datos Producto");

        //baseDatos.execSQL(new StringBuilder("INSERT INTO ").append(Base_Datos.PEDIDO).append(" VALUES (NULL, 'si', 'si', '13', 'Cliente Test', '1');").toString());

        Log.e(MIS_LOGS, "Se agregaron datos PEDIDO");




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

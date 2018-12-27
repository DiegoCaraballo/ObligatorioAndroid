package com.example.user.obligatorioandroid;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Lista_Pendientes extends AppCompatActivity {

    private BD_Helper bdHelper;
    private SQLiteDatabase baseDatos;
    public static final String MIS_LOGS = "MIS_LOGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_pedidos);


    }
}

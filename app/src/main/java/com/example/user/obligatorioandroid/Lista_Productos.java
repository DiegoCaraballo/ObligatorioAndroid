package com.example.user.obligatorioandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class Lista_Productos extends AppCompatActivity {

    protected GridView gvProductos;
    public static final String EXTRA_PROD = "EXTRA_PROD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_productos);




    }
}

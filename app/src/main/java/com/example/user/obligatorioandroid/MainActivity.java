package com.example.user.obligatorioandroid;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
    @Override
    protected void onDestroy() {
        super.onDestroy();

        baseDatos.close();

        bdHelper.eliminarBaseDatos();
    }

}

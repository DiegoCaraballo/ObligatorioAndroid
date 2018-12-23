package com.example.user.obligatorioandroid;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

public class Detalle_Producto extends AppCompatActivity {

protected  Detalle_Producto_Fragment frgDetalleProd;

private Producto prod;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_producto);

        frgDetalleProd = (Detalle_Producto_Fragment)getSupportFragmentManager().findFragmentById(R.id.frgDetalleEmpleado);

        Bundle extras = getIntent().getExtras();
prod = (Producto)extras.getSerializable(Lista_Productos.EXTRA_PROD);
    }

    @Override
    protected void onStart() {
        super.onStart();

        frgDetalleProd.mostrarProd(prod);
    }
}

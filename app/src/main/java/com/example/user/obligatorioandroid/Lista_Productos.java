package com.example.user.obligatorioandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class Lista_Productos extends AppCompatActivity implements  Listado_Producto_Fragment.OnProdSeleccionadoListener{

    protected GridView gvProductos;
    public static final String EXTRA_PROD = "EXTRA_PROD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_productos);

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
}

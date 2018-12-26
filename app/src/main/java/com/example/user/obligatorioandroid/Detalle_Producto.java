package com.example.user.obligatorioandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Detalle_Producto extends AppCompatActivity {

protected  Detalle_Producto_Fragment frgDetalleProd;

    private BD_Helper bdHelper;
    private SQLiteDatabase baseDatos;
    public static final String MIS_LOGS = "MIS_LOGS";
    protected EditText etNombreCli;
    private EditText etCantidad;
    private EditText etPagoAdelantado;
    private TextView tvIDProd;

private Producto prod;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_producto);


        frgDetalleProd = (Detalle_Producto_Fragment)getSupportFragmentManager().findFragmentById(R.id.frgDetalleProducto);

        Bundle extras = getIntent().getExtras();
        prod = (Producto)extras.getSerializable(Lista_Productos.EXTRA_PROD);
    }

    @Override
    protected void onStart() {
        super.onStart();

        frgDetalleProd.mostrarProd(prod);
    }


    public void onClickPedido(View view) {
        bdHelper = new BD_Helper(this);
        baseDatos = bdHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();

        baseDatos.beginTransaction();

        etNombreCli = findViewById(R.id.etNombreCli);
        etCantidad = findViewById(R.id.etCantidad);
        etPagoAdelantado = findViewById(R.id.etPagoAdelantado);
        tvIDProd = findViewById(R.id.tvId);

        try{

            valores.put(Base_Datos.Pedido.Cantidad,etCantidad.getText().toString());
            valores.put(Base_Datos.Pedido.Cliente,etNombreCli.getText().toString());
            valores.put(Base_Datos.Pedido.Pago_Adelantado,etPagoAdelantado.getText().toString());
            valores.put(Base_Datos.Pedido.Id_Producto,tvIDProd.getText().toString());

            baseDatos.insert(Base_Datos.PEDIDO,null,valores);

            baseDatos.setTransactionSuccessful();

            etNombreCli.setText("");
            etCantidad .setText("");
            etPagoAdelantado.setText("");

            Toast.makeText(this, "Pedido Agregado", Toast.LENGTH_SHORT).show();

        }
        catch (Exception ex){

            Toast.makeText(this, "Error al realizar pedido", Toast.LENGTH_SHORT).show();

            Log.e(MIS_LOGS,"No se logro agregar el pedido" +ex.getMessage());
        }
        finally {
            baseDatos.endTransaction();
        }

        }
}

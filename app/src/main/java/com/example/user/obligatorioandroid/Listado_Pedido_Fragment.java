package com.example.user.obligatorioandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listado_Pedido_Fragment extends Fragment {

    private BD_Helper bdHelper;
    private SQLiteDatabase baseDatos;
    private Pedido pedido;
    private ArrayList<Pedido> listadoPedidos = new ArrayList<>();
    private ArrayList<Pedido> pedidoList = new ArrayList<>();
    public static final String MIS_LOGS = "MIS_LOGS";
    private ListView lvPedidos;
    private Context context;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //if (context instanceof )
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_pedido,container,false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pedidoList = listarPedidos();

        lvPedidos = (ListView)getView().findViewById(R.id.lvsPedidos);

        AdapterPedido adaptadorPedido = new AdapterPedido(getContext(),pedidoList);
        lvPedidos.setAdapter(adaptadorPedido);

    }

    private ArrayList<Pedido> listarPedidos(){

        bdHelper = new BD_Helper(getContext());
        baseDatos = bdHelper.getReadableDatabase();
        Pedido pedido = null;

        Cursor cursor = baseDatos.rawQuery("SELECT * FROM " + Base_Datos.PEDIDO, null);

        int p = cursor.getCount();
        Log.e(MIS_LOGS, String.valueOf(p));
        while (cursor.moveToNext()){
            pedido = new Pedido();
            pedido.setID(cursor.getInt(0));
            pedido.setEntregado(Boolean.parseBoolean(cursor.getString(1)));
            pedido.setCantidad(cursor.getInt(2));
            pedido.setCliente(cursor.getString(3));
            pedido.setProd(BuscarProducto(cursor.getInt(4)));
            pedido.setPago_Adelantado(Boolean.parseBoolean(cursor.getString(5)));

            Log.e(MIS_LOGS, pedido.getCliente());

            listadoPedidos.add(pedido);
        }
        return  listadoPedidos;
    }


    private Producto BuscarProducto(int id){

        bdHelper = new BD_Helper(getContext());
        baseDatos = bdHelper.getReadableDatabase();
        Producto prod = null;

        Cursor cursor = baseDatos.rawQuery("SELECT * FROM " + Base_Datos.PRODUCTO + " WHERE "+Base_Datos.Producto._ID + " = "+id, null);
            while (cursor.moveToNext()){
                prod = new Producto();
                prod.setId(cursor.getInt(0));
                prod.setPrecio(cursor.getDouble(1));
                prod.setFoto(cursor.getString(2));
                prod.setDescripcion(cursor.getString(3));
                prod.setNombre(cursor.getString(4));
                prod.setCategoria(BuscarCategoria(cursor.getInt(5)));

            }

            return prod;
    }

    private Categoria BuscarCategoria(int id){

        bdHelper = new BD_Helper(getContext());
        baseDatos = bdHelper.getReadableDatabase();
        Categoria categoria = null;

        Cursor cursor = baseDatos.rawQuery("SELECT * FROM " + Base_Datos.CATEGORIA+ " WHERE "+Base_Datos.Categoria._ID+" = "+id , null);

        while (cursor.moveToNext()){
            categoria = new Categoria();

            categoria.setId(cursor.getInt(0));
            categoria.setNombre(cursor.getString(1));

        }
            return categoria;
    }



}

package com.example.user.obligatorioandroid;

import android.media.Image;
import android.provider.BaseColumns;

import java.sql.Blob;

public final class Base_Datos {
    public static final String NOMBRE_BD = "BaseDatosBio.sqlite3";
    public static final int VERSION_BD = 1;
    public static final String PRODUCTO = "Producto";
    public static final String PEDIDO = "Pedido";
    public static final String CATEGORIA = "Categoria";

    private Base_Datos(){}

    public static abstract class Pedido implements BaseColumns {

        public static final String Pago_Adelantado = "PagoAdelantado";
        public static final String Entregado = "Entregado";
        public static final String Cantidad = "Cantidad";
        public static final String Cliente = "Cliente";
        public static final String Id_Producto = "Id_Producto";

        public static final String[] COLUMNAS = {_ID, Pago_Adelantado, Entregado ,Cantidad , Cliente};

        public static final String CREAR_TABLA = new StringBuilder("CREATE TABLE ")
                .append(PEDIDO).append(" (")
                .append(_ID).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ")
                .append(Entregado).append(" BOOLEAN NOT NULL, ")
                .append(Cantidad).append(" INTEGER NOT NULL, ")
                .append(Cliente).append(" TEXT NOT NULL, " )
                .append(Id_Producto).append(" INTEGER NOT NULL, ")
                .append("FOREIGN KEY ("+ Id_Producto +") REFERENCES "+ PRODUCTO +" ("+ Producto._ID +"));")
                .toString();

        public static final String ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(PEDIDO).append(";").toString();
    }

    public static abstract class Producto implements BaseColumns{

        public static final String Precio = "Precio";
        public static final String Foto = "Foto";
        public static final String Descripcion = "Descripcion";
        public static final String Nombre = "Nombre";
        public static final String Id_Categoria = "Id_Categoria";

        public static final String[] Columnas = {_ID, Precio, Foto ,Descripcion, Nombre ,Id_Categoria};

        public static final String CREAR_TABLA = new StringBuilder("CREATE TABLE ")
                .append(PRODUCTO).append(" (")
                .append(_ID).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ")
                .append(Precio).append(" DOUBLE NOT NULL, ")
                .append(Foto).append(" BLOB NOT NULL, ")
                .append(Descripcion).append(" TEXT NOT NULL, ")
                .append(Nombre).append(" TEXT NOT NULL, ")
                .append(Id_Categoria).append(" INTEGER NOT NULL, ")
                .append("FOREIGN KEY ("+ Id_Categoria +") REFERENCES "+ CATEGORIA +" ("+ Categoria._ID +"));")
                .toString();

                public static final String ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(PRODUCTO).append(";").toString();
    }

    public static abstract class Categoria implements BaseColumns{
        public static final String Nombre = "Nombre";

        public static final String[] Columnas = {_ID, Nombre};

        public static  final String CREAR_TABLA = new StringBuilder("CREATE TABLE ")
            .append(CATEGORIA).append(" (")
            .append(_ID).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ")
            .append(Nombre).append(" TEXT NOT NULL)")
            .toString();

        public static final String ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(CATEGORIA).append(";").toString();

    }

}



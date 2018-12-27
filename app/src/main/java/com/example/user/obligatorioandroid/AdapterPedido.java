package com.example.user.obligatorioandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPedido extends BaseAdapter {

    private Context contexto;
    private List<Pedido> pedidos;

    public AdapterPedido(Context contexto, ArrayList<Pedido> pedidos){
        this.contexto = contexto;
        this.pedidos = pedidos;

    }

    @Override
    public int getCount() {
        return  pedidos.size();
    }

    @Override
    public Pedido getItem(int position) {
        return pedidos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        PedidoViewHolder pedidoViewHolder;

        if (item == null) {
            LayoutInflater inflador = LayoutInflater.from(contexto);
            item = inflador.inflate(R.layout.fragment_lista_pedido, parent, false);

            pedidoViewHolder = new PedidoViewHolder(item);
            item.setTag(pedidoViewHolder);
        } else {
            pedidoViewHolder = (PedidoViewHolder)item.getTag();
        }

        pedidoViewHolder.enlazarPedido(pedidos.get(position));

        return item;
    }


    protected class PedidoViewHolder {

        private TextView tvIdPedido;
        private TextView tvNomCli;
        private TextView tvProducto;


        public PedidoViewHolder(View vista) {
            tvIdPedido = (TextView)vista.findViewById(R.id.tvIdPedido);
            tvNomCli = (TextView)vista.findViewById(R.id.tvNomCli);
            tvProducto = (TextView)vista.findViewById(R.id.tvProducto);
        }


        public void enlazarPedido(Pedido pedido) {
            tvIdPedido.setText(String.valueOf(pedido.getID()));
            tvNomCli.setText(pedido.getCliente());
            tvProducto.setText(pedido.getProd().getNombre());
        }

    }

}

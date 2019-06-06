package com.example.tam_u1_proyecto_gonzalezcruzalondra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private String[] nombres;
    String [] usuario;
    String [] domicilio;
    String [] telefono;
    private Context contexto;

    //Constructor de mi clase recyclerview

    public RecyclerAdapter(String[] a,String[] b,String[] c,String[] d, Context con) {
        this.nombres = a;
        this.usuario = b;
        this.domicilio = c;
        this.telefono = d;
        this.contexto = con;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate se utiliza para construir y añadir los view en el adaptador

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        //se van agregando los datos por posicion al recyclerview
        holder.usuario.setText(usuario[position]);
        holder.nombre.setText(nombres[position]);
        holder.domicilio.setText(domicilio[position]);
        holder.telefono.setText(telefono[position]);

    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView usuario;
        TextView nombre;
        TextView domicilio;
        TextView telefono;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            usuario = itemView.findViewById(R.id.id);
            nombre = itemView.findViewById(R.id.nombre);
            domicilio = itemView.findViewById(R.id.domicilio);
            telefono = itemView.findViewById(R.id.tel);


        }
    }

}

package com.example.tam_u2_ejercicio1_gonzalezcruzalondra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>  {
    private String[] nombres;
    String [] identificador;
    String [] clave;
    String [] salario;
    private Context contexto;

    //Constructor de mi clase recyclerview

    public RecyclerAdapter(String[] a,String[] b,String[] c,String[] d, Context con) {
        this.nombres = a;
        this.identificador = b;
        this.clave = c;
        this.salario = d;
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
        holder.identificador.setText(identificador[position]);
        holder.clave.setText(clave[position]);
        holder.nombre.setText(nombres[position]);
        holder.salario.setText(salario[position]);
    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView identificador;
        TextView nombre;
        TextView clave;
        TextView salario;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            identificador = itemView.findViewById(R.id.id);
            nombre = itemView.findViewById(R.id.nombre);
            clave = itemView.findViewById(R.id.clave);
            salario = itemView.findViewById(R.id.salario);
        }
    }
}

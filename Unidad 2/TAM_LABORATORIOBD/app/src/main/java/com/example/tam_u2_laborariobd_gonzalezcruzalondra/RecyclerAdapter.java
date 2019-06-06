package com.example.tam_u2_laborariobd_gonzalezcruzalondra;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private String[] licencia;
    String[] conductor;
    String[] monto;
    String[] puntos;
    String[] celular;
    String[] email;
    private Context contexto;
    Main3Activity main;


    public RecyclerAdapter(String[] p, String[] n, String[] r, String[] c, String[] e, String[] f, Context con) {
        this.conductor = p;
        this.licencia = n;
        this.monto = r;
        this.puntos = c;
        this.celular = e;
        this.email = f;
        this.contexto = con;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.conductor.setText(conductor[position]);
        holder.licencia.setText(licencia[position]);
        holder.monto.setText(monto[position]);
        holder.puntos.setText(puntos[position]);
        holder.celular.setText(celular[position]);
        holder.email.setText(email[position]);
        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVentana = new Intent(contexto, Main3Activity.class);
                //enviar id
                otraVentana.putExtra("id", String.valueOf(conductor[position]));
                contexto.startActivity(otraVentana);
            }
        });
        holder.vermonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v7.app.AlertDialog.Builder confir = new AlertDialog.Builder(contexto);

                confir.setTitle("DATOS-CONDUCTOR").setMessage("LICENCIA: " + holder.licencia.getText().toString() + "\n" + "MONTO ACUMULADO: " + holder.monto.getText() + "\n" + "PUNTOS: " + holder.puntos.getText())
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                            }
                        }).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return conductor.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView conductor;
        TextView licencia;
        TextView monto;
        TextView puntos;
        TextView celular;
        TextView email;

        ImageView editar, vermonto;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

               //cajas de texto
            conductor = itemView.findViewById(R.id.id);
            licencia = itemView.findViewById(R.id.lic);
            monto = itemView.findViewById(R.id.monto);
            puntos = itemView.findViewById(R.id.puntos);
            celular = itemView.findViewById(R.id.cel);
            email = itemView.findViewById(R.id.email);
            // botones de editar y consultar conductor
            editar = itemView.findViewById(R.id.edi);
            vermonto = itemView.findViewById(R.id.buscar);
        }
    }
}

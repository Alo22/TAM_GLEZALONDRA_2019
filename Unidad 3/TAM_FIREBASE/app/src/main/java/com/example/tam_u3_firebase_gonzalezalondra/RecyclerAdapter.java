package com.example.tam_u3_firebase_gonzalezalondra;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.DialogInterface;
import android.widget.Toast;

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
        try {
            if(Integer.valueOf(puntos[position])>10)holder.cons.setBackgroundColor(Color.parseColor("#9EEE2616"));
        }catch (Exception e){
            holder.cons.setBackgroundColor(Color.parseColor("#FFC107"));
        }
        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVentanaa = new Intent(contexto, Main4Activity.class);
                //enviar id
                otraVentanaa.putExtra("id", String.valueOf(conductor[position]));
                contexto.startActivity(otraVentanaa);

            }
        });
        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVentana = new Intent(contexto, Main3Activity.class);
                //enviar id
                otraVentana.putExtra("id", String.valueOf(holder.conductor.getText().toString()));
                contexto.startActivity(otraVentana);
            }
        });
        holder.vermonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confir = new AlertDialog.Builder(contexto);

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
        CardView cardView;
        ConstraintLayout cons;

        ImageView editar, eliminar,vermonto;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            //cajas de texto
            conductor = itemView.findViewById(R.id.id);
            licencia = itemView.findViewById(R.id.lic);
            monto = itemView.findViewById(R.id.monto);
            puntos = itemView.findViewById(R.id.puntos);
            celular = itemView.findViewById(R.id.cel);
            email = itemView.findViewById(R.id.email);
            cardView=itemView.findViewById(R.id.cardView);
            cons=itemView.findViewById(R.id.a);
            // botones de editar y consultar conductor
            editar = itemView.findViewById(R.id.edi);
            eliminar=itemView.findViewById(R.id.borrar);
            vermonto = itemView.findViewById(R.id.buscar);
        }
    }
}

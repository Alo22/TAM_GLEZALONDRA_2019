package com.example.tam_u2_caso3_gonzalezcruzalondra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class list_item_alumno extends RecyclerView.Adapter<list_item_alumno.PersonasViewHolder> {
    ArrayList<Usuario> listaUsuario;

    public list_item_alumno(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_personas,null,false);
        return new PersonasViewHolder(view);
    }
    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {

        holder.id.setText(listaUsuario.get(position).getId().toString());
        holder.nombre.setText(listaUsuario.get(position).getNombre());
        holder.nocontrol.setText(listaUsuario.get(position).getNocontrol());
        holder.cel.setText(listaUsuario.get(position).getCel());
        holder.email.setText(listaUsuario.get(position).getEmail());
        holder.carrera.setText(listaUsuario.get(position).getCarrera());

    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView id,nombre,nocontrol,cel,email,carrera;

        public PersonasViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textId);
            nombre =  itemView.findViewById(R.id.textNombre);
            nocontrol= itemView.findViewById(R.id.textNocontrol);
            cel =  itemView.findViewById(R.id.textCelular);
            email =  itemView.findViewById(R.id.textEmail);
            carrera = itemView.findViewById(R.id.textCarrera);
        }
    }
}

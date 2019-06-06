package com.example.tam_u2_caso3_gonzalezcruzalondra;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class activity_lista_personas_recycler extends AppCompatActivity {
    ArrayList<Usuario> listaUsuario;
    RecyclerView recyclerViewUsuarios;
    BaseDatos conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas_recycler);
        conn=new BaseDatos(getApplicationContext(),"bd_usuarios",null,1);
        listaUsuario=new ArrayList<>();

        recyclerViewUsuarios=  findViewById(R.id.recyclerPersonas);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));

        consultarListaPersonas();

        list_item_alumno adapter=new   list_item_alumno (listaUsuario);
        recyclerViewUsuarios.setAdapter(adapter);
    }
    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario = null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setNocontrol(cursor.getString(2));
            usuario.setCel(cursor.getString(3));
            usuario.setEmail(cursor.getString(4));
            usuario.setCarrera(cursor.getString(5));

            listaUsuario.add(usuario);
        }
    }
}

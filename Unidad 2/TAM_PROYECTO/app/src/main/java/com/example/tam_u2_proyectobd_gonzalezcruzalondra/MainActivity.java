package com.example.tam_u2_proyectobd_gonzalezcruzalondra;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView agregar, consultar;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    BaseDatos base;
    String [] conductor= new String[5];
    String [] licencia= new String[5];
    String [] monto= new String[5];
    String [] puntos= new String[5];
    String [] celular= new String[5];
    String [] email= new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregar = findViewById(R.id.agregar);
        consultar = findViewById(R.id.consultar);
        //base de datos
        base = new BaseDatos(this, "transito", null, 1);
        try{
            SQLiteDatabase tabla= base.getReadableDatabase();
            String SQL ="SELECT * FROM CONDUCTOR";

            Cursor resultado =tabla.rawQuery(SQL, null);
            if(resultado.moveToFirst()) {
                int i=0;
                while(!resultado.isAfterLast()){
                    conductor[i]=resultado.getString(0).toString();
                    licencia[i]=resultado.getString(1);
                    monto[i]=resultado.getString(2);
                    puntos[i]=resultado.getString(3);
                    celular[i]=resultado.getString(4);
                    email[i]=resultado.getString(5);
                    i++;
                    resultado.moveToNext();
                }
            }
            tabla.close();
        }catch (SQLiteException e){
            Toast.makeText(this, "ERROR, INTENTARLO DE NUEVO"+e.toString(), Toast.LENGTH_LONG).show();
        }
        //botones
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otra = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(otra);
            }
        });
        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);

        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
        adapter = new RecyclerAdapter(conductor, licencia, monto, puntos, celular, email, this);

        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

        // Establecer el LayautManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);

    }
}

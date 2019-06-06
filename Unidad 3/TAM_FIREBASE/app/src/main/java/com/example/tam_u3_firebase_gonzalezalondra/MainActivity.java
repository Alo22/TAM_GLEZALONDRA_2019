package com.example.tam_u3_firebase_gonzalezalondra;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    ImageView agregar, consultar;
    CardView cardView;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    BaseDatos base;
    String[] conductor = new String[5];
    String[] licencia = new String[5];
    String[] monto = new String[5];
    String[] puntos = new String[5];
    String[] celular = new String[5];
    String[] email = new String[5];

    String[] conductor1 = new String[5];
    String[] licencia1 = new String[5];
    String[] monto1 = new String[5];
    String[] puntos1 = new String[5];
    String[] celular1 = new String[5];
    String[] email1 = new String[5];
    DatabaseReference databse;
    int i = 0;
    int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregar = findViewById(R.id.agregar);
        consultar = findViewById(R.id.consultar);
        //base de datos
        base = new BaseDatos(this, "transito", null, 1);
        try {
            SQLiteDatabase tabla = base.getReadableDatabase();
            String SQL = "SELECT * FROM CONDUCTOR";

            Cursor resultado = tabla.rawQuery(SQL, null);
            if (resultado.moveToFirst()) {

                while (!resultado.isAfterLast()) {
                    conductor[i] = resultado.getString(0).toString();
                    licencia[i] = resultado.getString(1);
                    monto[i] = resultado.getString(2);
                    puntos[i] = resultado.getString(3);
                    celular[i] = resultado.getString(4);
                    email[i] = resultado.getString(5);
                    i++;
                    resultado.moveToNext();
                }
            }
            tabla.close();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR, INTENTARLO DE NUEVO" + e.toString(), Toast.LENGTH_LONG).show();
        }
        //botones
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otra = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(otra);
            }
        });
        //FIREBASE

        if (i > 1) {
            databse = FirebaseDatabase.getInstance().getReference();

            databse.child("Multa" + conductor[1]).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int x = 0;
                    puntos1[1] = dataSnapshot.child("PUNTOS" + conductor[1]).getValue().toString();
                    licencia1[1] = dataSnapshot.child("LICENCIA" + conductor[1]).getValue().toString();
                    monto1[1] = dataSnapshot.child("MONTO" + conductor[1]).getValue().toString();
                    celular1[1] = dataSnapshot.child("CELULAR" + conductor[1]).getValue().toString();
                    email1[1] = dataSnapshot.child("EMAIL" + conductor[1]).getValue().toString();
                    puntos[1] = puntos1[1];
                    licencia[1] = licencia1[1];
                    monto[1] = monto1[1];
                    celular[1] = celular1[1];
                    email[1] = email1[1];


                    // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
                    adapter = new RecyclerAdapter(conductor, licencia, monto, puntos, celular, email, MainActivity.this);

                    // Crea un objeto de tipo LinearLayoutManager
                    layoutManager = new LinearLayoutManager(MainActivity.this);

                    // Establecer el LayautManager
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);

                    // Establecer el Adapter
                    recyclerView.setAdapter(adapter);
                    cardView = findViewById(R.id.cardView);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        if (i > 0) {
            databse = FirebaseDatabase.getInstance().getReference();
            databse.child("Multa" + conductor[0]).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int x = 0;
                    puntos1[0] = dataSnapshot.child("PUNTOS" + conductor[0]).getValue().toString();
                    licencia1[0] = dataSnapshot.child("LICENCIA" + conductor[0]).getValue().toString();
                    monto1[0] = dataSnapshot.child("MONTO" + conductor[0]).getValue().toString();
                    celular1[0] = dataSnapshot.child("CELULAR" + conductor[0]).getValue().toString();
                    email1[0] = dataSnapshot.child("EMAIL" + conductor[0]).getValue().toString();
                    puntos[0] = puntos1[0];
                    licencia[0] = licencia1[0];
                    monto[0] = monto1[0];
                    celular[0] = celular1[0];
                    email[0] = email1[0];

                    // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
                    adapter = new RecyclerAdapter(conductor, licencia, monto, puntos, celular, email, MainActivity.this);

                    // Crea un objeto de tipo LinearLayoutManager
                    layoutManager = new LinearLayoutManager(MainActivity.this);

                    // Establecer el LayautManager
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);

                    // Establecer el Adapter
                    recyclerView.setAdapter(adapter);

                    cardView = findViewById(R.id.cardView);
                    j++;
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        if (i > 2) {
            databse = FirebaseDatabase.getInstance().getReference();
            databse.child("Multa" + conductor[2]).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int x = 0;
                    puntos1[2] = dataSnapshot.child("PUNTOS" + conductor[2]).getValue().toString();
                    licencia1[2] = dataSnapshot.child("LICENCIA" + conductor[2]).getValue().toString();
                    monto1[2] = dataSnapshot.child("MONTO" + conductor[2]).getValue().toString();
                    celular1[2] = dataSnapshot.child("CELULAR" + conductor[2]).getValue().toString();
                    email1[2] = dataSnapshot.child("EMAIL" + conductor[2]).getValue().toString();
                    puntos[2] = puntos1[2];
                    licencia[2] = licencia1[2];
                    monto[2] = monto1[2];
                    celular[2] = celular1[2];
                    email[2] = email1[2];

                    // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
                    adapter = new RecyclerAdapter(conductor, licencia, monto, puntos, celular, email, MainActivity.this);

                    // Crea un objeto de tipo LinearLayoutManager
                    layoutManager = new LinearLayoutManager(MainActivity.this);

                    // Establecer el LayautManager
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);

                    // Establecer el Adapter
                    recyclerView.setAdapter(adapter);

                    cardView = findViewById(R.id.cardView);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        if (i > 3) {
            databse = FirebaseDatabase.getInstance().getReference();
            databse.child("Multa" + conductor[3]).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int x = 0;
                    puntos1[3] = dataSnapshot.child("PUNTOS" + conductor[3]).getValue().toString();
                    licencia1[3] = dataSnapshot.child("LICENCIA" + conductor[3]).getValue().toString();
                    monto1[3] = dataSnapshot.child("MONTO" + conductor[3]).getValue().toString();
                    celular1[3] = dataSnapshot.child("CELULAR" + conductor[3]).getValue().toString();
                    email1[3] = dataSnapshot.child("EMAIL" + conductor[3]).getValue().toString();
                    puntos[3] = puntos1[3];
                    licencia[3] = licencia1[3];
                    monto[3] = monto1[3];
                    celular[3] = celular1[3];
                    email[3] = email1[3];

                    // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
                    adapter = new RecyclerAdapter(conductor, licencia, monto, puntos, celular, email, MainActivity.this);

                    // Crea un objeto de tipo LinearLayoutManager
                    layoutManager = new LinearLayoutManager(MainActivity.this);

                    // Establecer el LayautManager
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);

                    // Establecer el Adapter
                    recyclerView.setAdapter(adapter);

                    cardView = findViewById(R.id.cardView);
                    j++;
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        if (i > 4) {
            databse = FirebaseDatabase.getInstance().getReference();
            databse.child("Multa" + conductor[4]).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    int x = 0;
                    puntos1[4] = dataSnapshot.child("PUNTOS" + conductor[4]).getValue().toString();
                    licencia1[4] = dataSnapshot.child("LICENCIA" + conductor[4]).getValue().toString();
                    monto1[4] = dataSnapshot.child("MONTO" + conductor[4]).getValue().toString();
                    celular1[4] = dataSnapshot.child("CELULAR" + conductor[4]).getValue().toString();
                    email1[4] = dataSnapshot.child("EMAIL" + conductor[4]).getValue().toString();
                    puntos[4] = puntos1[4];
                    licencia[4] = licencia1[4];
                    monto[4] = monto1[4];
                    celular[4] = celular1[4];
                    email[4] = email1[4];

                    // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
                    adapter = new RecyclerAdapter(conductor, licencia, monto, puntos, celular, email, MainActivity.this);

                    // Crea un objeto de tipo LinearLayoutManager
                    layoutManager = new LinearLayoutManager(MainActivity.this);

                    // Establecer el LayautManager
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);

                    // Establecer el Adapter
                    recyclerView.setAdapter(adapter);

                    cardView = findViewById(R.id.cardView);
                    j++;
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }
}
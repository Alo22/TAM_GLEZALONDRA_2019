package com.example.tam_u2_proyectobd_gonzalezcruzalondra;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText identificador, licencia, monto, puntos, celular, email;
    Button eliminar, regresar;
    BaseDatos base;
    String id;
    int imonto=0, ipuntos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        identificador = findViewById(R.id.idd);
        licencia = findViewById(R.id.lic1);
        monto = findViewById(R.id.monto1);
        puntos = findViewById(R.id.puntos1);
        celular = findViewById(R.id.cel1);
        email = findViewById(R.id.email1);
        //botones
        eliminar = findViewById(R.id.eliminar);
        regresar= findViewById(R.id.cancelar);
        //recibo la posicion
        id=getIntent().getStringExtra("id");
        // conexion de la base transito
        base = new BaseDatos(this, "transito", null, 1);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ootra = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(ootra);
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarconductor();
            }
        });
        base = new BaseDatos(this, "transito", null, 1);
        try{
            SQLiteDatabase tabla= base.getReadableDatabase();
            String SQL ="SELECT * FROM CONDUCTOR";

            Cursor resultado =tabla.rawQuery(SQL, null);
            if(resultado.moveToFirst()) {
                identificador.setText(resultado.getString(0));
                licencia.setText(resultado.getString(1));
                monto.setText(resultado.getString(2));
                puntos.setText(resultado.getString(3));
                celular.setText(resultado.getString(4));
                email.setText(resultado.getString(5));
                imonto+=Integer.valueOf(resultado.getString(2));
                ipuntos+=Integer.valueOf(resultado.getString(3));
            }
            tabla.close();
        }catch (SQLiteException e){
            Toast.makeText(this, "NO SE PUDO REALIZAR"+e.toString(), Toast.LENGTH_LONG).show();
        }

    }

    private void eliminarconductor() {
        try{
            SQLiteDatabase tabla= base.getWritableDatabase();
            //String idEliminar = identificador.getText().toString();

            String SQL ="DELETE FROM CONDUCTOR WHERE ID="+id;//identificador.getText().toString();
            tabla.execSQL(SQL);
            Toast.makeText(this, "SE ELIMINO LOS DATOS DEL CONDUCTOR", Toast.LENGTH_LONG).show();
            LimpiarCampos();
            tabla.close();
        }catch (SQLiteException e){
            Toast.makeText(this, "NO SE PUDO ELIMINAR", Toast.LENGTH_LONG).show();
        }
    }

    private void LimpiarCampos() {
        identificador.setText("");
        licencia.setText("");
        monto.setText("");
        puntos.setText("");
        celular.setText("");
        email.setText("");
    }
}

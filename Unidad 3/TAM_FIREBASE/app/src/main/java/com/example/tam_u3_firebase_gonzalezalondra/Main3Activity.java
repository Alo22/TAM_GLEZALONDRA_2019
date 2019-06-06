package com.example.tam_u3_firebase_gonzalezalondra;

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

public class Main3Activity extends AppCompatActivity {
    EditText identificador, licencia, monto, puntos, celular, email;
    Button actualizar, cancelar;
    BaseDatos base;
    String id;
    int imonto=0, ipuntos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        identificador = findViewById(R.id.idd);
        licencia = findViewById(R.id.lic1);
        monto = findViewById(R.id.monto1);
        puntos = findViewById(R.id.puntos1);
        celular = findViewById(R.id.cel1);
        email = findViewById(R.id.email1);
        //botones
        actualizar = findViewById(R.id.actualizar);
        cancelar = findViewById(R.id.cancelar);
        //recibo la posicion
        id=getIntent().getStringExtra("id");
        // conexion de la base transito
        base = new BaseDatos(this, "transito", null, 1);


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otra = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(otra);

            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarconductor();
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
    private void actualizarconductor() {

        try

        {
            SQLiteDatabase tabla = base.getWritableDatabase();
            int a= imonto+Integer.valueOf(monto.getText().toString());
            int b= ipuntos+Integer.valueOf(puntos.getText().toString());

            String SQL = "UPDATE CONDUCTOR SET LICENCIA='" + licencia.getText().toString() + "', MONTO='" + a + "', PUNTOS='" + b + "', CELULAR='" + celular.getText().toString() + "', EMAIL='" + email.getText().toString()
                    + "'WHERE ID=" + id;

            tabla.execSQL(SQL);
            tabla.close();

            monto.setText(String.valueOf(a));
            puntos.setText(String.valueOf(b));
            habilitarBotonesYLimpiarCampos();
            Toast.makeText(this, "SE ACTUALIZO LOS DATOS", Toast.LENGTH_LONG).show();
            identificador.setText(id.toString());

        }catch(
                SQLiteException e)

        {
            Toast.makeText(this, "NO SE PUDO ACTUALIZAR", Toast.LENGTH_LONG).show();
        }

    }
    private void habilitarBotonesYLimpiarCampos() {
        identificador.setText("");
        licencia.setText("");
        monto.setText("");
        puntos.setText("");
        celular.setText("");
        email.setText("");
    }
}

package com.example.tam_u2_proyectobd_gonzalezcruzalondra;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText identificador, licencia, monto, puntos, celular, email;
    Button insertar, regresar;
    BaseDatos base;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        identificador=findViewById(R.id.idd);
        licencia=findViewById(R.id.lic1);
        monto=findViewById(R.id.monto1);
        puntos=findViewById(R.id.puntos1);
        celular=findViewById(R.id.cel1);
        email=findViewById(R.id.email1);
        //boton de registtar
        insertar=findViewById(R.id.insertar);
        regresar=findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otra = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(otra);
            }
        });

        // conexion con la Base de datos
        base = new BaseDatos(this, "transito", null, 1);
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarcoductor();
            }
        });

    }

    private void insertarcoductor() {
        try{
            if(identificador.getText().toString().isEmpty()){
                Toast.makeText(this, "AGREGAR ID", Toast.LENGTH_LONG).show();
                return;
            }
            if(!repetidoId(identificador.getText().toString())) {
                SQLiteDatabase tabla = base.getWritableDatabase();

                if(Integer.valueOf(puntos.getText().toString())>10||Integer.valueOf(puntos.getText().toString())<0){
                    Toast.makeText(this,"PUNTOS DE 1 AL 10", Toast.LENGTH_LONG).show();
                    puntos.setText("");
                }
                if(licencia.getText().toString().length()>5){
                    Toast.makeText(this,"LICENCIA DE 5 DIGITOS", Toast.LENGTH_LONG).show();
                    licencia.setText("");
                }
                else {

                    String SQL = "INSERT INTO CONDUCTOR VALUES(" + identificador.getText().toString()
                            + ",'" + licencia.getText().toString() + "','" + monto.getText().toString()
                            + "','" + puntos.getText().toString()
                            + "','" + celular.getText().toString()
                            + "','" + email.getText().toString() + "')";

                    tabla.execSQL(SQL);
                    tabla.close();
                    Toast.makeText(this, "SE REGISTRO CORRECTAMENTE", Toast.LENGTH_LONG).show();
                    //despues que inserte limpiar los camtos y habilitar el boton de insertar
                    habilitarBotonesYLimpiarCampos();
                }
            }else {
                Toast.makeText(this, "YA EXISTE UN ID, INTRODUZCA OTRO", Toast.LENGTH_LONG).show();
                identificador.setText("");
            }
        }catch (SQLiteException e){
            Toast.makeText(this, "NO SE PUDO HACER EL REGISTRO", Toast.LENGTH_LONG).show();
            //habilitarBotonesYLimpiarCampos();
        }
    }

    private void habilitarBotonesYLimpiarCampos() {
        identificador.setText("");
        licencia.setText("");
        monto.setText("");
        puntos.setText("");
        celular.setText("");
        email.setText("");
        insertar.setEnabled(true);
    }

    private boolean repetidoId(String idBuscar) {
        SQLiteDatabase tabla= base.getReadableDatabase();
        String SQL ="SELECT * FROM CONDUCTOR WHERE ID="+idBuscar;

        Cursor resultado =tabla.rawQuery(SQL, null);
        if(resultado.moveToFirst()){
            return true;
        }
        return false;
    }

}

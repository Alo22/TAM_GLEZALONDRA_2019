package com.example.tam_u2_caso3_gonzalezcruzalondra;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_registro_usuarios extends AppCompatActivity {
    EditText campoId,campoNombre,campoNocontrol,campoCel,campoEmail,campoCarrera;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        campoId = findViewById(R.id.campoId);
        campoNombre = findViewById(R.id.campoNombre);
        campoNocontrol = findViewById(R.id.campoNocontrol);
        campoCel = findViewById(R.id.campoCel);
        campoEmail= findViewById(R.id.campoEmail);
        campoCarrera= findViewById(R.id.campoCarrera);

        registrar = findViewById(R.id.btnRegistro);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarusuarios();
                limpiar();
            }
        });
    }
    private void registrarusuarios() {
        BaseDatos conn=new BaseDatos(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_NOCONTROL,campoNocontrol.getText().toString());
        values.put(Utilidades.CAMPO_CEL,campoCel.getText().toString());
        values.put(Utilidades.CAMPO_EMAIL,campoEmail.getText().toString());
        values.put(Utilidades.CAMPO_CARRERA,campoCarrera.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
    private void limpiar() {
        campoId.setText("");
        campoNombre.setText("");
        campoNocontrol.setText("");
        campoCel.setText("");
        campoEmail.setText("");
        campoCarrera.setText("");
    }

}

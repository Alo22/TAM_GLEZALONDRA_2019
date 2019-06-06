package com.example.tam_u4_laboratorio_gonzalezcruzalondra;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
Button mostrar;
EditText numero;
TextView serie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrar=findViewById(R.id.button);
        numero=findViewById(R.id.editText);
        serie=findViewById(R.id.textView2);
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //en caso de que este vacio la casilla, mandar un mensaje de alerta...
               if(numero.getText().toString().isEmpty()){
                   Toast.makeText(MainActivity.this, "Favor de ingresar numero >0", Toast.LENGTH_LONG).show();
               }
               else{
                   //crear un objeto llamado asyncserie y llevarme el parametro del numero introducido
                   AsyncSerie asyncSerie = new AsyncSerie();
                   asyncSerie.execute(Integer.parseInt(numero.getText().toString()));
                   numero.setText("");
               }
            }
        });
    }
    private class  AsyncSerie extends AsyncTask<Integer, Integer,Boolean> {
        String s1 = "0";
        String s2= "1";
        String resultado="";
        String r;

        @Override
        // le notifica al usuario que se esta ejecutando en segundo plano la app
        protected void onPreExecute() {
            super.onPreExecute();

        }
        //metodo abstracto que ejecuta el thread en segundo plano
        @Override
        protected Boolean doInBackground(Integer... params) {
            int numero1 = 0;
            int numero2 = 1;
            int n=(Integer.parseInt(numero.getText().toString()));
            int s=n-2;
            int auxilixar;
            for(int i=0;i<s;i++){
                auxilixar=numero1;
                numero1=numero2;
                numero2= auxilixar+numero1;
                resultado += numero2 +"\n";
            }
             r= s1+ "\n" + s2 + "\n" + resultado;

            return true;
        }
        private void UnSegundo() {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) { //nos  muestra el cambio de como avansa la aplicacion
            super.onProgressUpdate(values);


        }

        @Override
        protected void onPostExecute(Boolean aVoid) { //muestra la ejecución que va avael resultado
            //super.onPostExecute(aVoid);
            serie.setText(r);

        }
    }
}

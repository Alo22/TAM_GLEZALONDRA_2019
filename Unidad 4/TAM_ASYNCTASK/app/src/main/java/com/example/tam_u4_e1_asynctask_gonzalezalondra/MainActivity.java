package com.example.tam_u4_e1_asynctask_gonzalezalondra;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar1;
    EditText numero;
    Button cargar;
    TextView proceso;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar1 =  findViewById(R.id.progressBar);
        proceso=findViewById(R.id.textView);
        numero=findViewById(R.id.editText);
        cargar=findViewById(R.id.button);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numero.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese un numero ...", Toast.LENGTH_SHORT).show();
                }
                else{
                    AsyncProceso asyncProceso = new AsyncProceso();
                    asyncProceso.execute(Integer.parseInt(numero.getText().toString()));
                    numero.setText("");
                }
            }
        });

    }
 private void UnSegundo() {

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


private class AsyncProceso extends AsyncTask<Integer, Integer,Boolean> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(Integer... params) {
        progressBar1.setMax(params[0]);
        for (int i=1; i<=params[0]; i++){
            UnSegundo();

            publishProgress(i);

            if (isCancelled()){
                break;
            }
        }
        return true;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        //Actualiza la barra de progreso
        progressBar1.setProgress(values[0].intValue());
        //proceso.setText("... "+((values[0].intValue())));
        proceso.setText(values[0].intValue() + "...");
    }

}
}


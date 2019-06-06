package mx.edu.ittepic.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
Button iniciar,parar;
TextView numero;
    String mostrarNum,auxBtnNumContadorMostrar,comparacionBtnNumeroContador;
    float numCambiante,auxNum,btnNumContadorMostrar,actual;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar=findViewById(R.id.button);
        parar=findViewById(R.id.button2);
        numero=findViewById(R.id.textView);
        btnNumContadorMostrar=0;
        final DecimalFormat baseDecimal = new DecimalFormat("#.0");
        numCambiante = (float) (Math.random()*3);
        mostrarNum = baseDecimal.format(numCambiante);
        numero.setText(mostrarNum);
        actual = Float.parseFloat(mostrarNum);
        timer = new CountDownTimer(10000,300)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                btnNumContadorMostrar = (float) (btnNumContadorMostrar+0.1);
                auxBtnNumContadorMostrar = baseDecimal.format(btnNumContadorMostrar);
                parar.setText(auxBtnNumContadorMostrar);

                if (btnNumContadorMostrar>=2.9)
                    btnNumContadorMostrar = (float) 0.0;
            }

            @Override
            public void onFinish()
            {
                timer.start();
            }
        };timer.start();
        parar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                comparacionBtnNumeroContador = auxBtnNumContadorMostrar;
                auxNum = Float.parseFloat(comparacionBtnNumeroContador);
                if (actual==auxNum)
                {
                    Toast.makeText(MainActivity.this,"Exito",Toast.LENGTH_SHORT).show();
                    timer.cancel();
                }
                else
                {
                    numCambiante = (float) (Math.random()*3);
                    mostrarNum = baseDecimal.format(numCambiante);
                    numero.setText(mostrarNum);
                    auxNum=Float.parseFloat(mostrarNum);
                    Toast.makeText(MainActivity.this,"Fallaste",Toast.LENGTH_SHORT).show();
                    timer.cancel();
                }

            }
        });

        iniciar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numCambiante = (float) (Math.random()*3);
                mostrarNum = baseDecimal.format(numCambiante);
                numero.setText(mostrarNum);
                actual = Float.parseFloat(mostrarNum);

                timer.start();
            }
        });
    }
}

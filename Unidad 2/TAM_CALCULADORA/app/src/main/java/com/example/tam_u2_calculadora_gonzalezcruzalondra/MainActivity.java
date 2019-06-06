package com.example.tam_u2_calculadora_gonzalezcruzalondra;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button abrir;
private MediaPlayer reproductor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abrir=findViewById(R.id.button);

        reproductor=MediaPlayer.create(this,R.raw.can);
        reproductor.start();
        abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(ventana);
                reproductor.stop();
            }
        });
    }

}

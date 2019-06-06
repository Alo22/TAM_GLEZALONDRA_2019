package com.example.tam_u4_frameanimation_gonzalezalondra;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private ImageView imageView;
private Button iniciar, detener;
AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        iniciar=findViewById(R.id.button);
        detener=findViewById(R.id.button2);
        if (imageView==null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.drawable);
        imageView.setVisibility(View.INVISIBLE);

        anim = (AnimationDrawable)imageView.getBackground();
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                if(anim.isRunning())
                    anim.stop();
                anim.start();

            }
        });
        detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.stop();

            }
        });
    }
}

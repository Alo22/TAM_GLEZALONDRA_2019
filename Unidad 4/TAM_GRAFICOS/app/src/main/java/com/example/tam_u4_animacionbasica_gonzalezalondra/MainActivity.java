package com.example.tam_u4_animacionbasica_gonzalezalondra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
 private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.tigree);
    }
    public void onButtonClick(View v) {
        switch (v.getId()){

            case (R.id.animacion):
        ///investigar animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.grow);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            //
            public void onAnimationEnd(Animation animation) {
                imageView.setScaleX(2);
                imageView.setScaleY(2);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        imageView.startAnimation(animation);
        break;
            case (R.id.rota):

                break;
            case (R.id.rotaa):
                break;
            case R.id.rotaaa:
                break;
    }
    }

}

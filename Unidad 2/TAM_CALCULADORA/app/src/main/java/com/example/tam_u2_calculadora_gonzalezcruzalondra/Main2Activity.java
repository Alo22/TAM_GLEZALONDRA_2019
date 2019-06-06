package com.example.tam_u2_calculadora_gonzalezcruzalondra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
Button uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero,punto,suma,resta,multiplicacion,division,borrarc,dell;
public TextView pant;
public double numero1, numero2,res;
int ope;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pant=(TextView)findViewById(R.id.textView);
    //  uno=findViewById(R.id.button10);
    //  dos=findViewById(R.id.button11);
    //  tres=findViewById(R.id.button12);
    //  cuatro=findViewById(R.id.button6);
    //  cinco=findViewById(R.id.button7);
    //  seis=findViewById(R.id.button8);
    //  siete=findViewById(R.id.button2);
    //  ocho=findViewById(R.id.button3);
    //  nueve=findViewById(R.id.button4);
     //suma=findViewById(R.id.button13);
    //  resta=findViewById(R.id.button9);
    //  multiplicacion=findViewById(R.id.button5);
    //  division=findViewById(R.id.button17);
    //  cero=findViewById(R.id.button14);
    //  punto=findViewById(R.id.button15);
    //  borrarc=findViewById(R.id.button19);
    //  dell=findViewById(R.id.button17);
    }
    public void button10(View v){
    String cap=pant.getText().toString();
    cap=cap+"1";
    pant.setText(cap);
    }
    public void button11(View v){
        String cap=pant.getText().toString();
        cap=cap+"2";
        pant.setText(cap);
    }
    public void button12(View v){
        String cap=pant.getText().toString();
        cap=cap+"3";
        pant.setText(cap);
    }
    public void button6(View v){
        String cap=pant.getText().toString();
        cap=cap+"4";
        pant.setText(cap);
    }
    public void button7(View v){
        String cap=pant.getText().toString();
        cap=cap+"5";
        pant.setText(cap);
    }
    public void button8(View v){
        String cap=pant.getText().toString();
        cap=cap+"6";
        pant.setText(cap);
    }
    public void button2(View v){
        String cap=pant.getText().toString();
        cap=cap+"7";
        pant.setText(cap);
    }
    public void button3(View v){
        String cap=pant.getText().toString();
        cap=cap+"8";
        pant.setText(cap);
    }
    public void button4(View v){
        String cap=pant.getText().toString();
        cap=cap+"9";
        pant.setText(cap);
    }
    public void button14(View v){
        String cap=pant.getText().toString();
        cap=cap+"0";
        pant.setText(cap);
    }
    public void button15(View v){
        String cap=pant.getText().toString();
        cap=cap+".";
        pant.setText(cap);
    }
    public void suma(View v) {
        try {
            String auxl = pant.getText().toString();
            numero1=Double.parseDouble(auxl);
        } catch (NumberFormatException nfe){};
        pant.setText("");
        ope=1;
    }
    public void resta(View v) {
        try {
            String auxl = pant.getText().toString();
            numero1=Double.parseDouble(auxl);
        } catch (NumberFormatException nfe){};
        pant.setText("");
        ope=2;
    }
    public void multiplicacion(View v) {
        try {
            String auxl = pant.getText().toString();
            numero1=Double.parseDouble(auxl);
        } catch (NumberFormatException nfe){};
        pant.setText("");
        ope=3;
    }
    public void division(View v) {
        try {
            String auxl = pant.getText().toString();
            numero1=Double.parseDouble(auxl);
        } catch (NumberFormatException nfe){};
        pant.setText("");
        ope=4;
    }
    public void igual (View v) {
        try {
            String aux2 = pant.getText().toString();
            numero2 = Double.parseDouble(aux2);
        } catch (NumberFormatException nfe){};
        pant.setText(""); //limpiar textview

        if (ope == 1) {
            res = numero1 + numero2;
        } else if (ope == 2) {
            res = numero1 - numero2;
        } else if (ope == 3) {
            res = numero1 * numero2;
        } else if (ope == 4) {
            if (numero2 == 0) {
                pant.setText("ERROR");
            } else {
                res = numero1 / numero2;
            }
        }
        pant.setText(""+res);
        numero1=res;
    }


        public void borrar(View v){
            pant.setText("");
            numero1=0.0;
            numero2=0.0;
            res=0.0;
        }
        public void borrarcadena(View v){
    if(!pant.getText().toString().equals("")){
        pant.setText(pant.getText().subSequence(0, pant.getText().length()-1)+ "");

    }
        }
        public  void cerrar(View v){
       finish();
        }

}

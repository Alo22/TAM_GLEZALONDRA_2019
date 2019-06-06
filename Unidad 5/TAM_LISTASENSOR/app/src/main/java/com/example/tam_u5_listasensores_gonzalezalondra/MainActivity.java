package com.example.tam_u5_listasensores_gonzalezalondra;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    TextView textView = null;


    ArrayList<Datos> listaUsuarios;
    RecyclerView listaObjetos;
    private RecyclerView.LayoutManager mLayoutManager;
  AdaptadorVista adapter;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle( Build.MODEL);


        listaObjetos= findViewById(R.id.cardview);
        listaObjetos.setLayoutManager(new LinearLayoutManager(this));
        listaUsuarios=new ArrayList<>();

        sensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        List<Sensor> cardview = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder data = new StringBuilder();
        StringBuilder datas = new StringBuilder();
        for(int i=1; i<cardview.size(); i++){
            try{
                data.append("Fabricante:"+cardview.get(i).getVendor() + "\n"+
                        "Nombre:"+cardview.get(i).getName() + "\n"+
                        "Version:"+cardview.get(i).getVersion() + "\n"+
                        "MaximunRange:"+cardview.get(i).getMaximumRange() + "\n"+
                        "MinDelay:"+cardview.get(i).getMinDelay() + "\n"+
                        "Power:"+cardview.get(i).getPower() + "\n"
                );
                datas.append("");
            }catch (Exception e){
                data.append("Fabricante: Sin fabricante");

            }
            listaUsuarios.add(new Datos(
                    data.toString(),
                    datas.toString(),
                    cardview.get(i).getVersion(),
                    cardview.get(i).getMaximumRange(),
                    cardview.get(i).getMinDelay()
                    ,cardview.get(i).getPower()
            ));
            data.setLength(0);
        }

        adapter = new AdaptadorVista(listaUsuarios, getApplicationContext());

        listaObjetos.setAdapter(adapter);
    }
}

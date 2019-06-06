package com.example.l_z0k.githubapi;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView nombre,user,repo, segui;
    Button button;
    EditText editText;
    ProgressDialog pd;
    private static final int MY_PERMISSIONS_REQUEST_INTERNET = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        MY_PERMISSIONS_REQUEST_INTERNET);
            }
        }

        imageView=findViewById(R.id.imageView);
        nombre=findViewById(R.id.nombre);
        user=findViewById(R.id.user);
        repo=findViewById(R.id.repo);
        segui=findViewById(R.id.segui);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTask().execute(editText.getText().toString());
                editText.setText("");
            }
        });
    }

    private class JsonTask extends AsyncTask<String, String, String> {
        Bitmap mIcon_val = null;
        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Buscando usuario");
            pd.setCancelable(false);
            pd.show();
        }

        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL("https://api.github.com/users/"+params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                JSONArray jsArr = new JSONArray( "["+reader.readLine()+"]");


                JSONObject mainObject = (JSONObject) jsArr.get(0);
                String  data = mainObject.getString("avatar_url");
                URL newurl = new URL(data);
                data +=","+mainObject.getString("login");
                data +=","+mainObject.getString("name");
                data +=","+mainObject.getString("public_repos");
                data +=","+mainObject.getString("followers");
                mIcon_val = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()) {
                pd.dismiss();
            }
            try {
                String dat[] = result.split(",");
                imageView.setImageBitmap(mIcon_val);
                nombre.setText("Repositorios visibles: "+dat[3]);
                repo.setText("Nombre usuario: "+dat[1]);
                segui.setText("Seguidores: "+dat[4]);
            }catch (Exception e){
                Toast.makeText(MainActivity.this, "no se econtraron resultados", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_INTERNET: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {}
                return;
            }
        }
    }
}
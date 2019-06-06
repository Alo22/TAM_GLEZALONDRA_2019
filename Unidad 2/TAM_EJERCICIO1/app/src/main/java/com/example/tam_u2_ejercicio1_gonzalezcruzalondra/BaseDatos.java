package com.example.tam_u2_ejercicio1_gonzalezcruzalondra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos  extends SQLiteOpenHelper {
    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PROPIETARIO(IDP VARCHAR(200) PRIMARY KEY NOT NULL,CLAVE VARCHAR(50), NOMBRE VARCHAR(200),  SALARIO DOUBLE)");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('1','fddsscc','Alondra Gonzalez cruz','6666.45')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('2','ghgfrgh','Adan Gonzalez Cruz','1200.59')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('3','hbtrg','Armando gonzalez Cruz','1600.98')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('4','gggtt','Carmen Cruz chavez','2050.77')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('5','fdvdv','Antonio Rivas Navarrete','333.43')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('6','fvfvd','Mariza Llamas Mareas','222.67')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('7','cvvv','Santiago Cruz Murillo','111.22')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('8','dfvd','Perla Perez Ramirez','598.45')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('9','fvdvs','Gerardo Cruz Chavez','557.77')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('10','sef','Carlos Huizar Lopez','2450.11')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.tam_u3_firebase_gonzalezalondra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CONDUCTOR (ID INTEGER PRIMARY KEY, LICENCIA VARCHAR(5), MONTO VARCHAR(100), PUNTOS VARCHAR(10) , CELULAR VARCHAR(20), EMAIL VARCHAR(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.tam_u1_proyecto_gonzalezcruzalondra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos  extends SQLiteOpenHelper {
    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE PROPIETARIO(IDP VARCHAR(200) PRIMARY KEY NOT NULL, NOMBRE VARCHAR(200), DOMICILIO VARCHAR(500), TELEFONO VARCHAR(50))");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('1','Alondra Gonzalez cruz','Eucalipto','123456789')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('2','Adan Gonzalez Cruz','Allende','456789234')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('3','Armando gonzalez Cruz','Cerro de san juan','1847693387')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('4','Carmen Cruz chavez','Infonavit','2358317964')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('5','Antonio Rivas Navarrete','Mirador','3333333')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('6','Mariza Llamas Mareas','Mexico','222222')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('7','Santiago Cruz Murillo','Jacarandas','11111111')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('8','Perla Perez Ramirez','Zacatecas','543216785')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('9','Gerardo Cruz Chavez','Guadalajara','55743226')");
            db.execSQL("INSERT INTO PROPIETARIO VALUES('10','Carlos Huizar Lopez','Hidalgo','24536222')");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

}

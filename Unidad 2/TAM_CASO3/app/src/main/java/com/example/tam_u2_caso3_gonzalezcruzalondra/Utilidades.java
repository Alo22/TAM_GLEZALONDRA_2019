package com.example.tam_u2_caso3_gonzalezcruzalondra;

public class Utilidades {
    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="USUARIO";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_NOCONTROL="nocontrol";
    public static final String CAMPO_CEL="cel";
    public static final String CAMPO_EMAIL="email";
    public static final String CAMPO_CARRERA="carrera";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" " + "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_NOCONTROL+" TEXT, "+CAMPO_CEL+" TEXT,"+CAMPO_EMAIL+" TEXT, "+CAMPO_CARRERA+" TEXT)";
}

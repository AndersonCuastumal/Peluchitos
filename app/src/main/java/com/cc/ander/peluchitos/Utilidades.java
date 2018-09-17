package com.cc.ander.peluchitos;

public class Utilidades {
    //constantes campos peluche
    public static final String TABLA_PELUCHE="peluche";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_CANTIDAD="cantidad";
    public static final String CAMPO_VALOR="valor";


    public static final String sqlCreate="CREATE TABLE "+TABLA_PELUCHE+" ("+CAMPO_ID+ //0
            "id     TEXT, " +CAMPO_NOMBRE+                               //1
            "nombre     TEXT, " +CAMPO_CANTIDAD+                               //2
            "cantidad   TEXT, " +CAMPO_VALOR+                               //3
            "valor     TEXT)";

}

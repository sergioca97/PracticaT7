package com.example.practicat7.DataBaseManager;

import android.provider.BaseColumns;

public class Esquema {

    public Esquema() {

    }

    public static abstract class Lugares implements BaseColumns {
        public static final String TABLE_NAME = "LUGARES";

        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_LATITUD = "latitud";
        public static final String COLUMN_NAME_LONGITUD = "longitud";
        public static final String COLUMN_NAME_COMENTARIOS = "comentarios";
        public static final String COLUMN_NAME_VALORACION = "valoracion";
        public static final String COLUMN_NAME_CATEGORIA = "categoria";

        public static final String COLUMN_TYPE_ID = "INTEGER";
        public static final String COLUMN_TYPE_NOMBRE = "TEXT";
        public static final String COLUMN_TYPE_LATITUD = "DOUBLE";
        public static final String COLUMN_TYPE_LONGITUD = "DOUBLE";
        public static final String COLUMN_TYPE_COMENTARIOS = "TEXT";
        public static final String COLUMN_TYPE_VALORACION = "FLOAT";
        public static final String COLUMN_TYPE_CATEGORIA = "INT";

    }

}

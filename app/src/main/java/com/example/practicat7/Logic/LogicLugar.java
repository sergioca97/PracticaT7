package com.example.practicat7.Logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Spinner;
import com.example.practicat7.DataBaseManager.DB_SQLite;
import com.example.practicat7.DataBaseManager.Esquema;
import com.example.practicat7.Model.Lugares;
import java.util.ArrayList;
import java.util.List;

public class LogicLugar {

    public static void insertarLugar(Context context, Lugares p) {
        ContentValues content = new ContentValues();
        content.put(Esquema.Lugares.COLUMN_NAME_NOMBRE, p.getNombre());
        content.put(Esquema.Lugares.COLUMN_NAME_LATITUD, p.getLatitud());
        content.put(Esquema.Lugares.COLUMN_NAME_LONGITUD, p.getLongitud());
        content.put(Esquema.Lugares.COLUMN_NAME_COMENTARIOS, p.getComentarios());
        content.put(Esquema.Lugares.COLUMN_NAME_VALORACION, p.getValoracion());
        content.put(Esquema.Lugares.COLUMN_NAME_CATEGORIA, p.getCategoria());
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.insert(Esquema.Lugares.TABLE_NAME, null, content);
        DB_SQLite.desconectar(conn);
    }

    public static void eliminarLugar(Context context, Lugares p) {
        String sqlWhere = Esquema.Lugares.COLUMN_NAME_ID + " = " + p.getId();
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.delete(Esquema.Lugares.TABLE_NAME, sqlWhere, null);
        DB_SQLite.desconectar(conn);
    }

    public static void editarLugar(Context context, Lugares p) {
        ContentValues content = new ContentValues();
        content.put(Esquema.Lugares.COLUMN_NAME_NOMBRE, p.getNombre());
        content.put(Esquema.Lugares.COLUMN_NAME_LATITUD, p.getLatitud());
        content.put(Esquema.Lugares.COLUMN_NAME_LONGITUD, p.getLongitud());
        content.put(Esquema.Lugares.COLUMN_NAME_COMENTARIOS, p.getComentarios());
        content.put(Esquema.Lugares.COLUMN_NAME_VALORACION, p.getValoracion());
        content.put(Esquema.Lugares.COLUMN_NAME_CATEGORIA, p.getCategoria());
        String sqlWhere = Esquema.Lugares.COLUMN_NAME_ID + " = " + p.getId();
        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_WRITE);
        conn.update(Esquema.Lugares.TABLE_NAME, content, sqlWhere, null);
        DB_SQLite.desconectar(conn);
    }

    public static List listaLugares(Context context) {
        List lug = new ArrayList<>();
        String[] sqlFields = {Esquema.Lugares.COLUMN_NAME_ID, Esquema.Lugares.COLUMN_NAME_LATITUD, Esquema.Lugares.COLUMN_NAME_LONGITUD, Esquema.Lugares.COLUMN_NAME_NOMBRE, Esquema.Lugares.COLUMN_NAME_COMENTARIOS, Esquema.Lugares.COLUMN_NAME_VALORACION, Esquema.Lugares.COLUMN_NAME_CATEGORIA};
        String sqlWhere = "";
        String sqlOrderBy = Esquema.Lugares.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Lugares.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lug = null;
        } else {
            cursor.moveToFirst();
            do {
                Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_ID));
                String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_NOMBRE));
                Double dataLatitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_LATITUD));
                Double dataLongitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_LONGITUD));
                String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_COMENTARIOS));
                Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_VALORACION));
                Integer dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_CATEGORIA));
                lug.add(new Lugares(dataId, dataNombre, dataLatitud, dataLongitud, dataComentarios, dataValoracion, dataCategoria));
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB_SQLite.desconectar(conn);
        return lug;
    }

    public static List listaLugares2(Context context, Spinner spinner) {
        List lug = new ArrayList<>();
        String[] sqlFields = {Esquema.Lugares.COLUMN_NAME_ID, Esquema.Lugares.COLUMN_NAME_NOMBRE, Esquema.Lugares.COLUMN_NAME_LATITUD, Esquema.Lugares.COLUMN_NAME_LONGITUD, Esquema.Lugares.COLUMN_NAME_COMENTARIOS, Esquema.Lugares.COLUMN_NAME_VALORACION, Esquema.Lugares.COLUMN_NAME_CATEGORIA};
        String sqlWhere = "categoria=" + spinner.getSelectedItemPosition();
        String sqlOrderBy = Esquema.Lugares.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Lugares.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lug = null;
        } else {
            cursor.moveToFirst();
            do {
                Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_ID));
                String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_NOMBRE));
                Double dataLatitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_LATITUD));
                Double dataLongitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_LONGITUD));
                String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_COMENTARIOS));
                Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_VALORACION));
                int dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_CATEGORIA));
                lug.add(new Lugares(dataId, dataNombre, dataLatitud, dataLongitud, dataComentarios, dataValoracion, dataCategoria));
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB_SQLite.desconectar(conn);
        return lug;
    }

    public static List listaLugares3(Context context, int Spinner) {
        List lug = new ArrayList<>();
        String[] sqlFields = {Esquema.Lugares.COLUMN_NAME_ID, Esquema.Lugares.COLUMN_NAME_NOMBRE, Esquema.Lugares.COLUMN_NAME_LATITUD, Esquema.Lugares.COLUMN_NAME_LONGITUD, Esquema.Lugares.COLUMN_NAME_COMENTARIOS, Esquema.Lugares.COLUMN_NAME_VALORACION, Esquema.Lugares.COLUMN_NAME_CATEGORIA};
        String sqlWhere = "categoria=" + Spinner;
        String sqlOrderBy = Esquema.Lugares.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Lugares.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lug = null;
        } else {
            cursor.moveToFirst();
            do {
                Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_ID));
                String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_NOMBRE));
                Double dataLatitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_LATITUD));
                Double dataLongitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_LONGITUD));
                String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_COMENTARIOS));
                Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_VALORACION));
                int dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_CATEGORIA));
                lug.add(new Lugares(dataId, dataNombre, dataLatitud, dataLongitud, dataComentarios, dataValoracion, dataCategoria));
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB_SQLite.desconectar(conn);
        return lug;
    }

    public static Lugares listaLugares4(Context context, String latitud, String longitud) {
        Lugares lug = null;
        String[] sqlFields = {Esquema.Lugares.COLUMN_NAME_ID, Esquema.Lugares.COLUMN_NAME_NOMBRE, Esquema.Lugares.COLUMN_NAME_LATITUD, Esquema.Lugares.COLUMN_NAME_LONGITUD, Esquema.Lugares.COLUMN_NAME_COMENTARIOS, Esquema.Lugares.COLUMN_NAME_VALORACION, Esquema.Lugares.COLUMN_NAME_CATEGORIA};
        String sqlWhere = "latitud='" + latitud + "'and longitud='" + longitud + "'";
        String sqlOrderBy = Esquema.Lugares.COLUMN_NAME_NOMBRE + " ASC";

        SQLiteDatabase conn = DB_SQLite.conectar(context, DB_SQLite.OPEN_MODE_READ);
        Cursor cursor = conn.query(Esquema.Lugares.TABLE_NAME, sqlFields, sqlWhere, null, null, null, sqlOrderBy);
        if (cursor.getCount() == 0) {
            lug = null;
        } else {
            cursor.moveToFirst();
            Long dataId = cursor.getLong(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_ID));
            String dataNombre = cursor.getString(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_NOMBRE));
            Double dataLatitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_LATITUD));
            Double dataLongitud = cursor.getDouble(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_LONGITUD));
            String dataComentarios = cursor.getString(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_COMENTARIOS));
            Float dataValoracion = cursor.getFloat(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_VALORACION));
            int dataCategoria = cursor.getInt(cursor.getColumnIndex(Esquema.Lugares.COLUMN_NAME_CATEGORIA));
            lug = new Lugares(dataId, dataNombre, dataLatitud, dataLongitud, dataComentarios, dataValoracion, dataCategoria);


            cursor.close();
            DB_SQLite.desconectar(conn);
        }
        return lug;

    }
}

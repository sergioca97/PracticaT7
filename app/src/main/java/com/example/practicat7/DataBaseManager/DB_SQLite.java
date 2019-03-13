package com.example.practicat7.DataBaseManager;
import com.example.practicat7.DataBaseManager.Esquema.Lugares;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_SQLite extends SQLiteOpenHelper {

    public static final int OPEN_MODE_READ = 1;
    public static final int OPEN_MODE_WRITE = 2;

    private static final String DATABASE_NAME = "Lugares.sqlite";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Lugares.TABLE_NAME + " (" +
                    Lugares.COLUMN_NAME_ID + " " + Lugares.COLUMN_TYPE_ID + " PRIMARY KEY AUTOINCREMENT, " +
                    Lugares.COLUMN_NAME_NOMBRE + " " + Lugares.COLUMN_TYPE_NOMBRE + "," +
                    Lugares.COLUMN_NAME_LATITUD + " " + Lugares.COLUMN_TYPE_LATITUD + "," +
                    Lugares.COLUMN_NAME_LONGITUD + " " + Lugares.COLUMN_TYPE_LONGITUD + "," +
                    Lugares.COLUMN_NAME_COMENTARIOS + " " + Lugares.COLUMN_TYPE_COMENTARIOS +  "," +
                    Lugares.COLUMN_NAME_VALORACION + " " + Lugares.COLUMN_TYPE_VALORACION + "," +
                    Lugares.COLUMN_NAME_CATEGORIA + " " + Lugares.COLUMN_TYPE_CATEGORIA + ")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Lugares.TABLE_NAME;

    public DB_SQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public static SQLiteDatabase conectar(Context context, int open_mode) {
        DB_SQLite db = new DB_SQLite(context);
        SQLiteDatabase conn;
        switch (open_mode) {
            case OPEN_MODE_READ:  conn = db.getReadableDatabase(); break;
            case OPEN_MODE_WRITE: conn = db.getWritableDatabase(); break;
            default:              conn = db.getReadableDatabase(); break;
        }
        return conn;
    }

    public static void desconectar(SQLiteDatabase conn) {
        conn.close();
    }

}

package com.example.practicat7;

import android.content.Context;

import com.example.practicat7.Model.Lugares;

import java.util.ArrayList;
import java.util.List;

public class App {

    public final static int INSERTAR = 1;
    public final static int EDITAR = 2;
    public final static int INFORMACION = 3;
    public static int accion;
    public static int SALIDA;
    public static int lugarNuevo;
    public static Lugares lugarActivo;
    public static List<String> getListCategorias(Context context) {
        List<String> list = new ArrayList<String>();
        list.add(context.getResources().getString(R.string.TodaslasCategorias));
        list.add(context.getResources().getString(R.string.Farmacias));
        list.add(context.getResources().getString(R.string.CentrosComerciales));
        list.add(context.getResources().getString(R.string.Bares));
        list.add(context.getResources().getString(R.string.Aeropuertos));
        list.add(context.getResources().getString(R.string.Restaurantes));


        return list;
    }
}

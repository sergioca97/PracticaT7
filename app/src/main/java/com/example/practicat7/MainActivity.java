package com.example.practicat7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.practicat7.Logic.LogicLugar;
import com.example.practicat7.Model.Lugares;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    Spinner spCategorias;
    ImageView imgMapa;
    private static List<Lugares> listaLugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMapa = findViewById(R.id.imgMapa);

        spCategorias = findViewById(R.id.spCategorias);
        List<String> list = new ArrayList<String>();
        list.add(getResources().getString(R.string.TodaslasCategorias));
        list.add(getResources().getString(R.string.Farmacias));
        list.add(getResources().getString(R.string.CentrosComerciales));
        list.add(getResources().getString(R.string.Bares));
        list.add(getResources().getString(R.string.Aeropuertos));
        list.add(getResources().getString(R.string.Restaurantes));


        final int listsize = list.size();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list) {
            @Override
            public int getCount() {
                return(listsize); // Truncate the list
            }
        };
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategorias.setAdapter(dataAdapter);

        imgMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PantallaMapa.class));
                App.lugarNuevo =(int) (long) spCategorias.getSelectedItemId();
            }
        });

        spCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spCategorias.getSelectedItem().toString()==getResources().getString(R.string.TodaslasCategorias)){
                    mostrarTodos();
                }else{
                    mostrarUno();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView = findViewById(R.id.listTarjetas);
        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        App.lugarActivo = listaLugares.get(position - 1);
                        App.accion = App.INFORMACION;
                        startActivity(new Intent(getApplicationContext(), PantallaInformacion.class));
                    }
                }
        );
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if(spCategorias.getSelectedItem().toString() == getResources().getString(R.string.TodaslasCategorias))
        {
            mostrarTodos();
        }
        else
        {
            mostrarUno();
        }
    }

    public void clicNuevo(View view) {
        App.lugarActivo = new Lugares();
        App.accion = App.INSERTAR;
        App.SALIDA=2;
        startActivity(new Intent(this, PantallaNuevoEdicion.class));
    }
    public void mostrarUno() {
        CardAdapter listadoDeCards = new CardAdapter(getApplicationContext(), R.layout.activity_card_list);
        listaLugares = LogicLugar.listaLugares2(this, spCategorias);
        if (listaLugares == null) {
            listView.setAdapter(null);
        } else {
            for (Lugares p : listaLugares) {
                listadoDeCards.add(p);
            }
            listView.setAdapter(listadoDeCards);
        }
    }
    public void mostrarTodos()
    {
        CardAdapter listadoDeCards = new CardAdapter(getApplicationContext(), R.layout.activity_card_list);
        listaLugares= LogicLugar.listaLugares(this);
        if (listaLugares == null) {
            listView.setAdapter(null);
        } else {
            for (Lugares p : listaLugares) {
                listadoDeCards.add(p);
            }
            listView.setAdapter(listadoDeCards);
        }
    }
}

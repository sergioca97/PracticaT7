package com.example.practicat7;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.practicat7.DataBaseManager.Esquema;
import com.example.practicat7.DataBaseManager.DB_SQLite;

public class PantallaInformacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_informacion);
        TextView txtResultNombre = findViewById(R.id.txtResultNombre);
        TextView txtResultLatitud = findViewById(R.id.txtResultLatitud);
        TextView txtResultLongitud = findViewById(R.id.txtResultLongitud);
        TextView txtResultCategoria = findViewById(R.id.txtResultCategoria);
        EditText edtComentarios = findViewById(R.id.edtComentarios);
        RatingBar rtValoracion = findViewById(R.id.rtValoracion);
        if(App.lugarActivo==null)
        {

        }
        else
        {
            txtResultNombre.setText(App.lugarActivo.getNombre());
            txtResultLongitud.setText(App.lugarActivo.getLongitud().toString());
            txtResultLatitud.setText(App.lugarActivo.getLatitud().toString());
            txtResultCategoria.setText(App.getListCategorias(this).get(App.lugarActivo.getCategoria()-1));
            edtComentarios.setText(App.lugarActivo.getComentarios());
            rtValoracion.setRating(App.lugarActivo.getValoracion());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.informacion, menu);
        return true;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcionEditar:
                App.SALIDA = 1;
                startActivity(new Intent(getApplicationContext(), PantallaNuevoEdicion.class));
                finish();
                break;
            case R.id.opcionBorrar:
                confirmacionEliminar();

                break;
        }
        return false;
    }

    private void eliminar()
    {
        DB_SQLite db = new DB_SQLite(this);
        SQLiteDatabase conn = db.getWritableDatabase();
        String sqlWhere = Esquema.Lugares.COLUMN_NAME_ID + " LIKE '" + App.lugarActivo.getId() + "'";
        conn.delete(Esquema.Lugares.TABLE_NAME, sqlWhere, null);
        Toast.makeText(this, getResources().getString(R.string.toastEliminar), Toast.LENGTH_LONG).show();
        conn.close();
    }
    private void confirmacionEliminar()
    {
        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.eliminarInformacion))
                .setMessage(getResources().getString(R.string.confirmareliminar))
                .setPositiveButton(getResources().getString(R.string.Eliminar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        eliminar();
                        finish();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.Cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}


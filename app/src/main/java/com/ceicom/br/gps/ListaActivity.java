package com.ceicom.br.gps;

import android.app.ListActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    SimpleCursorAdapter adapter;
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvLista = (ListView) findViewById(R.id.listView);

        DBController crud = new DBController(getBaseContext());
        final Cursor cursor = crud.loadDados();
        String [] nomeCampos = new String[] {CreateDB.id, CreateDB.nome, CreateDB.telefone1};
        int [] idView = new int[] { android.R.id.text1, android.R.id.text2};

        adapter = null;

        try {
            adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, nomeCampos, idView, 2);
            lvLista.setAdapter(adapter);
        } catch (RuntimeException e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}

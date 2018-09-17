package com.cc.ander.peluchitos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Peluche> listPeluche;
    private PelucheAdapter pelucheAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inventario);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        listPeluche = new ArrayList<>();

        pelucheAdapter = new PelucheAdapter(listPeluche);
        recyclerView.setAdapter(pelucheAdapter);

        loadData();
    }

    private void loadData() {

        PelucheSQLiteHelper pelucheSQLiteHelper;
        SQLiteDatabase dbPeluche;

        pelucheSQLiteHelper = new PelucheSQLiteHelper(
                this,
                "pelucheBD",
                null,
                1);

        dbPeluche = pelucheSQLiteHelper.getWritableDatabase();

        Cursor c = dbPeluche.rawQuery(
                "SELECT * FROM peluche",
                null);

        if(c.moveToFirst()){
            do{
                Peluche peluche = new Peluche(
                        c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3));
                listPeluche.add(peluche);
            }while (c.moveToNext());
            pelucheAdapter.notifyDataSetChanged();
        } else{
            Toast.makeText(this,"No hay peluches",Toast.LENGTH_SHORT).show();
        }
    }
}

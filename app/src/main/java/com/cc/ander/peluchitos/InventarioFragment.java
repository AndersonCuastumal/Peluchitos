package com.cc.ander.peluchitos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventarioFragment extends Fragment {

private TextView tId,tAgregar,tCantidad,tValor;
private ListActivity listActivity;
private RecyclerView recyclerView;
private ArrayList<Peluche> pelucheList;


    public InventarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inventario, container, false);
        pelucheList=new ArrayList<>();
        listActivity=new ListActivity();
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        obtenerPeluches();

        PelucheAdapter adapter=new PelucheAdapter(pelucheList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void obtenerPeluches() {

        pelucheList.add(new Peluche("esto","si","funciona","!!!"));
        Intent intent=new Intent(getContext(),ListActivity.class);
        startActivity(intent);
    }

}

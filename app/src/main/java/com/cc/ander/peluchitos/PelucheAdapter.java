package com.cc.ander.peluchitos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PelucheAdapter extends RecyclerView.Adapter<PelucheAdapter.PelucheViewHolder>{

    private ArrayList<Peluche> pelucheList;

    public PelucheAdapter(ArrayList<Peluche> pelucheList) {
        this.pelucheList=pelucheList;
    }

    @NonNull
    @Override
    public PelucheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.peluche_lista, parent,false);

        return new PelucheViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PelucheViewHolder holder, int position) {
        Peluche peluche = pelucheList.get(position);
        holder.bindPeluche(peluche);
    }

    @Override
    public int getItemCount() {
        return pelucheList.size();
    }

    public class PelucheViewHolder  extends RecyclerView.ViewHolder{

        private TextView tId,tAgregar, tCantidad, tValor;

        public PelucheViewHolder(View itemView) {
            super(itemView);
            tId = itemView.findViewById(R.id.tId);
            tAgregar = itemView.findViewById(R.id.tAgregar);
            tCantidad = itemView.findViewById(R.id.tCantidad);
            tValor = itemView.findViewById(R.id.tValor);
        }

        public void bindPeluche(Peluche peluche){
            tId.setText(peluche.getId());
            tAgregar.setText(peluche.getNombre());
            tCantidad.setText(peluche.getCantidad());
            tValor.setText(peluche.getValor());
        }
    }
}

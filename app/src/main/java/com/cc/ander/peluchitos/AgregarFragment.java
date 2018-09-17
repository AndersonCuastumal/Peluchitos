package com.cc.ander.peluchitos;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment  implements View.OnClickListener {



    private EditText eAgregar,eCantidad,eId,eValor;
    private Button bNew;


    Comunicador enlace;


    public AgregarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_agregar, container, false);

        eAgregar=view.findViewById(R.id.eAgregar);
        eCantidad=view.findViewById(R.id.eCantidad);
        eValor=view.findViewById(R.id.eValor);
        eId=view.findViewById(R.id.eId);
        bNew=view.findViewById(R.id.bNew);


        bNew.setOnClickListener(this);


        return view;
    }



    @Override
    public void onClick(View view) {
        String id="",agregar="",cantidad="",valor="";
        id=eId.getText().toString();
        cantidad=eCantidad.getText().toString();
        valor=eValor.getText().toString();
        agregar=eAgregar.getText().toString();

        if(id.equals("")||cantidad.equals("")||valor.equals("")||agregar.equals("")){
             id="";
             agregar="";
             cantidad="";
             valor="";
            enlace.interaccion(id,agregar,cantidad,valor);
            Toast.makeText(getActivity(),"ingresar todos los datos",Toast.LENGTH_SHORT).show();
        }else{

            enlace.interaccion(id,agregar,cantidad,valor);
            Toast.makeText(getActivity(),"almacenando...",Toast.LENGTH_SHORT).show();
            cleanWidgtes();
        }
    }

    private void cleanWidgtes() {
        eId.setText("");
        eAgregar.setText("");
        eCantidad.setText("");
        eValor.setText("");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            enlace=(Comunicador) activity;
        }catch(ClassCastException e){

        }
    }


}

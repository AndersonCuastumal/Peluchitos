package com.cc.ander.peluchitos;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarFragment extends Fragment implements View.OnClickListener {


    private EditText eBuscar,eId,eValor;
    private Button bBuscar;


    private SQLiteDatabase dbPeluche;
    private ContentValues dataBD;

    private PelucheSQLiteHelper pelucheSQLiteHelper;



    public BuscarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_buscar, container, false);

        eBuscar=view.findViewById(R.id.eBuscar);
        eId=view.findViewById(R.id.eId);
        eValor=view.findViewById(R.id.eValor);
        bBuscar=view.findViewById(R.id.bBuscar);

        bBuscar.setOnClickListener(this);

        pelucheSQLiteHelper=new PelucheSQLiteHelper(getContext(),"pelucheBD",null,1);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bBuscar:
                consultar();
                break;

        }
    }

    private void consultar() {
        SQLiteDatabase db=pelucheSQLiteHelper.getReadableDatabase();
        String[] parameters={eBuscar.getText().toString()};
        String[] campos={Utilidades.CAMPO_ID,Utilidades.CAMPO_VALOR};

        try{
            Cursor cursor=db.query(Utilidades.TABLA_PELUCHE,campos,Utilidades.CAMPO_ID+"=?",parameters,null,null,null);
            cursor.moveToFirst();
            eId.setText(cursor.getString(0));
            eValor.setText(cursor.getString(3));
            cursor.close();

        }catch(Exception e){
            Toast.makeText(getContext(),Utilidades.CAMPO_ID,Toast.LENGTH_SHORT).show();
            cleanwidgets();
        }

    }

    private void cleanwidgets() {
        eId.setText("");
        eValor.setText("");
    }
}

package com.cc.ander.peluchitos;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class BottonNavigationActivity extends AppCompatActivity implements Comunicador{

    private FragmentManager fm;
    private FragmentTransaction ft;

    private PelucheSQLiteHelper pelucheSQLiteHelper;
    private SQLiteDatabase dbPeluche;
    private ContentValues dataBD;
    private String eAgregar,eCantidad,eId,eValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botton_navigation);
        BottomNavigationView bottomNav=findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();


        AgregarFragment selectedFragment =new AgregarFragment();
        ft.add(R.id.fragment_container,selectedFragment).commit();

        BottomNavigationView navigation=(BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);

        pelucheSQLiteHelper = new PelucheSQLiteHelper(this,"pelucheBD",null,1);

        dbPeluche = pelucheSQLiteHelper.getWritableDatabase();

     }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_agregar:
                    AgregarFragment agregarFragment = new AgregarFragment();
                    ft.replace(R.id.fragment_container, agregarFragment).commit();
                    return true;
                case R.id.navigation_buscar:
                    BuscarFragment buscarFragment = new BuscarFragment();
                    ft.replace(R.id.fragment_container, buscarFragment).commit();
                    return true;
                case R.id.navigation_inventario:
                    InventarioFragment inventarioFragment = new InventarioFragment();
                    ft.replace(R.id.fragment_container, inventarioFragment).commit();
                    return true;
                case R.id.navigation_eliminar:
                    EliminarFragment eliminarFragment = new EliminarFragment();
                    ft.replace(R.id.fragment_container, eliminarFragment).commit();
                    return true;
            }
            return false;
        }
    };



    @Override
    public void interaccion(String id,String agregar,String cantidad,String valor) {
        eId=id;
        eAgregar=agregar;
        eCantidad=cantidad;
        eValor=valor;

        PelucheSQLiteHelper pelucheSQLiteHelper = new PelucheSQLiteHelper(this,"pelucheBD",null,1);
        SQLiteDatabase db=pelucheSQLiteHelper.getWritableDatabase();


        if(eId.equals("")||eAgregar.equals("")||eCantidad.equals("")||eValor.equals("")){
            Toast.makeText(this,"error ingresar todos los datos ",Toast.LENGTH_SHORT).show();
        }else{
            ContentValues dataBD = new ContentValues();
            dataBD.put(Utilidades.CAMPO_ID, eId);
            dataBD.put(Utilidades.CAMPO_NOMBRE,eAgregar);
            dataBD.put(Utilidades.CAMPO_CANTIDAD,eCantidad);
            dataBD.put(Utilidades.CAMPO_VALOR,eValor);
            Long idRetorno=db.insert(Utilidades.TABLA_PELUCHE,Utilidades.CAMPO_ID,dataBD);

            Toast.makeText(getApplicationContext(),"Nombre Registro: "+idRetorno,Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

}

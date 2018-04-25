package com.programacion3.hypegeeks.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class Tienda extends AppCompatActivity {

   private ListView listView;
   private List<ObjetosDeTienda> tiendaList= new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda2);

        ListView listView = findViewById(R.id.listaDeTienda);

       // LlenadordeListTienda llenador = new LlenadordeListTienda(tiendaList);
       // tiendaList=llenador.getList();
        for(int i =0; i<15;i++){
            tiendaList.add(new ObjetosDeTienda(i,R.drawable.copita,""+i));

        }


        AdaptadorDeObjetosDeTienda adapter = new AdaptadorDeObjetosDeTienda(this,tiendaList);
        listView.setAdapter(adapter);

    }
}

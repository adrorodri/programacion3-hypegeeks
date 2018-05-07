package com.programacion3.hypegeeks.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import java.util.LinkedList;
import java.util.List;

public class Tienda extends AppCompatActivity {

   private RecyclerView recyclerView;
   private List<ObjetosDeTienda> tiendaList= new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda2);

        recyclerView = findViewById(R.id.listaDeTienda);

     LlenadorDeLista();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        AdaptadorDeObjetosDeTienda adapter = new AdaptadorDeObjetosDeTienda(tiendaList);
        recyclerView.setAdapter(adapter);

    }

    private void LlenadorDeLista() {

        for(int i =0; i<15;i++){
            tiendaList.add(new ObjetosDeTienda(i,R.drawable.messi,""+i));

        }
    }
}

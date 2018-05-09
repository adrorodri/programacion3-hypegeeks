package com.programacion3.hypegeeks.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class ListaDeRepetidas extends AppCompatActivity {

    RecyclerView recyclerView;
    List<IteamsDePendientes> data = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_repetidas);

        recyclerView = findViewById(R.id.listaDePendientes);
        llenadorDeLista();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        AdapatadorDeIteamsDePendientes adapter = new AdapatadorDeIteamsDePendientes(data);
        recyclerView.setAdapter(adapter);

    }

    private void llenadorDeLista() {

        for(int i =0; i>10; i++){
            data.add(new IteamsDePendientes(R.drawable.messi,"por ahora esto",R.drawable.messi));
        }
    }
}

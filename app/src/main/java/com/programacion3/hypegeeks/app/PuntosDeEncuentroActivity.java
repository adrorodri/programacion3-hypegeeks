package com.programacion3.hypegeeks.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class PuntosDeEncuentroActivity extends AppCompatActivity {

    List<PuntosParaPuntosDeEncuentro> data = new LinkedList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos_de_encuentro);
        recyclerView = findViewById(R.id.recyclerDePuntosDeEncunetro);

        LlenadorDeLista();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        AdaptadorDePuntosDeEncuentros adapter = new AdaptadorDePuntosDeEncuentros(data);
        recyclerView.setAdapter(adapter);
    }
    private void LlenadorDeLista() {
        for(int i=0;i<15;i++){
            data.add(new PuntosParaPuntosDeEncuentro("Calle No "+i));
        }
    }
}
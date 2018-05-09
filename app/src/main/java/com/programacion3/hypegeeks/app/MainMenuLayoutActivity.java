package com.programacion3.hypegeeks.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainMenuLayoutActivity extends AppCompatActivity {

private List<Cuadritos> tablaDeContenidos = new LinkedList<>();

RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
        recyclerView = findViewById(R.id.tablaDeFigutitas);

        llenadorDeTabla();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 9);
        recyclerView.setLayoutManager(gridLayoutManager);

        AdaptadorDeCuadritos adapter = new AdaptadorDeCuadritos(tablaDeContenidos);
        recyclerView.setAdapter(adapter);

    }

    public void clickMainMenu(View view){
        Intent intent;
        switch (view.getId()) {
            case R.id.botonRepetidas: {
                intent = new Intent(this, RepeLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.aniadir:{
                intent = new Intent(this, ListAdds.class);
                startActivity(intent);
                break;
            }
            case R.id.carrito:{
                intent = new Intent(this,Tienda.class);
                startActivity(intent);
                break;
            }
        }
    }

    public void llenadorDeTabla(){
        //por ahora fors
        for(int i=1; i<121;i++){
            tablaDeContenidos.add(new Cuadritos(""+i));
        }

    }
}

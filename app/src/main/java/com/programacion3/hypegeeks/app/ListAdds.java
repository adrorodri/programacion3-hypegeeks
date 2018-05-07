package com.programacion3.hypegeeks.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;



public class ListAdds extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Figuritas> figuritasList= new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adds);

        recyclerView= findViewById(R.id.ListaAdds);

        LlenadorDelista();



        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);



        AdapterAdds adapter= new AdapterAdds(figuritasList);
        recyclerView.setAdapter(adapter);

    }

    private void LlenadorDelista() {

        //por ahora

        for(int i =0; i<15;i++){
            figuritasList.add(new Figuritas(i,R.drawable.argentina,R.drawable.messi,""+i));

        }

    }
}

package com.programacion3.hypegeeks.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.LinkedList;
import java.util.List;



public class ListAdds extends AppCompatActivity {



    ListView listView;
    List<Figuritas> figuritasList= new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adds);

        ListView listView= findViewById(R.id.ListaAdds);

        LlenadorDeListasAdd llenador = new LlenadorDeListasAdd(figuritasList);

    figuritasList=llenador.getFiguritasList();

        AdapterAdds adapter= new AdapterAdds(this, figuritasList);
        listView.setAdapter(adapter);

    }
}

package com.programacion3.hypegeeks.app;



import java.util.LinkedList;
import java.util.List;

public class LlenadorDeListasAdd {

    private List<Figuritas> figuritasList= new LinkedList<>();

    public LlenadorDeListasAdd(List<Figuritas> figuritasList) {
        this.figuritasList = figuritasList;
    }

// esta es provicional
    public void llenarLista(){
        for(int i =0; i<15;i++){
            figuritasList.add(new Figuritas(i,R.drawable.messi,R.drawable.ic_action_busqueda,""+i));

        }

    }

    public List<Figuritas> getFiguritasList() {
        return figuritasList;
    }
}

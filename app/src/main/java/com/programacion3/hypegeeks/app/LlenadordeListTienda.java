package com.programacion3.hypegeeks.app;

import java.util.LinkedList;
import java.util.List;

class LlenadordeListTienda {

    private List<ObjetosDeTienda> list= new LinkedList<>();

    public LlenadordeListTienda(List<ObjetosDeTienda> list) {
        this.list = list;
    }

    // esta es provicional
    public void llenarLista(){
        for(int i =0; i<15;i++){
            list.add(new ObjetosDeTienda(i,R.drawable.copita,""+i));

        }

    }

    public List<ObjetosDeTienda> getList() {
        return list;
    }

}

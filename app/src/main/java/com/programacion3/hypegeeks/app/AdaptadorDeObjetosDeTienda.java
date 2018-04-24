package com.programacion3.hypegeeks.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedList;
import java.util.List;

public class AdaptadorDeObjetosDeTienda extends BaseAdapter {

    Context context;
    List<ObjetosDeTienda> tiendaList= new LinkedList<>();
    LayoutInflater inflater;

    public AdaptadorDeObjetosDeTienda(Context context,List<ObjetosDeTienda> tiendaList) {
        this.context = context;
        this.tiendaList=tiendaList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}

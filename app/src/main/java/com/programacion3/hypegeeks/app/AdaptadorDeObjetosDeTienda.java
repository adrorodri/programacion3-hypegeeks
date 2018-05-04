package com.programacion3.hypegeeks.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

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
        return tiendaList.size();
    }

    @Override
    public Object getItem(int i) {
        return tiendaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return tiendaList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.objetos_para_en_venta,null);
        }

        TextView precio = view.findViewById(R.id.precio);
        precio.setText(tiendaList.get(i).getPrecio());

        ImageButton foto= view.findViewById(R.id.cosaParaVender);
        foto.setImageResource(tiendaList.get(i).getFoto());
foto.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //Aqui, obio, no hay nada
    }
});

        return view;
    }
}

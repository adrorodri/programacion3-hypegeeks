package com.programacion3.hypegeeks.app;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorDeObjetosDeTienda extends RecyclerView.Adapter<AdaptadorDeObjetosDeTienda.ViewHolder>  {

   private  List<ObjetosDeTienda> Data;

    static  class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foto;
        TextView precio;

        public ViewHolder(View v) {
            super(v);
            foto = v.findViewById(R.id.cosaParaVender);
            precio = v.findViewById(R.id.precio);
        }
    }


    public AdaptadorDeObjetosDeTienda(List<ObjetosDeTienda> data) {
        this.Data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.objetos_para_en_venta,parent,false);
        return  new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.precio.setText(Data.get(position).getPrecio());
        holder.foto.setImageResource(Data.get(position).getFoto());
        holder.foto.setScaleType(ImageView.ScaleType.FIT_CENTER);

    }



    @Override
    public int getItemCount() {
        return Data.size();
    }
}

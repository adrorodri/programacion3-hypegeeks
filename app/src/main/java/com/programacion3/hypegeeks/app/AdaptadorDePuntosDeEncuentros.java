package com.programacion3.hypegeeks.app;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorDePuntosDeEncuentros extends RecyclerView.Adapter<AdaptadorDePuntosDeEncuentros.ViewHolder> {

    private List<PuntosParaPuntosDeEncuentro> data;

    static  class ViewHolder extends RecyclerView.ViewHolder {

        TextView direccion;
        ImageButton button;

        public ViewHolder(View v) {
            super(v);
            direccion = v.findViewById(R.id.textoDePuntosDeBusqueda);
            button =v.findViewById(R.id.botonDePuntosDeBusqueda);
        }
    }

    public AdaptadorDePuntosDeEncuentros(List<PuntosParaPuntosDeEncuentro> data) {
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.puntos_de_busqueda,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

holder.direccion.setText(data.get(position).getDireccion());
holder.button.setImageResource(R.drawable.ic_action_name);
holder.button.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

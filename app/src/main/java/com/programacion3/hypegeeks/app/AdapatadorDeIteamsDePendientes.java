package com.programacion3.hypegeeks.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapatadorDeIteamsDePendientes extends RecyclerView.Adapter<AdapatadorDeIteamsDePendientes.ViewHolder> {

    static  class ViewHolder extends RecyclerView.ViewHolder {

        ImageView primeraFoto;
        ImageView iconito;
        ImageView segundaFoto;
        ImageButton boton;
        TextView direccion;

        public ViewHolder(View v) {
            super(v);
            primeraFoto = v.findViewById(R.id.primeraFiguritaDePendinetes);
            iconito = v.findViewById(R.id.iconoDePendientes);
            segundaFoto= v.findViewById(R.id.segundaFiguritaDePendientes);
            boton = v.findViewById(R.id.botonDePendientes);
            direccion=v.findViewById(R.id.direccionDePendientes);

        }
    }

    List<IteamsDePendientes> data;

    public AdapatadorDeIteamsDePendientes(List<IteamsDePendientes> data) {
    this.data= data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam_de_pendientes,parent,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.primeraFoto.setImageResource(data.get(position).getPrimeraFigurita());
        holder.segundaFoto.setImageResource(data.get(position).getSegundaFigurita());
        holder.iconito.setImageResource(R.drawable.boton_redondo);
        holder.boton.setImageResource(R.drawable.ic_action_name);
        holder.direccion.setText(data.get(position).getDireccion());
        //funcionalidad del buton

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

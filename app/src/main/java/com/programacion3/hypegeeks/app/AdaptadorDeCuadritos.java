package com.programacion3.hypegeeks.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public  class AdaptadorDeCuadritos extends RecyclerView.Adapter<AdaptadorDeCuadritos.ViewHolder> {

    //hola

    private List<Cuadritos> data;

    static  class ViewHolder extends RecyclerView.ViewHolder {

        TextView numeroDefigura;

        public ViewHolder(View v) {
            super(v);
            numeroDefigura = v.findViewById(R.id.numeroDelaFiguraEnElTablero);

        }
    }

    public AdaptadorDeCuadritos(List<Cuadritos> data) {
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuadritos_de_tablas_de_figuritas,parent,false);
        return  new ViewHolder(v);
    }

    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.numeroDefigura.setText(data.get(position).getText());

    if(false) {

        holder.numeroDefigura.setBackgroundResource(R.drawable.boton_redondo);
    }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

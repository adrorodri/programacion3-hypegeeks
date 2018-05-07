package com.programacion3.hypegeeks.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public  class AdaptadorDeCuadritos extends RecyclerView.Adapter<AdaptadorDeCuadritos.ViewHolder> {

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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cudritos_de_tablas_de_figuritas,parent,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//aqui podriamos poner botones
        holder.numeroDefigura.setText(data.get(position).getText());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

package com.programacion3.hypegeeks.app;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterAdds extends RecyclerView.Adapter<AdapterAdds.ViewHolder> {

private List<Figuritas> data;


    static  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView foto;
        ImageView bandera;
        TextView numeroDeFigurita;
        Button button;

        ViewHolder (View view){
            super(view);
            foto  = view.findViewById(R.id.figuritaDeJugador);
            bandera = view.findViewById(R.id.banderaDelPais);
            numeroDeFigurita = view.findViewById(R.id.numroDeFigurita);
            button = view.findViewById(R.id.buttonAdd);

        }

    }

    public AdapterAdds(List<Figuritas> data) {
        this.data = data;
    }

    @Override
    public AdapterAdds.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adds_figuritas,parent,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterAdds.ViewHolder holder, int position) {

        holder.foto.setImageResource(data.get(position).getFoto());
        holder.bandera.setImageResource(data.get(position).getBandera());
        holder.numeroDeFigurita.setText(data.get(position).getNumeroDeFigurita());
        //hay que ponerle funcion al botton


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

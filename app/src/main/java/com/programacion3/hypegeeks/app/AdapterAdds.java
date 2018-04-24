package com.programacion3.hypegeeks.app;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Inflater;

public class AdapterAdds extends BaseAdapter {

   Context context;
    List<Figuritas> AddsList = new LinkedList<>();
    LayoutInflater inflater;

    public AdapterAdds(Context context,List<Figuritas> AddsList ){
        this.AddsList=AddsList;
        this.context=context;


    }

    @Override
    public int getCount() {
        return AddsList.size();
    }

    @Override
    public Object getItem(int position) {
        return AddsList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return AddsList.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.adds_figuritas,null);
        }

        TextView numeroDeFigurita = convertView.findViewById(R.id.numroDeFigurita);
        numeroDeFigurita.setText(AddsList.get(position).getNumeroDeFigurita());

        ImageView foto = convertView.findViewById(R.id.figuritaDeJugador);
        foto.setImageResource(AddsList.get(position).getFoto());

        ImageView bandera = convertView.findViewById(R.id.banderaDelPais);
        bandera.setImageResource(AddsList.get(position).getBandera());


//Talvez aquí talvez halla un problema
        final Button button = convertView.findViewById(R.id.buttonAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(button.getText().equals("+")){
                    button.setText("-");
                }else{
                    button.setText("+");
                }

            }
        });

        return convertView;
    }
}

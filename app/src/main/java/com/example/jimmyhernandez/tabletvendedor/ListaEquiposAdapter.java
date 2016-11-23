package com.example.jimmyhernandez.tabletvendedor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by simaski on 23/11/16.
 */

public class ListaEquiposAdapter  extends RecyclerView.Adapter<ListaEquiposAdapter.ViewHolder>{

    private List<ItemEquipos> equiposList;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView modelo;
        public TextView marca;
        public TextView nombre;

        public ViewHolder(View itemView) {
            super(itemView);

            modelo = (ImageView) itemView.findViewById(R.id.ivImagenEquipo);
            marca = (TextView) itemView.findViewById(R.id.tvMarcaEquipo);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreEquipo);


        }
    }


    public ListaEquiposAdapter(List<ItemEquipos> equiposList) {
        this.equiposList = equiposList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accesorios, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipos, parent, false);
        ViewHolder pvh = new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemEquipos item = equiposList.get(position);
        holder.modelo.setImageResource(item.getPhotoId());
        holder.marca.setText(item.getMarca());
        holder.nombre.setText(item.getNombre());
    }

    @Override
    public int getItemCount() {
        return equiposList.size();
    }


}
package com.example.jimmyhernandez.tabletvendedor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by simaski on 06/12/16.
 */

public class ListaCatalogoEquiposAdapter extends RecyclerView.Adapter<ListaCatalogoEquiposAdapter.ViewHolder>{

    private List<ItemCatalogoEquipos> equiposList;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre;
        public TextView tipo;
        public ImageView modelo;

        public ViewHolder(View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.tvMarcaEquipoDestacado);
            tipo = (TextView) itemView.findViewById(R.id.tvModeloEquipoDestacado);
            modelo = (ImageView) itemView.findViewById(R.id.ivImagenEquipoDestacado);


        }
    }


    public ListaCatalogoEquiposAdapter(List<ItemCatalogoEquipos> accesoriosList) {
        this.equiposList = accesoriosList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accesorios, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipos_destacados, parent, false);
        ViewHolder pvh = new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemCatalogoEquipos item = equiposList.get(position);
        holder.modelo.setImageResource(item.getPhotoId());
        holder.nombre.setText(item.getNombre());
        holder.tipo.setText(item.getTipo());


    }

    @Override
    public int getItemCount() {
        return equiposList.size();
    }


}
package com.example.jimmyhernandez.tabletvendedor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simaski on 21/11/16.
 */

public class ListaAccesoriosAdapter  extends RecyclerView.Adapter<ListaAccesoriosAdapter.ViewHolder>{

    private List<ItemAccesorio> accesoriosList;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView modelo;
        public TextView nombre;
        public TextView descripcion;

        public ViewHolder(View itemView) {
            super(itemView);

            modelo = (ImageView) itemView.findViewById(R.id.ivImagenAccesorio);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreAccesorio);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcionAccesorio);


        }
    }


    public ListaAccesoriosAdapter(List<ItemAccesorio> accesoriosList) {
        this.accesoriosList = accesoriosList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accesorios, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accesorios, parent, false);
        ViewHolder pvh = new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemAccesorio item = accesoriosList.get(position);
        holder.modelo.setImageResource(item.getPhotoId());
        holder.nombre.setText(item.getNombre());
        holder.descripcion.setText(item.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return accesoriosList.size();
    }


}

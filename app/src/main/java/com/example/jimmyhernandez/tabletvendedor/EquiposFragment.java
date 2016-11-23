package com.example.jimmyhernandez.tabletvendedor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EquiposFragment extends Fragment {

    private List<ItemEquipos> equipoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListaEquiposAdapter mAdapter;

    public EquiposFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_equipos, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerEquipos);
        mAdapter = new ListaEquiposAdapter(equipoList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        //recyclerView.getContext(),1, GridLayoutManager.HORIZONTAL, false)
        recyclerView.setLayoutManager(mLayoutManager);

        initializeData();

        return v;
    }

    private void initializeData(){
        ItemEquipos item = new ItemEquipos(R.drawable.imgcuidarmegas, "Huawei P9", "Kirin");
        equipoList.add(item);

        item = new ItemEquipos(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        equipoList.add(item);

        item = new ItemEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        equipoList.add(item);

        item = new ItemEquipos(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        equipoList.add(item);

        item = new ItemEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        equipoList.add(item);

        item = new ItemEquipos(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        equipoList.add(item);

        item = new ItemEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        equipoList.add(item);

        item = new ItemEquipos(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        equipoList.add(item);

        item = new ItemEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        equipoList.add(item);



    }

}

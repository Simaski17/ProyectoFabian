package com.example.jimmyhernandez.tabletvendedor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class AccesoriosFragment extends Fragment {

    private List<ItemAccesorio> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListaAccesoriosAdapter mAdapter;

    public AccesoriosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_accesorios, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        mAdapter = new ListaAccesoriosAdapter(movieList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);

        initializeData();


        return v;
    }

    private void initializeData(){
        ItemAccesorio item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Huawei P9", "Kirin");
        movieList.add(item);

        item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        movieList.add(item);

        item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        movieList.add(item);

        item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        movieList.add(item);

        item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        movieList.add(item);

        item = new ItemAccesorio(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);



    }

}

package com.example.jimmyhernandez.tabletvendedor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppEntelFragment extends Fragment {

    @BindView(R.id.ivCelularMano)
    ImageView ivCelularMano;


    public AppEntelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_entel, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    /*
    Evento click imagen Celular Mano
     */
    @OnClick(R.id.ivCelularMano)
    public void onClick() {
        Toast.makeText(getContext(), "Funciona App Entel", Toast.LENGTH_SHORT).show();
    }
}

package com.example.jimmyhernandez.tabletvendedor;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppEntelFragment extends Fragment {

    @BindView(R.id.ivCelularMano)
    ImageView ivCelularMano;
    @BindView(R.id.ivFondoApp)
    ImageView ivFondoApp;


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
    @OnClick({R.id.ivCelularMano, R.id.ivFondoApp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCelularMano:
                Toast.makeText(getContext(), "funciona", Toast.LENGTH_SHORT).show();
                ivFondoApp.setVisibility(view.VISIBLE);

                break;
            case R.id.ivFondoApp:
                Toast.makeText(getContext(), "imagen levantada", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}

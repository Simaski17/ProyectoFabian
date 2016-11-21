package com.example.jimmyhernandez.tabletvendedor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class HogarFragment extends Fragment {


    @BindView(R.id.rlTelefoniaFija)
    RelativeLayout rlTelefoniaFija;
    @BindView(R.id.rlTelevision)
    RelativeLayout rlTelevision;
    @BindView(R.id.rlInternet)
    RelativeLayout rlInternet;
    @BindView(R.id.rlDoblePack)
    RelativeLayout rlDoblePack;
    @BindView(R.id.rlTriplePack)
    RelativeLayout rlTriplePack;

    public HogarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hogar, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.rlTelefoniaFija, R.id.rlTelevision, R.id.rlInternet, R.id.rlDoblePack, R.id.rlTriplePack})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlTelefoniaFija:
                intenciones(TelefoniaFijaActivity.class);
                break;
            case R.id.rlTelevision:
                intenciones(TelevisionHdActivity.class);
                break;
            case R.id.rlInternet:
                intenciones(InternetActivity.class);
                break;
            case R.id.rlDoblePack:
                intenciones(HogarDoblePackActivity.class);
                break;
            case R.id.rlTriplePack:
                intenciones(HogarTriplePackActivity.class);
                break;
        }
    }

    public void intenciones(Class name){
        Intent intent = new Intent(getContext(),name);
        startActivity(intent);
    }

}

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
public class RecomendamosFragment extends Fragment {


    @BindView(R.id.icnSpotify)
    ImageView icnSpotify;
    @BindView(R.id.icnNetflix)
    ImageView icnNetflix;
    @BindView(R.id.icnApple)
    ImageView icnApple;
    @BindView(R.id.icnUber)
    ImageView icnUber;
    @BindView(R.id.icnSnapchat)
    ImageView icnSnapchat;
    @BindView(R.id.icnWaze)
    ImageView icnWaze;

    public RecomendamosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recomendamos, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.icnSpotify, R.id.icnNetflix, R.id.icnApple, R.id.icnUber, R.id.icnSnapchat, R.id.icnWaze})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icnSpotify:
                Toast.makeText(getContext(), "Spotify", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icnNetflix:
                Toast.makeText(getContext(), "Netflix", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icnApple:
                Toast.makeText(getContext(), "Apple", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icnUber:
                Toast.makeText(getContext(), "Uber", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icnSnapchat:
                Toast.makeText(getContext(), "Snapchat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icnWaze:
                Toast.makeText(getContext(), "Waze", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

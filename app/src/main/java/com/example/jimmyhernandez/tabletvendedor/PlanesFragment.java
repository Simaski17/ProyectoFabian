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
public class PlanesFragment extends Fragment {


    @BindView(R.id.rlPlanesSmart)
    RelativeLayout rlPlanesSmart;
    @BindView(R.id.rlPlanesMultimedia)
    RelativeLayout rlPlanesMultimedia;
    @BindView(R.id.rlPlanesVoz)
    RelativeLayout rlPlanesVoz;
    @BindView(R.id.rlPlanesPotabilidad)
    RelativeLayout rlPlanesPotabilidad;
    private String plan;

    public PlanesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_planes, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.rlPlanesSmart, R.id.rlPlanesMultimedia, R.id.rlPlanesVoz, R.id.rlPlanesPotabilidad})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlPlanesSmart:
                Intent intent = new Intent(getContext(),PlanSmartFunActivity.class);
                startActivity(intent);
                break;
            case R.id.rlPlanesMultimedia:
                Intent intentb = new Intent(getContext(),PlanMultimediaActivity.class);
                startActivity(intentb);
                break;
            case R.id.rlPlanesVoz:
                Intent intentc = new Intent(getContext(),PlanVozActivity.class);
                startActivity(intentc);
                break;
            case R.id.rlPlanesPotabilidad:
                Intent intentd = new Intent(getContext(),PlanPortabilidadActivity.class);
                startActivity(intentd);
                break;
        }
    }
}

package com.example.jimmyhernandez.tabletvendedor;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlanesFragment extends Fragment {


    @BindView(R.id.ivPlanesSmart)
    ImageView ivPlanesSmart;
    @BindView(R.id.ivPlanesMultimedia)
    ImageView ivPlanesMultimedia;
    @BindView(R.id.ivPlanesVoz)
    ImageView ivPlanesVoz;
    @BindView(R.id.ivPlanesPotabilidad)
    ImageView ivPlanesPotabilidad;
    private String plan;

    ImageView imv;
    private String mensaje;
    private String clase;
    private String idUsuario = "user";
    private String idGrupo = "group";
    private String idPantalla = "screen";
    private String server = "server";
    private int bandera = 0;


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

    @OnClick({R.id.ivPlanesSmart, R.id.ivPlanesMultimedia, R.id.ivPlanesVoz, R.id.ivPlanesPotabilidad})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivPlanesSmart:
                //mensaje = "planSmarFun";
                mensaje = "cuidarMegas";
                clase = "planes";
                imv = (ImageView) view;
                cast(ivPlanesSmart);
                EventBus.getDefault().postSticky(new MensajeClaseCast("planSmarFun"));
                break;
            case R.id.ivPlanesMultimedia:
                //mensaje = "planMultimedia";
                mensaje = "cuidarMegas";
                clase = "planes";
                imv = (ImageView) view;
                cast(ivPlanesMultimedia);
                EventBus.getDefault().postSticky(new MensajeClaseCast("planMultimedia"));
                break;
            case R.id.ivPlanesVoz:
                //mensaje = "planVoz";
                mensaje = "cuidarMegas";
                clase = "planes";
                imv = (ImageView) view;
                cast(ivPlanesVoz);
                EventBus.getDefault().postSticky(new MensajeClaseCast("planVoz"));
                break;
            case R.id.ivPlanesPotabilidad:
                //mensaje = "planPortabilidad";
                mensaje = "cuidarMegas";
                clase = "planes";
                imv = (ImageView) view;
                cast(ivPlanesPotabilidad);
                EventBus.getDefault().postSticky(new MensajeClaseCast("planPortabilidad"));
                break;
        }
    }

    public void cast(View view){
        ImageView imvf = (ImageView)  view;
        imvf.setDrawingCacheEnabled(true);
        Bitmap bitmap = imvf.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bitmapdata = stream.toByteArray();

        Intent intent = new Intent(getContext(), FondoCastActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), imv, "transitionname");
        intent.putExtra("img", bitmapdata);
        intent.putExtra("mensaje", mensaje);
        intent.putExtra("clase", clase);
        intent.putExtra("idGrupo", idGrupo);
        intent.putExtra("idPantalla", idPantalla);
        intent.putExtra("server", server);
        intent.putExtra("bandera", bandera);
        startActivity(intent, optionsCompat.toBundle());
    }


    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessage(Message event) {
        idGrupo = event.getIdGrupo();
        idPantalla = event.getIdPantalla();
        server = event.getServer();
        if(idGrupo != "group" ){
            bandera = 1;
        }else{
            bandera = 0;
        }
    }



}

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
public class HogarFragment extends Fragment {


    @BindView(R.id.ivTelefoniaFija)
    ImageView ivTelefoniaFija;
    @BindView(R.id.ivTelevision)
    ImageView ivTelevision;
    @BindView(R.id.ivInternet)
    ImageView ivInternet;
    @BindView(R.id.rlDoblePack)
    RelativeLayout rlDoblePack;
    @BindView(R.id.rlTriplePack)
    RelativeLayout rlTriplePack;

    ImageView imv;
    private String mensaje;
    private String clase;
    private String idUsuario = "user";
    private String idGrupo = "group";
    private String idPantalla = "screen";
    private String server = "server";
    private int bandera = 0;

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

    @OnClick({R.id.ivTelefoniaFija, R.id.ivTelevision, R.id.ivInternet, R.id.rlDoblePack, R.id.rlTriplePack})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivTelefoniaFija:
                //mensaje = "planTelefoniaFija";
                mensaje = "telefonia";
                clase = "planes";
                imv = (ImageView) view;
                cast(ivTelefoniaFija);
                EventBus.getDefault().postSticky(new MensajeClaseCast("planTelefoniaFija"));
                break;
            case R.id.ivTelevision:
                //mensaje = "planTelevisionHD";
                mensaje = "tvh";
                clase = "planes";
                imv = (ImageView) view;
                cast(ivTelevision);
                EventBus.getDefault().postSticky(new MensajeClaseCast("planTelevisionHD"));
                break;
            case R.id.ivInternet:
                //mensaje = "planInternet";
                mensaje = "internet";
                clase = "planes";
                imv = (ImageView) view;
                cast(ivInternet);
                EventBus.getDefault().postSticky(new MensajeClaseCast("planInternet"));
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

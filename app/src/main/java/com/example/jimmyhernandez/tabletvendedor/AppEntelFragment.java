package com.example.jimmyhernandez.tabletvendedor;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.ByteArrayOutputStream;

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
    //ImageView ivCelularMano;
    String TAG = "HOLA";

    private String idUsuario = "user";
    private String idGrupo = "group";
    private String idPantalla = "screen";
    private String server = "server";
    private int bandera = 0;

    MainActivity mainActivity;

    private  String mensaje;

    public AppEntelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_entel, container, false);
        ButterKnife.bind(this, view);
        //RelativeLayout rl = (RelativeLayout) getActivity().findViewById(R.id.linear_menucast);
        //rl.setVisibility(View.VISIBLE);
        mainActivity = new MainActivity();



        return view;
    }


    /*
    Evento click imagen Celular Mano
     */
    @OnClick(R.id.ivFondoApp)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFondoApp:
                mensaje = "appentel";
                ImageView imv = (ImageView) view;
                imv.setDrawingCacheEnabled(true);
                Bitmap bitmap = imv.getDrawingCache();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] bitmapdata = stream.toByteArray();

                Intent intent = new Intent(getContext(), FondoCastActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), imv, "transitionname");
                //EventBus.getDefault().postSticky(new FondoCastRecordar(id));
                intent.putExtra("img", bitmapdata);
                intent.putExtra("mensaje", mensaje);
                intent.putExtra("idGrupo", idGrupo);
                intent.putExtra("idPantalla", idPantalla);
                intent.putExtra("server", server);
                intent.putExtra("bandera", bandera);
                startActivity(intent, optionsCompat.toBundle());

                break;
        }
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

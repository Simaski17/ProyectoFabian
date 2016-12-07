package com.example.jimmyhernandez.tabletvendedor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HogarTriplePackActivity extends AppCompatActivity {

    @BindView(R.id.ivFlechaAtras)
    ImageView ivFlechaAtras;
    @BindView(R.id.ivTvTf)
    ImageView ivTvTf;

    ImageView imv;
    private String mensaje;
    private String clase;
    private String idUsuario = "user";
    private String idGrupo = "group";
    private String idPantalla = "screen";
    private String server = "server";
    private int bandera = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hogar_triple_pack);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ivFlechaAtras, R.id.ivTvTf})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFlechaAtras:
                finish();
                break;
            case R.id.ivTvTf:
                //intenciones(DoblePackUnoActivity.class);
                //mensaje = "planTelefoniaFija";
                mensaje = "cuidarMegas";
                clase = "planes";
                imv = (ImageView) view;
                cast(ivTvTf);
                EventBus.getDefault().postSticky(new MensajeClaseCast("planTelevision+TelefoniaFija+Internet"));
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

        Intent intent = new Intent(getApplicationContext(), FondoCastActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) view.getContext(), imv, "transitionname");
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

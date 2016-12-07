package com.example.jimmyhernandez.tabletvendedor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlanesCastActivity extends AppCompatActivity {


    @BindView(R.id.ivCerrarPlan)
    ImageView ivCerrarPlan;
    @BindView(R.id.ivPlanes)
    ImageView ivPlanes;

    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_cast);

        ButterKnife.bind(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMensajeClaseCast(MensajeClaseCast event) {
        mensaje = event.getMensaje();
        if (mensaje.equals("planSmarFun")) {
            //setContentView(R.layout.activity_plan_smartfun);
            ivPlanes.setImageResource(R.drawable.plansmarfun);
        } else if (mensaje.equals("planMultimedia")) {
            //setContentView(R.layout.activity_plan_multimedia);
            ivPlanes.setImageResource(R.drawable.plancontrolfun);
        } else if (mensaje.equals("planVoz")) {
            //setContentView(R.layout.activity_plan_voz);
            ivPlanes.setImageResource(R.drawable.planvoz);
        } else if (mensaje.equals("planPortabilidad")) {
            //setContentView(R.layout.activity_plan_portabilidad);
            ivPlanes.setImageResource(R.drawable.planportabilidad);
        }else if (mensaje.equals("planTelefoniaFija")) {
            //setContentView(R.layout.activity_plan_portabilidad);
            ivPlanes.setImageResource(R.drawable.plantelefoniafija);
        }else if (mensaje.equals("planTelevisionHD")) {
            //setContentView(R.layout.activity_plan_portabilidad);
            ivPlanes.setImageResource(R.drawable.plantvhd);
        }else if (mensaje.equals("planInternet")) {
            //setContentView(R.layout.activity_plan_portabilidad);
            ivPlanes.setImageResource(R.drawable.planinternet);
        }else if (mensaje.equals("planTelevision+TelefoniaFija")) {
            //setContentView(R.layout.activity_plan_portabilidad);
            ivPlanes.setImageResource(R.drawable.doblepackuno);
        }else if (mensaje.equals("planTelevision+Internet")) {
            //setContentView(R.layout.activity_plan_portabilidad);
            ivPlanes.setImageResource(R.drawable.doblepackdos);
        }else if (mensaje.equals("planInternet+TelefoniaFija")) {
            //setContentView(R.layout.activity_plan_portabilidad);
            ivPlanes.setImageResource(R.drawable.doblepacktres);
        }else if (mensaje.equals("planTelevision+TelefoniaFija+Internet")) {
            //setContentView(R.layout.activity_plan_portabilidad);
            ivPlanes.setImageResource(R.drawable.triplepackuno);
        }
    }


    @OnClick(R.id.ivCerrarPlan)
    public void onClick() {
        finish();
    }


    /*@OnClick({R.id.ivCerrarPlanSmart,R.id.ivCerrarPlanMultimedia, R.id.ivCerrarPlanVoz, R.id.ivCerrarPlanPortabilidad})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCerrarPlanSmart:
                finish();
                break;
            case R.id.ivCerrarPlanMultimedia:
                finish();
                break;
            case R.id.ivCerrarPlanVoz:
                finish();
                break;
            case R.id.ivCerrarPlanPortabilidad:
                finish();
                break;
        }
    }*/


}
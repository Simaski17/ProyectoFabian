package com.example.jimmyhernandez.tabletvendedor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlanesCastActivity extends AppCompatActivity {


    @BindView(R.id.ivCerrarPlan)
    ImageView ivCerrarPlan;

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
        } else if (mensaje.equals("planMultimedia")) {
            //setContentView(R.layout.activity_plan_multimedia);
        } else if (mensaje.equals("planVoz")) {
            //setContentView(R.layout.activity_plan_voz);
        } else if (mensaje.equals("planPortabilidad")) {
            //setContentView(R.layout.activity_plan_portabilidad);
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
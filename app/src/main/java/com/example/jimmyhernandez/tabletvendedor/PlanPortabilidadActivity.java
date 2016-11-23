package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by simaski on 21/11/16.
 */

public class PlanPortabilidadActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarPlanPortabilidad)
    ImageView ivCerrarPlanPortabilidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_portabilidad);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarPlanPortabilidad)
    public void onClick() {
        finish();
    }
}

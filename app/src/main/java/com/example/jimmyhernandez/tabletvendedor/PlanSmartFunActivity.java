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

public class PlanSmartFunActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarPlanSmart)
    ImageView ivCerrarPlanSmart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_smartfun);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarPlanSmart)
    public void onClick() {
        finish();
    }
}
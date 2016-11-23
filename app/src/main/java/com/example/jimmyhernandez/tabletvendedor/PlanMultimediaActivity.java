package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlanMultimediaActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarPlanMultimedia)
    ImageView ivCerrarPlanMultimedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_multimedia);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarPlanMultimedia)
    public void onClick() {
        finish();
    }
}

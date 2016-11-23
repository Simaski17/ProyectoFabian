package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InternetActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarPlanInternet)
    ImageView ivCerrarPlanInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarPlanInternet)
    public void onClick() {
        finish();
    }
}

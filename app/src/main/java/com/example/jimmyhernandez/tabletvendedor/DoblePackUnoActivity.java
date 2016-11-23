package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoblePackUnoActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarTvTlf)
    ImageView ivCerrarTvTlf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doble_pack_uno);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarTvTlf)
    public void onClick() {
        finish();
    }
}

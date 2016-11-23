package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TelefoniaFijaActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarTelefoniaFija)
    ImageView ivCerrarTelefoniaFija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefonia_fija);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarTelefoniaFija)
    public void onClick() {
        finish();
    }
}

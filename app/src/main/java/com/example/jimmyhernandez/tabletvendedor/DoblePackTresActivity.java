package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoblePackTresActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarTelfInter)
    ImageView ivCerrarTelfInter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doble_pack_tres);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarTelfInter)
    public void onClick() {
        finish();
    }
}

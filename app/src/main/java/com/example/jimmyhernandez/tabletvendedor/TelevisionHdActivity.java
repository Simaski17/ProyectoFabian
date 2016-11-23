package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TelevisionHdActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarTelefoniaHd)
    ImageView ivCerrarTelefoniaHd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_television_hd);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarTelefoniaHd)
    public void onClick() {
        finish();
    }
}

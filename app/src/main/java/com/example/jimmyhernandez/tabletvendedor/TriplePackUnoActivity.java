package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TriplePackUnoActivity extends AppCompatActivity {

    @BindView(R.id.ivCerrarTvTlfInter)
    ImageView ivCerrarTvTlfInter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triple_pack_uno);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivCerrarTvTlfInter)
    public void onClick() {
        Intent intent = new Intent(TriplePackUnoActivity.this, HogarTriplePackActivity.class);
        startActivity(intent);
        finish();
    }
}

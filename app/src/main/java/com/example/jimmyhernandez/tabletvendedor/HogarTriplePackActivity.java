package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HogarTriplePackActivity extends AppCompatActivity {

    @BindView(R.id.ivFlechaAtras)
    ImageView ivFlechaAtras;
    @BindView(R.id.rlTvTf)
    RelativeLayout rlTvTf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hogar_triple_pack);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ivFlechaAtras, R.id.rlTvTf})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFlechaAtras:
                finish();
                break;
            case R.id.rlTvTf:
                Intent intent1 = new Intent(HogarTriplePackActivity.this, TriplePackUnoActivity.class);
                startActivity(intent1);
                break;
        }
    }
}

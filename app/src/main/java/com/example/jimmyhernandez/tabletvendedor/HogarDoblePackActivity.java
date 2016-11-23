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

import static java.security.AccessController.getContext;

public class HogarDoblePackActivity extends AppCompatActivity {

    @BindView(R.id.ivFlechaAtras)
    ImageView ivFlechaAtras;
    @BindView(R.id.rlTvTf)
    RelativeLayout rlTvTf;
    @BindView(R.id.rlTvInt)
    RelativeLayout rlTvInt;
    @BindView(R.id.rlIntTf)
    RelativeLayout rlIntTf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hogar_doble_pack);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ivFlechaAtras, R.id.rlTvTf, R.id.rlTvInt, R.id.rlIntTf})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFlechaAtras:
                finish();
                break;
            case R.id.rlTvTf:
                intenciones(DoblePackUnoActivity.class);
                break;
            case R.id.rlTvInt:
                intenciones(DoblePackDosActivity.class);
                break;
            case R.id.rlIntTf:
                intenciones(DoblePackTresActivity.class);
                break;
        }
    }

    public void intenciones(Class name){
        Intent intent = new Intent(getApplication(),name);
        startActivity(intent);
    }


}

package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginIngresoVendedorActivity extends AppCompatActivity {


    @BindView(R.id.etNombreVendedor)
    EditText etNombreVendedor;
    @BindView(R.id.etRutVendedor)
    EditText etRutVendedor;
    @BindView(R.id.btEntrarVendedor)
    Button btEntrarVendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ingreso_vendedor);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btEntrarVendedor)
    public void onClick() {
        Intent miIntent = new Intent(LoginIngresoVendedorActivity.this,MainActivity.class);
        LoginIngresoVendedorActivity.this.startActivity(miIntent);
        LoginIngresoVendedorActivity.this.finish();
    }
}

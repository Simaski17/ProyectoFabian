package com.example.jimmyhernandez.tabletvendedor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginIngresoVendedorActivity extends AppCompatActivity {


    @BindView(R.id.etRutCliente)
    EditText etNombreVendedor;
    @BindView(R.id.etRutVendedor)
    EditText etRutVendedor;
    @BindView(R.id.btEntrarVendedor)
    Button btEntrarVendedor;
    @BindView(R.id.activity_login_ingreso_vendedor)
    LinearLayout activityLoginIngresoVendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ingreso_vendedor);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btEntrarVendedor, R.id.activity_login_ingreso_vendedor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btEntrarVendedor:
                Intent miIntent = new Intent(LoginIngresoVendedorActivity.this, IngresoVendedorClienteActivity.class);
                LoginIngresoVendedorActivity.this.startActivity(miIntent);
                LoginIngresoVendedorActivity.this.finish();
                break;
            case R.id.activity_login_ingreso_vendedor:
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(etNombreVendedor.getWindowToken(), 0);
                break;
        }
    }

}

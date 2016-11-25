package com.example.jimmyhernandez.tabletvendedor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class IngresoVendedorClienteActivity extends AppCompatActivity {

    @BindView(R.id.iconoClientes)
    ImageView iconoClientes;
    @BindView(R.id.civImagenVendedor)
    CircleImageView civImagenVendedor;
    @BindView(R.id.tvVerCatalogoLibre)
    TextView tvVerCatalogoLibre;
    @BindView(R.id.btCerrarSesion)
    Button btEntrarVendedor;
    @BindView(R.id.etRutCliente)
    EditText etRutCliente;
    @BindView(R.id.etEmailCliente)
    EditText etEmailCliente;
    @BindView(R.id.btIrCatalogo)
    Button btIrCatalogo;
    @BindView(R.id.ingreso_vendedor_cliente)
    RelativeLayout ingreso_vendedor_cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_vendedor_cliente);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iconoClientes, R.id.tvVerCatalogoLibre, R.id.btCerrarSesion, R.id.btIrCatalogo, R.id.ingreso_vendedor_cliente})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iconoClientes:
                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvVerCatalogoLibre:
                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btCerrarSesion:
                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btIrCatalogo:
                Intent miIntent = new Intent(IngresoVendedorClienteActivity.this, MainActivity.class);
                 IngresoVendedorClienteActivity.this.startActivity(miIntent);
                IngresoVendedorClienteActivity.this.finish();
                break;
            case R.id.ingreso_vendedor_cliente:
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(etRutCliente.getWindowToken(), 0);
                break;
        }
    }
}

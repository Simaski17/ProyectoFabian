package com.example.jimmyhernandez.tabletvendedor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jimmyhernandez.tabletvendedor.CLS.ClientSocket;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

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
    Vibrator v;

    private String server;
    private int port;
    private String mensajeRecibido;
    private String message;
    private String idGrupo;
    private String idPantalla;
    private String clase;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_vendedor_cliente);
        ButterKnife.bind(this);

        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        port = 9090;


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
                v.vibrate(50);

                message = "2" + "|" + "1" + "|" + "chao";
                server  = "172.17.163.187";

                EventBus.getDefault().postSticky(new DesesperadoUno("172.17.163.180", port,message));
                EventBus.getDefault().postSticky(new DesesperadoDos( "172.17.163.58", port,message));
                EventBus.getDefault().postSticky(new DesesperadoDos( "172.17.163.58", port,message));
                EventBus.getDefault().postSticky(new DesesperadoDos( "172.17.163.58", port,message));
                EventBus.getDefault().postSticky(new DesesperadoDos( "172.17.163.58", port,message));
                EventBus.getDefault().postSticky(new DesesperadoDos( "172.17.163.58", port,message));

                /*ArrayList<String> servidores = new ArrayList<String>();
                *//*servidores.add("172.17.163.59");
                servidores.add("172.17.163.56");*//*
                servidores.add("172.17.163.58");
                servidores.add("172.17.163.187");
                *//*servidores.add("172.17.163.180");
                servidores.add("172.17.163.52");*//*

                for (int i = 0; i < servidores.size(); i++) {
                    ClientSocket myClient = new ClientSocket(servidores.get(i), port, message);
                    myClient.execute();
                }*/


                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ClientSocket myClient = new ClientSocket("172.17.163.187", port, message);
                        myClient.execute();
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ClientSocket myClient = new ClientSocket("172.17.163.58", port, message);
                        myClient.execute();
                    }
                }).start();*/



                Intent intent = new Intent(IngresoVendedorClienteActivity.this, LoginIngresoVendedorActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btIrCatalogo:
                v.vibrate(50);
                attemptLogin();
               /* Intent miIntent = new Intent(IngresoVendedorClienteActivity.this, MainActivity.class);
                IngresoVendedorClienteActivity.this.startActivity(miIntent);*/
                //IngresoVendedorClienteActivity.this.finish();
                break;
            case R.id.ingreso_vendedor_cliente:
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(etRutCliente.getWindowToken(), 0);
                break;
        }
    }

    private void attemptLogin() {

        // Reset errors.
        etRutCliente.setError(null);
        etEmailCliente.setError(null);

        // Store values at the time of the login attempt.
        String usuario = etRutCliente.getText().toString();
        String password = etEmailCliente.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(usuario)) {
            etRutCliente.setError(getString(R.string.error_campo_requirido));
            focusView = etRutCliente;
            cancel = true;
        }/* else if (!isUsuarioValido(usuario)) {
            etRutCliente.setError(getString(R.string.error_longitud_requerida));
            focusView = etRutCliente;
            cancel = true;
        }*/ else if (TextUtils.isEmpty(password)) {
            etEmailCliente.setError(getString(R.string.error_campo_requirido));
            focusView = etEmailCliente;
            cancel = true;
        } /*else if (!isPasswordValido(password)) {
            etEmailCliente.setError(getString(R.string.error_longitud_requerida));
            focusView = etEmailCliente;
            cancel = true;
        } else if (isUsuarioValido(usuario) && isPasswordValido(password)) {
            String[] pieces = {"admin1234", "admin5678"};
            String mUsuario = etRutCliente.getText().toString();
            String mPassword = etEmailCliente.getText().toString();
            if (!pieces[0].equals(mUsuario)) {
                etRutCliente.setError(getString(R.string.error_incorrect_usuario));
                focusView = etRutCliente;
                cancel = true;
            } else if (!pieces[1].equals(mPassword)) {
                etEmailCliente.setError(getString(R.string.error_incorrect_password));
                focusView = etEmailCliente;
                cancel = true;
            } */else {
            email = etEmailCliente.getText().toString();
            etRutCliente.setText("");
            etEmailCliente.setText("");
            Intent miIntent = new Intent(IngresoVendedorClienteActivity.this, MainActivity.class);
            miIntent.putExtra("email", email);
            IngresoVendedorClienteActivity.this.startActivity(miIntent);

                /*new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent miIntent = new Intent(LoginIngresoVendedorActivity.this, IngresoVendedorClienteActivity.class);
                        LoginIngresoVendedorActivity.this.startActivity(miIntent);
                        LoginIngresoVendedorActivity.this.finish();
                    }
                }, 3000);*/
            //}

        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
    }

    private boolean isUsuarioValido(String usuario) {
        //TODO: Replace this with your own logic
        return usuario.length() > 7;
    }

    private boolean isPasswordValido(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 7;
    }

}

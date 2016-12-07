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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
    @BindView(R.id.activity_login_ingreso_vendedor)
    LinearLayout activityLoginIngresoVendedor;
    Vibrator v;
    @BindView(R.id.rlProgress)
    RelativeLayout rlProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ingreso_vendedor);
        ButterKnife.bind(this);

        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);

    }

    @OnClick({R.id.btEntrarVendedor, R.id.activity_login_ingreso_vendedor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btEntrarVendedor:
                v.vibrate(50);
                attemptLogin();
                /*Intent miIntent = new Intent(LoginIngresoVendedorActivity.this, IngresoVendedorClienteActivity.class);
                LoginIngresoVendedorActivity.this.startActivity(miIntent);
                LoginIngresoVendedorActivity.this.finish();*/
                break;
            case R.id.activity_login_ingreso_vendedor:
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(etNombreVendedor.getWindowToken(), 0);
                break;
        }
    }

    private void attemptLogin() {

        // Reset errors.
        etNombreVendedor.setError(null);
        etRutVendedor.setError(null);

        // Store values at the time of the login attempt.
        String usuario = etNombreVendedor.getText().toString();
        String password = etRutVendedor.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(usuario)) {
            etNombreVendedor.setError(getString(R.string.error_campo_requirido));
            focusView = etNombreVendedor;
            cancel = true;
        } else if (!isUsuarioValido(usuario)) {
            etNombreVendedor.setError(getString(R.string.error_longitud_requerida));
            focusView = etNombreVendedor;
            cancel = true;
        } else if (TextUtils.isEmpty(password)) {
            etRutVendedor.setError(getString(R.string.error_campo_requirido));
            focusView = etRutVendedor;
            cancel = true;
        } else if (!isPasswordValido(password)) {
            etRutVendedor.setError(getString(R.string.error_longitud_requerida));
            focusView = etRutVendedor;
            cancel = true;
        } else if (isUsuarioValido(usuario) && isPasswordValido(password)) {
            String[] pieces = {"rinno1234", "rinno1234"};
            String mUsuario = etNombreVendedor.getText().toString();
            String mPassword = etRutVendedor.getText().toString();
            if (!pieces[0].equals(mUsuario)) {
                etNombreVendedor.setError(getString(R.string.error_incorrect_usuario));
                focusView = etNombreVendedor;
                cancel = true;
            } else if (!pieces[1].equals(mPassword)) {
                etRutVendedor.setError(getString(R.string.error_incorrect_password));
                focusView = etRutVendedor;
                cancel = true;
            } else {
                etNombreVendedor.setText("");
                etRutVendedor.setText("");
                rlProgress.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent miIntent = new Intent(LoginIngresoVendedorActivity.this, IngresoVendedorClienteActivity.class);
                        LoginIngresoVendedorActivity.this.startActivity(miIntent);
                        LoginIngresoVendedorActivity.this.finish();
                    }
                }, 3000);
            }

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

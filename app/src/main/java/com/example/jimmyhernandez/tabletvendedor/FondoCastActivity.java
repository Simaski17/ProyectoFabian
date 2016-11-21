package com.example.jimmyhernandez.tabletvendedor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FondoCastActivity extends AppCompatActivity {

    //ImageView imv;
    @BindView(R.id.ivCerrarFondoCast)
    ImageView ivCerrarFondoCast;
    @BindView(R.id.rlErrorCast)
    RelativeLayout rlErrorCast;
    @BindView(R.id.ivFlechaCast)
    ImageView ivFlechaCast;
    @BindView(R.id.tvTextoCast)
    TextView tvTextoCast;
    @BindView(R.id.ivIconCastFc)
    ImageView ivIconCastFc;
//    @BindView(R.id.prueba)
     ImageView prueba;
    @BindView(R.id.ivGrupoVideoWallInactivo)
    ImageView ivGrupoVideoWallInactivo;
    @BindView(R.id.ivGrupoVideoWallActivo)
    ImageView ivGrupoVideoWallActivo;
    @BindView(R.id.ivGrupoPilarInactivo)
    ImageView ivGrupoPilarInactivo;
    @BindView(R.id.ivGrupoPilarActivo)
    ImageView ivGrupoPilarActivo;
    @BindView(R.id.linear_menucast)
    LinearLayout linearMenucast;
    @BindView(R.id.ivPantallaUnoInactiva)
    ImageView ivPantallaUnoInactiva;
    @BindView(R.id.ivPantallaUnoactiva)
    ImageView ivPantallaUnoactiva;
    @BindView(R.id.ivPantallaDosInactiva)
    ImageView ivPantallaDosInactiva;
    @BindView(R.id.ivPantallaDosactiva)
    ImageView ivPantallaDosactiva;
    @BindView(R.id.ivPantallaTresInactiva)
    ImageView ivPantallaTresInactiva;
    @BindView(R.id.ivPantallaTresactiva)
    ImageView ivPantallaTresactiva;
    @BindView(R.id.ivPantallaCuatroInactiva)
    ImageView ivPantallaCuatroInactiva;
    @BindView(R.id.ivPantallaCuatroactiva)
    ImageView ivPantallaCuatroactiva;
    @BindView(R.id.linearSeleccionPantallasPilar)
    LinearLayout linearSeleccionPantallasPilar;
    @BindView(R.id.ivPantallaUnoVwInactiva)
    ImageView ivPantallaUnoVwInactiva;
    @BindView(R.id.ivPantallaUnoVwactiva)
    ImageView ivPantallaUnoVwactiva;
    @BindView(R.id.ivPantallaDosVwInactiva)
    ImageView ivPantallaDosVwInactiva;
    @BindView(R.id.ivPantallaDosVwactiva)
    ImageView ivPantallaDosVwactiva;
    @BindView(R.id.ivPantallaTresVwInactiva)
    ImageView ivPantallaTresVwInactiva;
    @BindView(R.id.ivPantallaTresVwactiva)
    ImageView ivPantallaTresVwactiva;
    @BindView(R.id.ivPantallaCuatroVwInactiva)
    ImageView ivPantallaCuatroVwInactiva;
    @BindView(R.id.ivPantallaCuatroVwactiva)
    ImageView ivPantallaCuatroVwactiva;
    @BindView(R.id.linearSeleccionPantallasVideoWall)
    LinearLayout linearSeleccionPantallasVideoWall;
    @BindView(R.id.activity_main)
    RelativeLayout  activity_main;

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    GestureDetector gdt;

    String TAG = "HOLA";
    Animation derecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fondo_cast);
        ButterKnife.bind(this);

        derecha = AnimationUtils.loadAnimation(this,R.anim.delizar_derecha);

        gdt = new GestureDetector(new GestureListener());
        prueba = (ImageView) findViewById(R.id.prueba);
        prueba.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                gdt.onTouchEvent(event);
                rlErrorCast.setVisibility(View.VISIBLE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                prueba.setAnimation(derecha);
                return true;
            }
        });

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("img");
        prueba.setImageBitmap(ByteArraytoDrawable(byteArray));

    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                Log.d(TAG, "onFling: aqui9877987987" + e1.toString()+e2.toString());
                return true; // Bottom to top
            }
            return true;
        }
    }

    public Bitmap ByteArraytoDrawable(byte[] byteArray) {
        Bitmap bmp;
        return bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    @OnClick({R.id.ivCerrarFondoCast, R.id.ivGrupoVideoWallInactivo, R.id.ivGrupoVideoWallActivo, R.id.ivGrupoPilarInactivo, R.id.ivGrupoPilarActivo, R.id.ivPantallaUnoInactiva, R.id.ivPantallaUnoactiva, R.id.ivPantallaDosInactiva, R.id.ivPantallaDosactiva, R.id.ivPantallaTresInactiva, R.id.ivPantallaTresactiva, R.id.ivPantallaCuatroInactiva, R.id.ivPantallaCuatroactiva, R.id.ivPantallaUnoVwInactiva, R.id.ivPantallaUnoVwactiva, R.id.ivPantallaDosVwInactiva, R.id.ivPantallaDosVwactiva, R.id.ivPantallaTresVwInactiva, R.id.ivPantallaTresVwactiva, R.id.ivPantallaCuatroVwInactiva, R.id.ivPantallaCuatroVwactiva, R.id.activity_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCerrarFondoCast:
                finish();
                break;
            case R.id.ivGrupoVideoWallInactivo:
                ivGrupoVideoWallInactivo.setVisibility(View.GONE);
                ivGrupoVideoWallActivo.setVisibility(View.VISIBLE);
                linearMenucast.setVisibility(View.GONE);
                linearSeleccionPantallasVideoWall.setVisibility(View.VISIBLE);
                break;
            case R.id.ivGrupoVideoWallActivo:
                break;
            case R.id.ivGrupoPilarInactivo:
                ivGrupoPilarInactivo.setVisibility(View.GONE);
                ivGrupoPilarActivo.setVisibility(View.VISIBLE);
                linearMenucast.setVisibility(View.GONE);
                linearSeleccionPantallasPilar.setVisibility(View.VISIBLE);
                break;
            case R.id.ivGrupoPilarActivo:
                break;
            case R.id.ivPantallaUnoInactiva:
                ivPantallaUnoInactiva.setVisibility(View.GONE);
                ivPantallaUnoactiva.setVisibility(View.VISIBLE);
                break;
            case R.id.ivPantallaUnoactiva:
                break;
            case R.id.ivPantallaDosInactiva:
                ivPantallaDosInactiva.setVisibility(View.GONE);
                ivPantallaDosactiva.setVisibility(View.VISIBLE);
                break;
            case R.id.ivPantallaDosactiva:
                break;
            case R.id.ivPantallaTresInactiva:
                ivPantallaTresInactiva.setVisibility(View.GONE);
                ivPantallaTresactiva.setVisibility(View.VISIBLE);
                break;
            case R.id.ivPantallaTresactiva:
                break;
            case R.id.ivPantallaCuatroInactiva:
                ivPantallaCuatroInactiva.setVisibility(View.GONE);
                ivPantallaCuatroactiva.setVisibility(View.VISIBLE);
                break;
            case R.id.ivPantallaCuatroactiva:
                break;
            case R.id.ivPantallaUnoVwInactiva:
                ivPantallaUnoVwInactiva.setVisibility(View.GONE);
                ivPantallaUnoVwactiva.setVisibility(View.VISIBLE);
                break;
            case R.id.ivPantallaUnoVwactiva:
                break;
            case R.id.ivPantallaDosVwInactiva:
                ivPantallaDosVwInactiva.setVisibility(View.GONE);
                ivPantallaDosVwactiva.setVisibility(View.VISIBLE);
                break;
            case R.id.ivPantallaDosVwactiva:
                break;
            case R.id.ivPantallaTresVwInactiva:
                ivPantallaTresVwInactiva.setVisibility(View.GONE);
                ivPantallaTresVwactiva.setVisibility(View.VISIBLE);
                break;
            case R.id.ivPantallaTresVwactiva:
                break;
            case R.id.ivPantallaCuatroVwInactiva:
                ivPantallaCuatroVwInactiva.setVisibility(View.GONE);
                ivPantallaCuatroVwactiva.setVisibility(View.VISIBLE);
                break;
            case R.id.ivPantallaCuatroVwactiva:
                break;
            case R.id.activity_main:
                finish();
                break;
        }
    }

}

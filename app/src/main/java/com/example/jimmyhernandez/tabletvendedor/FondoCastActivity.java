package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import android.widget.Toast;

import com.example.jimmyhernandez.tabletvendedor.CLS.ClientSocket;

import java.util.Timer;
import java.util.TimerTask;

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

    private static final int SWIPE_MIN_DISTANCE = 80;
    private static final int SWIPE_THRESHOLD_VELOCITY = 100;

    private int bandera = 0;

    private String server;
    private int port;
    private String mensajeRecibido;
    private String message;
    private String idGrupo;
    private String idPantalla;

    View v = null;
    GestureDetector detector;

    PackageManager pm;

    String TAG = "HOLA";
    Animation derecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fondo_cast);
        ButterKnife.bind(this);

        /* pm = getApplication().getPackageManager();
        try
        {
            // Raise exception if whatsapp doesn't exist
            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            //waIntent.setType("text/plain");
            waIntent.setPackage("com.spotify.mobile.android.ui");
            startActivity(waIntent);
        }
        catch (PackageManager.NameNotFoundException e)
        {
            Toast.makeText(getApplication(), "Please install whatsapp app", Toast.LENGTH_SHORT)
                    .show();
        }*/




        detector = new GestureDetector(new GestureListener());

        server = "192.168.0.111";
        port = 8080;


        prueba = (ImageView) findViewById(R.id.prueba);
        prueba.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent motionEvent) {

                detector.onTouchEvent(motionEvent);
                v = prueba;

                return true;
            }
        });

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("img");
        prueba.setImageBitmap(ByteArraytoDrawable(byteArray));
        mensajeRecibido = extras.getString("mensaje");

    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){

            if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY && bandera == 0){

                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.VISIBLE);
            }else  if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY){
                message = idGrupo+"|"+idPantalla+"|"+mensajeRecibido;


                Log.d(TAG, "onFling: aqui9877987987" + message);
                ClientSocket myClient = new ClientSocket(server, port, message);
                myClient.execute();

                if(mensajeRecibido.equals("spotify")){
                    Intent launchIntent = getApplication().getPackageManager().getLaunchIntentForPackage("com.spotify.music");
                        if(launchIntent != null) {
                            startActivity(launchIntent);
                        }
                }else  if(mensajeRecibido.equals("netflix")){
                    Intent launchIntent = getApplication().getPackageManager().getLaunchIntentForPackage("com.netflix.mediaclient");
                    if(launchIntent != null) {
                        startActivity(launchIntent);
                    }
                }else  if(mensajeRecibido.equals("uber")){
                    Intent launchIntent = getApplication().getPackageManager().getLaunchIntentForPackage("com.ubercab");
                    if(launchIntent != null) {
                        startActivity(launchIntent);
                    }
                }else  if(mensajeRecibido.equals("snapchat")){
                    Intent launchIntent = getApplication().getPackageManager().getLaunchIntentForPackage("com.snapchat.android");
                    if(launchIntent != null) {
                        startActivity(launchIntent);
                    }
                }else  if(mensajeRecibido.equals("waze")){
                    Intent launchIntent = getApplication().getPackageManager().getLaunchIntentForPackage("com.waze");
                    if(launchIntent != null) {
                        startActivity(launchIntent);
                    }
                }


                final float d = v.getY();
                v.animate().translationY(-activity_main.getHeight()).alpha(1.0f);
                TimerTask ts = new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                //volverEstadoNomral();
                                v.setY(d);
                            }
                        });

                    }
                };


                Timer timer = new Timer();
                timer.schedule(ts, 400);
                return false; // Bottom to top
            }


            return false;
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
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);
                linearMenucast.setVisibility(View.GONE);
                ivGrupoVideoWallActivo.setVisibility(View.VISIBLE);
                linearSeleccionPantallasVideoWall.setVisibility(View.VISIBLE);
                idGrupo = "1";
                break;
            case R.id.ivGrupoVideoWallActivo:
                break;
            case R.id.ivGrupoPilarInactivo:
                ivGrupoPilarInactivo.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);
                linearMenucast.setVisibility(View.GONE);
                ivGrupoPilarActivo.setVisibility(View.VISIBLE);
                linearSeleccionPantallasPilar.setVisibility(View.VISIBLE);
                idGrupo = "2";
                break;
            case R.id.ivGrupoPilarActivo:
                break;
            case R.id.ivPantallaUnoInactiva:
                ivPantallaUnoInactiva.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);
                ivPantallaDosactiva.setVisibility(View.GONE);
                ivPantallaTresactiva.setVisibility(View.GONE);
                ivPantallaCuatroactiva.setVisibility(View.GONE);
                ivPantallaDosInactiva.setVisibility(View.VISIBLE);
                ivPantallaTresInactiva.setVisibility(View.VISIBLE);
                ivPantallaCuatroInactiva.setVisibility(View.VISIBLE);
                ivPantallaUnoactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                idPantalla = "1";
                break;
            case R.id.ivPantallaUnoactiva:
                break;
            case R.id.ivPantallaDosInactiva:
                ivPantallaDosInactiva.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);

                ivPantallaUnoactiva.setVisibility(View.GONE);
                ivPantallaTresactiva.setVisibility(View.GONE);
                ivPantallaCuatroactiva.setVisibility(View.GONE);
                ivPantallaUnoInactiva.setVisibility(View.VISIBLE);
                ivPantallaTresInactiva.setVisibility(View.VISIBLE);
                ivPantallaCuatroInactiva.setVisibility(View.VISIBLE);

                ivPantallaDosactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                break;
            case R.id.ivPantallaDosactiva:
                break;
            case R.id.ivPantallaTresInactiva:
                ivPantallaTresInactiva.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);

                ivPantallaDosactiva.setVisibility(View.GONE);
                ivPantallaUnoactiva.setVisibility(View.GONE);
                ivPantallaCuatroactiva.setVisibility(View.GONE);
                ivPantallaDosInactiva.setVisibility(View.VISIBLE);
                ivPantallaUnoInactiva.setVisibility(View.VISIBLE);
                ivPantallaCuatroInactiva.setVisibility(View.VISIBLE);

                ivPantallaTresactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                break;
            case R.id.ivPantallaTresactiva:
                break;
            case R.id.ivPantallaCuatroInactiva:
                ivPantallaCuatroInactiva.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);

                ivPantallaDosactiva.setVisibility(View.GONE);
                ivPantallaTresactiva.setVisibility(View.GONE);
                ivPantallaUnoactiva.setVisibility(View.GONE);
                ivPantallaDosInactiva.setVisibility(View.VISIBLE);
                ivPantallaTresInactiva.setVisibility(View.VISIBLE);
                ivPantallaUnoInactiva.setVisibility(View.VISIBLE);

                ivPantallaCuatroactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                break;
            case R.id.ivPantallaCuatroactiva:
                break;
            case R.id.ivPantallaUnoVwInactiva:
                ivPantallaUnoVwInactiva.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);

                ivPantallaDosVwactiva.setVisibility(View.GONE);
                ivPantallaTresVwactiva.setVisibility(View.GONE);
                ivPantallaCuatroVwactiva.setVisibility(View.GONE);
                ivPantallaDosVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaTresVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaCuatroVwInactiva.setVisibility(View.VISIBLE);

                ivPantallaUnoVwactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                idPantalla = "1";
                break;
            case R.id.ivPantallaUnoVwactiva:
                break;
            case R.id.ivPantallaDosVwInactiva:
                ivPantallaDosVwInactiva.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);

                ivPantallaUnoVwactiva.setVisibility(View.GONE);
                ivPantallaTresVwactiva.setVisibility(View.GONE);
                ivPantallaCuatroVwactiva.setVisibility(View.GONE);
                ivPantallaUnoVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaTresVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaCuatroVwInactiva.setVisibility(View.VISIBLE);

                ivPantallaDosVwactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                idPantalla = "2";
                break;
            case R.id.ivPantallaDosVwactiva:
                break;
            case R.id.ivPantallaTresVwInactiva:
                ivPantallaTresVwInactiva.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);

                ivPantallaDosVwactiva.setVisibility(View.GONE);
                ivPantallaUnoVwactiva.setVisibility(View.GONE);
                ivPantallaCuatroVwactiva.setVisibility(View.GONE);
                ivPantallaDosVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaUnoVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaCuatroVwInactiva.setVisibility(View.VISIBLE);

                ivPantallaTresVwactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                break;
            case R.id.ivPantallaTresVwactiva:
                break;
            case R.id.ivPantallaCuatroVwInactiva:
                ivPantallaCuatroVwInactiva.setVisibility(View.GONE);
                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.GONE);

                ivPantallaDosVwactiva.setVisibility(View.GONE);
                ivPantallaTresVwactiva.setVisibility(View.GONE);
                ivPantallaUnoVwactiva.setVisibility(View.GONE);
                ivPantallaDosVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaTresVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaUnoVwInactiva.setVisibility(View.VISIBLE);

                ivPantallaCuatroVwactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                break;
            case R.id.ivPantallaCuatroVwactiva:
                break;
            case R.id.activity_main:
                finish();
                break;
        }
    }

}

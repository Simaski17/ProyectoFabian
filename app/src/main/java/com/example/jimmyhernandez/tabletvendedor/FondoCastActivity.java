package com.example.jimmyhernandez.tabletvendedor;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jimmyhernandez.tabletvendedor.CLS.ClientSocket;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FondoCastActivity extends AppCompatActivity {

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
    RelativeLayout activity_main;
    @BindView(R.id.ivBotonSi)
    ImageView ivBotonSi;
    @BindView(R.id.ivBotonNo)
    ImageView ivBotonNo;
    @BindView(R.id.rlPreguntaApp)
    RelativeLayout rlPreguntaApp;
    @BindView(R.id.rlCerrarCast)
    RelativeLayout rlCerrarCast;

    private static final int SWIPE_MIN_DISTANCE = 1;
    private static final int SWIPE_THRESHOLD_VELOCITY = 10;
    @BindView(R.id.ivFlechaAtrasPilar)
    ImageView ivFlechaAtrasPilar;
    @BindView(R.id.ivFlechaAtrasVideoWall)
    ImageView ivFlechaAtrasVideoWall;


    private int bandera = 0;

    private String server;
    private int port;
    private String mensajeRecibido;
    private String message;
    private String idGrupo;
    private String idPantalla;
    private String clase;

    View v = null;
    GestureDetector detector;

    PackageManager pm;

    String TAG = "HOLA";

    Class cls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fondo_cast);
        ButterKnife.bind(this);

        detector = new GestureDetector(new GestureListener());
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
        clase = extras.getString("clase");
        idGrupo = extras.getString("idGrupo");
        idPantalla = extras.getString("idPantalla");
        server = extras.getString("server");
        bandera = extras.getInt("bandera");

        try {
            cls = Class.forName(clase);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (idGrupo.equals("group") || idGrupo.equals("cerrar")) {
            linearMenucast.setVisibility(View.VISIBLE);
            bandera = 0;

        }


    }


    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY && bandera == 0) {

                ivFlechaCast.setVisibility(View.GONE);
                tvTextoCast.setVisibility(View.GONE);
                ivIconCastFc.setVisibility(View.GONE);
                rlErrorCast.setVisibility(View.VISIBLE);
            } else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY && idGrupo != "group") {

                message = idGrupo + "|" + idPantalla + "|" + mensajeRecibido;
                ClientSocket myClient = new ClientSocket(server, port, message);
                myClient.execute();
                final float d = v.getY();
                v.animate().translationY(-activity_main.getHeight()).alpha(1.0f);
                TimerTask ts = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                v.setY(d);
                                if (mensajeRecibido.equals("spotify")) {
                                    pregunta("com.spotify.music");
                                } else if (mensajeRecibido.equals("apple")) {
                                    pregunta("com.apple.android.music");
                                } else if (mensajeRecibido.equals("netflix")) {
                                    pregunta("com.netflix.mediaclient");
                                } else if (mensajeRecibido.equals("uber")) {
                                    pregunta("com.ubercab");
                                } else if (mensajeRecibido.equals("snapchat")) {
                                    pregunta("com.snapchat.android");
                                } else if (mensajeRecibido.equals("waze")) {
                                    pregunta("com.waze");
                                } else{
                                    mensajesCast(mensajeRecibido);
                                } /*if (mensajeRecibido.equals("appentel")) {
                                    EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
                                    EventBus.getDefault().postSticky(new Recordar(idGrupo));
                                    prueba.setVisibility(View.GONE);
                                    finish();
                                } else if (mensajeRecibido.equals("transferirInfo")) {
                                    EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
                                    EventBus.getDefault().postSticky(new Recordar(idGrupo));
                                    prueba.setVisibility(View.GONE);
                                    finish();
                                } else if (mensajeRecibido.equals("cuidarMegas")) {
                                    EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
                                    EventBus.getDefault().postSticky(new Recordar(idGrupo));
                                    prueba.setVisibility(View.GONE);
                                    finish();
                                }else if (mensajeRecibido.equals("cuidarMegas")) {
                                    EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
                                    EventBus.getDefault().postSticky(new Recordar(idGrupo));
                                    prueba.setVisibility(View.GONE);
                                    finish();
                                }*/
                            }
                        });

                    }
                };

                Timer timer = new Timer();
                timer.schedule(ts, 400);

                return false; // Bottom to top

            } else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                message = idGrupo + "|" + idPantalla + "|" + mensajeRecibido;
                Log.d(TAG, "FONDOACTIVITY MENSAJE " + mensajeRecibido);

                ClientSocket myClient = new ClientSocket(server, port, message);
                myClient.execute();
                final float d = v.getY();
                v.animate().translationY(-activity_main.getHeight()).alpha(1.0f);
                TimerTask ts = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                v.setY(d);
                                if (mensajeRecibido.equals("spotify")) {
                                    pregunta("com.spotify.music");
                                } else if (mensajeRecibido.equals("apple")) {
                                    pregunta("com.apple.android.music");
                                } else if (mensajeRecibido.equals("netflix")) {
                                    pregunta("com.netflix.mediaclient");
                                } else if (mensajeRecibido.equals("uber")) {
                                    pregunta("com.ubercab");
                                } else if (mensajeRecibido.equals("snapchat")) {
                                    pregunta("com.snapchat.android");
                                } else if (mensajeRecibido.equals("waze")) {
                                    pregunta("com.waze");
                                } else if (mensajeRecibido.equals("appentel")) {
                                    EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
                                    EventBus.getDefault().postSticky(new Recordar(idGrupo));
                                    prueba.setVisibility(View.GONE);
                                    finish();
                                }else{
                                    mensajesCast(mensajeRecibido);
                                } /*if (mensajeRecibido.equals("transferirInfo")) {
                                    EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
                                    EventBus.getDefault().postSticky(new Recordar(idGrupo));
                                    prueba.setVisibility(View.GONE);
                                    finish();
                                } else if (mensajeRecibido.equals("cuidarMegas")) {
                                    EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
                                    EventBus.getDefault().postSticky(new Recordar(idGrupo));
                                    prueba.setVisibility(View.GONE);
                                    finish();
                                }*/
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

    private void mensajesCast(String mensajeRecibido) {
        if(clase != "clase"){
            //mensajeRecibido = "spotify";
            Log.e(TAG, "MENSAJE: "+mensajeRecibido);
            Log.e(TAG, "MENSAJE: "+clase);
            EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
            EventBus.getDefault().postSticky(new Recordar(idGrupo));
            prueba.setVisibility(View.GONE);
            finish();
            Intent intent = new Intent(getApplicationContext(), PlanesCastActivity.class );
            startActivity(intent);

        }else {

            EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
            EventBus.getDefault().postSticky(new Recordar(idGrupo));
            prueba.setVisibility(View.GONE);
            finish();
        }
    }


    public Bitmap ByteArraytoDrawable(byte[] byteArray) {
        Bitmap bmp;
        return bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    @OnClick({R.id.ivCerrarFondoCast, R.id.ivGrupoVideoWallInactivo, R.id.ivGrupoVideoWallActivo, R.id.ivGrupoPilarInactivo, R.id.ivGrupoPilarActivo, R.id.ivPantallaUnoInactiva, R.id.ivPantallaUnoactiva, R.id.ivPantallaDosInactiva, R.id.ivPantallaDosactiva, R.id.ivPantallaTresInactiva, R.id.ivPantallaTresactiva, R.id.ivPantallaCuatroInactiva, R.id.ivPantallaCuatroactiva, R.id.ivPantallaUnoVwInactiva, R.id.ivPantallaUnoVwactiva, R.id.ivPantallaDosVwInactiva, R.id.ivPantallaDosVwactiva, R.id.ivPantallaTresVwInactiva, R.id.ivPantallaTresVwactiva, R.id.ivPantallaCuatroVwInactiva, R.id.ivPantallaCuatroVwactiva, R.id.rlCerrarCast, R.id.ivFlechaAtrasPilar, R.id.ivFlechaAtrasVideoWall})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCerrarFondoCast:
                finish();
                break;
            case R.id.ivGrupoVideoWallInactivo:
                //ivGrupoVideoWallInactivo.setVisibility(View.GONE);
                varComunes();
                linearMenucast.setVisibility(View.GONE);
                //ivGrupoVideoWallActivo.setVisibility(View.VISIBLE);
                linearSeleccionPantallasVideoWall.setVisibility(View.VISIBLE);
                idGrupo = "1";
                break;
            case R.id.ivGrupoVideoWallActivo:
                break;
            case R.id.ivGrupoPilarInactivo:
                //ivGrupoPilarInactivo.setVisibility(View.GONE);
                varComunes();
                linearMenucast.setVisibility(View.GONE);
                //ivGrupoPilarActivo.setVisibility(View.VISIBLE);
                linearSeleccionPantallasPilar.setVisibility(View.VISIBLE);
                idGrupo = "2";
                server = "192.168.0.101";
                break;
            case R.id.ivGrupoPilarActivo:
                break;
            case R.id.ivPantallaUnoInactiva:
                ivPantallaUnoInactiva.setVisibility(View.GONE);
                varComunes();
                ivPantallaDosactiva.setVisibility(View.GONE);
                ivPantallaTresactiva.setVisibility(View.GONE);
                ivPantallaCuatroactiva.setVisibility(View.GONE);
                ivPantallaUnoactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                idPantalla = "1";
                break;
            case R.id.ivPantallaUnoactiva:
                break;
            case R.id.ivPantallaDosInactiva:
                ivPantallaDosInactiva.setVisibility(View.GONE);
                varComunes();
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
                varComunes();
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
                varComunes();
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
                varComunes();
                ivPantallaDosVwactiva.setVisibility(View.GONE);
                ivPantallaTresVwactiva.setVisibility(View.GONE);
                ivPantallaCuatroVwactiva.setVisibility(View.GONE);
                ivPantallaDosVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaUnoVwactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                idPantalla = "1";
                server = "192.168.0.104";
                break;
            case R.id.ivPantallaUnoVwactiva:
                break;
            case R.id.ivPantallaDosVwInactiva:
                ivPantallaDosVwInactiva.setVisibility(View.GONE);
                varComunes();
                ivPantallaUnoVwactiva.setVisibility(View.GONE);
                ivPantallaTresVwactiva.setVisibility(View.GONE);
                ivPantallaCuatroVwactiva.setVisibility(View.GONE);
                ivPantallaUnoVwInactiva.setVisibility(View.VISIBLE);
                ivPantallaDosVwactiva.setVisibility(View.VISIBLE);
                bandera = 1;
                idPantalla = "2";
                server = "192.168.0.100";
                break;
            case R.id.ivPantallaDosVwactiva:
                break;
            case R.id.ivPantallaTresVwInactiva:
                ivPantallaTresVwInactiva.setVisibility(View.GONE);
                varComunes();
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
                varComunes();
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
            case R.id.rlCerrarCast:
                finish();
                break;
            case R.id.ivFlechaAtrasPilar:
                linearSeleccionPantallasPilar.setVisibility(View.GONE);
                linearMenucast.setVisibility(View.VISIBLE);
                break;
            case R.id.ivFlechaAtrasVideoWall:
                linearSeleccionPantallasVideoWall.setVisibility(View.GONE);
                linearMenucast.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void varComunes() {
        ivFlechaCast.setVisibility(View.GONE);
        tvTextoCast.setVisibility(View.GONE);
        ivIconCastFc.setVisibility(View.GONE);
        rlErrorCast.setVisibility(View.GONE);
    }

    public void pregunta(final String nombrePaquete) {
        EventBus.getDefault().postSticky(new Message(idGrupo, idPantalla, server, mensajeRecibido));
        EventBus.getDefault().postSticky(new Recordar(idGrupo));
        prueba.setVisibility(View.GONE);
        rlPreguntaApp.setVisibility(View.VISIBLE);
        ivBotonSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getApplication().getPackageManager().getLaunchIntentForPackage(nombrePaquete);
                if (launchIntent != null) {
                    startActivity(launchIntent);
                    finish();

                }
            }
        });
        ivBotonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onFondoRecordar(FondoCastRecordar event) {
        idGrupo = event.getIdGrupo();
        idPantalla = event.getIdPantalla();
        server = event.getServer();
    }
}

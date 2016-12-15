package com.example.jimmyhernandez.tabletvendedor;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.jimmyhernandez.tabletvendedor.CLS.ClientSocket;
import com.example.jimmyhernandez.tabletvendedor.models.Elemento;
import com.example.jimmyhernandez.tabletvendedor.models.Functions;
import com.example.jimmyhernandez.tabletvendedor.models.OutObject;
import com.example.jimmyhernandez.tabletvendedor.models.Session;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.karim.MaterialTabs;

import static com.example.jimmyhernandez.tabletvendedor.models.Functions.fileNameJson;

public class MainActivity extends AppCompatActivity {


    int contCast = 0;
    @BindView(R.id.material_tabs)
    MaterialTabs materialTabs;
    @BindView(R.id.linear_top)
    LinearLayout linearTop;
    @BindView(R.id.vp)
    ViewPager pager;
    @BindView(R.id.linear_menucast)
    RelativeLayout linearMenucast;
    @BindView(R.id.fab_cast)
    FloatingActionButton fabCast;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
//    @BindView(R.id.iconoClientes)
//    ImageView iconoClientes;
    @BindView(R.id.linear_menucast_activo)
    LinearLayout linearMenucastActivo;
    @BindView(R.id.logoEntel)
    ImageView logoEntel;
    @BindView(R.id.ivGrupoVideoWallActivo)
    ImageView ivGrupoVideoWallActivo;
    @BindView(R.id.ivGrupoPilarActivo)
    ImageView ivGrupoPilarActivo;
    @BindView(R.id.ivBotonCastDesconect)
    ImageView ivBotonCastDesconect;
    @BindView(R.id.ivGrupoVideoWallInactivo)
    ImageView ivGrupoVideoWallInactivo;
    @BindView(R.id.ivGrupoPilarInactivo)
    ImageView ivGrupoPilarInactivo;
    @BindView(R.id.tvNombreCast)
    TextView tvNombreCast;
    @BindView(R.id.tvTipoDispCast)
    TextView tvTipoDispCast;
    @BindView(R.id.tvNumeroPantCast)
    TextView tvNumeroPantCast;
    @BindView(R.id.ivMail)
    ImageView ivMail;
    @BindView(R.id.ivCerrarSesion)
    ImageView ivCerrarSesion;
    @BindView(R.id.tvMail)
    TextView tvMail;


    private String idUsuario = "user";
    private String idGrupo = "group";
    private String idPantalla = "screen";
    private String server = "server";
    private String cast;
    private String email;


    private String message;
    private String mensaje;
    private int port;
    String TAG = "HOLA";
    Vibrator v;
    final Handler hh = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fresco.initialize(this);
        /*
         * Seteando el Fullscreen
		 */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*
         * Cargando contenido del layout
		 */
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        Bundle extras = getIntent().getExtras();
        email = extras.getString("email");
        tvMail.setText(email);



        if (idGrupo == "hola") {
            linearMenucast.setVisibility(View.GONE);
        }
        port = 9090;

        SamplePagerAdapter adapter = new SamplePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        materialTabs.setViewPager(pager);
        Serialize();
        //  obtenerJson();


    }

    public void Serialize()
    {

        Thread th = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {

                    //Metodo que realiza una accion que requiere ser llamada en segundo plano u otro Hilo
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + Functions.dirHome + fileNameJson;
                    File f = new File(path);
                    if (f.exists())
                    {
                        File file = new File(path);
                        int length = (int) file.length();
                        byte[] bytes = new byte[length];
                        FileInputStream in = new FileInputStream(file);
                        try
                        {
                            in.read(bytes);
                        } finally
                        {
                            in.close();
                        }
                        Functions.jsonData = new String(bytes);
                        Log.i("Json Read:", Functions.jsonData);
                    }

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                //Handler que ejecuta el metodo cuando termina el Hilo
                hh.postDelayed(toObject, 3000);
            }
        });//end thread
        th.start();
    }

    final Runnable toObject = new Runnable()
    {
        public void run()
        {
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();
            JSONObject j;
            OutObject gig = null;
            try
            {
                j = new JSONObject(Functions.jsonData);
                gig = gson.fromJson(j.toString(), OutObject.class);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            Session.objSession = gig;

            ArrayList<Elemento> lista = Session.objSession.getListacategorias();

            for (int i = 0; i < lista.size(); i++)
            {
                lista.get(i).getNombre();

                Log.d("Nombre", lista.get(i).getNombre());

            }
        }
    };



    /*public void obtenerJson(){


        new AsyncTask<Void,Void,Void>(){
            String urlJson = "http://192.168.1.106/archivo/document.json";
            StringBuilder response = null;
            String respuesta = "";
            File SDCardRoot = new File (Environment.getExternalStorageDirectory().getAbsolutePath() + "/SourceApp/");
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlJson);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("charset", "utf-8");
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    respuesta = response.toString();
                    File file = new File(SDCardRoot,"Objects.json");
                    FileOutputStream fileOutput = new FileOutputStream(file);
                    fileOutput.write(respuesta.getBytes());
                } catch (Exception  e) {
                    respuesta = "Error->" + e.getMessage();
                }
                return null;
            }
        }.execute();

    }*/





    /*
    * Acción de clicks  animacion seleccione dispositivo
	*/
    @OnClick({R.id.linear_menucast, R.id.fab_cast,  R.id.linear_menucast_activo, R.id.ivBotonCastDesconect, R.id.ivMail, R.id.ivCerrarSesion})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_menucast:
                break;
            case R.id.fab_cast:
                break;
//            case R.id.iconoClientes:
//                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.linear_menucast_activo:
                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivBotonCastDesconect:
                message = idGrupo + "|" + idPantalla + "|" + "disconnect";
                EventBus.getDefault().postSticky(new Recordar("cerrar"));
                ClientSocket myClient = new ClientSocket(server, port, message);
                myClient.execute();
                EventBus.getDefault().postSticky(new Message("group", "screen", "server", ""));
                linearMenucast.setVisibility(View.GONE);
                break;
            case R.id.ivMail:
                YoYo.with(Techniques.SlideInRight).duration(600).playOn(ivCerrarSesion);
                ivCerrarSesion.setVisibility(View.VISIBLE);
                break;
            case R.id.ivCerrarSesion:
                v.vibrate(50);
                finish();
                break;
            /*case R.id.rlSesion:
                Toast.makeText(this, "nail", Toast.LENGTH_SHORT).show();
                *//*YoYo.with(Techniques.SlideInUp).duration(200).playOn(ivCerrarSesion);
                ivCerrarSesion.setVisibility(View.VISIBLE);*//*
                break;*/
        }
    }


    /*
    * Adaptador de los fragmentos para los tabs
	*/
    public class SamplePagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"App entel", "Recomendamos", "Te ayudamos", "Hogar", "Planes"};

        private final ArrayList<String> mTitles;

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
            mTitles = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                mTitles.add(TITLES[i]);
            }
        }

        /*
       Captura posision para rellenar framelayout
        */
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        /*
       Contador de tamano titulos viewpager
        */
        @Override
        public int getCount() {
            return mTitles.size();
        }

        /*
        Captura posision para rellenar framelayout
         */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new AppEntelFragment();
                case 1:
                    return new RecomendamosFragment();
                case 2:
                    return new TeAyudamosFragment();
//                case 3:
//                    return new AccesoriosFragment();
                case 3:
                    return new HogarFragment();
                case 4:
                    return new PlanesFragment();
//                case 6:
//                    return new EquiposFragment();
                default:
                    return new AppEntelFragment();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        if (idGrupo == "cerrar" || mensaje == "cerrar") {
            linearMenucast.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessage(Message event) {
        idGrupo = event.getIdGrupo();
        idPantalla = event.getIdPantalla();
        server = event.getServer();
        cast = Character.toUpperCase(event.getCast().charAt(0)) + event.getCast().substring(1, event.getCast().length());
        tvNombreCast.setText(cast);
        if (idGrupo == "cerrar") {
            linearMenucast.setVisibility(View.GONE);
        } else if (idGrupo == "2") {
            ivGrupoPilarActivo.setVisibility(View.VISIBLE);
            ivGrupoPilarInactivo.setVisibility(View.GONE);
            ivGrupoVideoWallActivo.setVisibility(View.GONE);
            ivGrupoVideoWallInactivo.setVisibility(View.VISIBLE);
            linearMenucast.setVisibility(View.VISIBLE);
            tvTipoDispCast.setText("Pilar");
            tvNumeroPantCast.setText(idPantalla);
        } else if (idGrupo == "1") {
            ivGrupoVideoWallActivo.setVisibility(View.VISIBLE);
            ivGrupoVideoWallInactivo.setVisibility(View.GONE);
            ivGrupoPilarActivo.setVisibility(View.GONE);
            ivGrupoPilarInactivo.setVisibility(View.VISIBLE);
            linearMenucast.setVisibility(View.VISIBLE);
            tvTipoDispCast.setText("VideoWall");
            tvNumeroPantCast.setText(idPantalla);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onRecordar(Recordar event) {
        mensaje = event.getMensaje();
        if (mensaje == "cerrar") {
            linearMenucast.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        // Setting Dialog Title
        alertDialog.setTitle("Salir de la Aplicaci\u00f3n");
        // Setting Dialog Message
        alertDialog.setMessage("\u00bfQuieres salir de la aplicaci\u00f3n?");
        // Setting Icon to Dialog
        // alertDialog.setIcon(R.drawable.delete);
        // On pressing Settings button
        alertDialog.setPositiveButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        // on pressing cancel button
        alertDialog.setNegativeButton("Si",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        EventBus.getDefault().postSticky(new Message("cerrar", idPantalla, server, ""));
                        finish();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
        //finish();
    }


}
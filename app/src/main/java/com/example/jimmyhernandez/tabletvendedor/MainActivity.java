package com.example.jimmyhernandez.tabletvendedor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.jimmyhernandez.tabletvendedor.CLS.ClientSocket;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.karim.MaterialTabs;

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
    @BindView(R.id.iconoClientes)
    ImageView iconoClientes;
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

    private String idGrupo = "hola";
    private String idPantalla;
    private String server;
    private String message;
    private int port;

    String TAG = "HOLA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MAINACTIVITY onCreate"+idGrupo);
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

        /*
         * Adaptación de los Fragmentos para los Tabs
		 */


        if(idGrupo == "hola"){
            Log.d(TAG, "MAINACTIVITY If"+idGrupo);
            linearMenucast.setVisibility(View.GONE);
        }
        port = 8080;

        SamplePagerAdapter adapter = new SamplePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        materialTabs.setViewPager(pager);
    }

    /*
    * Acción de clicks  animacion seleccione dispositivo
	*/
    @OnClick({R.id.linear_menucast, R.id.fab_cast, R.id.iconoClientes, R.id.linear_menucast_activo, R.id.ivBotonCastDesconect})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_menucast:
                break;
            case R.id.fab_cast:
                break;
            case R.id.iconoClientes:
                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_menucast_activo:
                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivBotonCastDesconect:
                message = idGrupo + "|" + idPantalla + "|" + "disconnect";
                //EventBus.getDefault().postSticky(new Message("hola", idPantalla, server));
                Log.d(TAG, "MAINACTIVITY Boton Cast"+idGrupo);
                ClientSocket myClient = new ClientSocket(server, port, message);
                myClient.execute();
                linearMenucast.setVisibility(View.GONE);
                break;
        }
    }



    /*
	* Adaptador de los fragmentos para los tabs
	*/
    public class SamplePagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"App entel", "Recomendamos", "Te ayudamos", "Accesorios", "Hogar", "Planes", "Equipos"};

        private final ArrayList<String> mTitles;

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
            mTitles = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
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
                case 3:
                    return new AccesoriosFragment();
                case 4:
                    return new HogarFragment();
                case 5:
                    return new PlanesFragment();
                case 6:
                    return new EquiposFragment();
                default:
                    return new AppEntelFragment();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MAINACTIVITY onResume"+idGrupo);
        EventBus.getDefault().register(this);
        if(idGrupo == "cerrar"){
            linearMenucast.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MAINACTIVITY onPause"+idGrupo);
        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "MAINACTIVITY onDestroy"+idGrupo);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessage(Message event) {
        Log.d(TAG, "MAINACTIVITY onMessage"+idGrupo);
        idGrupo = event.getIdGrupo();
        idPantalla = event.getIdPantalla();
        server = event.getServer();
        if(idGrupo == "cerrar"){
            linearMenucast.setVisibility(View.GONE);
        }else {
            linearMenucast.setVisibility(View.VISIBLE);
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
                        EventBus.getDefault().postSticky(new Message("cerrar", idPantalla, server));
                        finish();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
        //finish();
    }


}
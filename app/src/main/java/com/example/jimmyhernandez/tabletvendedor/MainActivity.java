package com.example.jimmyhernandez.tabletvendedor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

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
    LinearLayout linearMenucast;
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

        /*
		 * Adaptación de los Fragmentos para los Tabs
		 */
        SamplePagerAdapter adapter = new SamplePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        materialTabs.setViewPager(pager);
    }

    /*
	* Acción de clicks  animacion seleccione dispositivo
	*/
    @OnClick({R.id.linear_menucast, R.id.fab_cast, R.id.iconoClientes, R.id.linear_menucast_activo,})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_menucast:
                if (contCast == 1) {
                    YoYo.with(Techniques.SlideOutDown).duration(200).playOn(linearMenucast);
                    contCast = 0;
                }
                break;
            case R.id.fab_cast:
                if (contCast == 0) {
                    Toast.makeText(this, "Aqui", Toast.LENGTH_SHORT).show();
                    YoYo.with(Techniques.SlideInUp).duration(200).playOn(linearMenucast);
                    linearMenucast.setVisibility(View.VISIBLE);
                    contCast = 1;
                }
                break;
            case R.id.iconoClientes:
                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_menucast_activo:
                Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
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
}
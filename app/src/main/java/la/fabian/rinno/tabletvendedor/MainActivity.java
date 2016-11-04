package la.fabian.rinno.tabletvendedor;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.support.v4.view.ViewPager;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

import io.karim.MaterialTabs;

public class MainActivity extends AppCompatActivity {

    //Declaración de variables de forma global
    ViewPager pager;
    LinearLayout linearSecreto, linearMenuCast;
    FloatingActionButton fabCast;
    MaterialTabs tabs;
    int contSecret = 0, contCast = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);

        //Seteando el Fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Cargando contenido del layout
        setContentView(R.layout.activity_main);

        //Asignación de variables
        linearSecreto = (LinearLayout) findViewById(R.id.linear_secreto);
        fabCast = (FloatingActionButton) findViewById(R.id.fab_cast);
        linearMenuCast = (LinearLayout) findViewById(R.id.linear_menucast);
        tabs = (MaterialTabs) findViewById(R.id.material_tabs);
        pager = (ViewPager) findViewById(R.id.vp);

        //Adaptación de los Fragmentos para los Tabs
        SamplePagerAdapter adapter = new SamplePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);


        //Acción de clicks (botones)
        fabCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contCast == 0) {
                    YoYo.with(Techniques.SlideInUp).duration(200).playOn(linearMenuCast);
                    linearMenuCast.setVisibility(View.VISIBLE);
                    contCast = 1;
                }

            }
        });

        linearMenuCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contCast == 1) {
                    YoYo.with(Techniques.SlideOutDown).duration(200).playOn(linearMenuCast);
                    contCast = 0;
                }


            }
        });

        linearSecreto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contSecret++;
                if (contSecret == 3) {
                    contSecret = 0;
                    startActivity(new Intent(getApplicationContext(), SecretConfigActivity.class));
                }
            }
        });
    }

    //Adaptador de los fragmentos para los tabs
    public class SamplePagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"Promociones", "Planes", "Equipos", "Accesorios", "Hogar", "Preguntas Frecuentes"};

        private final ArrayList<String> mTitles;

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
            mTitles = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                mTitles.add(TITLES[i]);
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public int getCount() {
            return mTitles.size();
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new PromocionesFragment();
                case 1:
                    return new PlanesFragment();
                case 2:
                    return new EquiposFragment();
                case 3:
                    return new AccesoriosFragment();
                case 4:
                    return new HogarFragment();
                case 5:
                    return new PreguntasFrecuentesFragment();
                default:
                    return new PromocionesFragment();
            }
        }
    }
}

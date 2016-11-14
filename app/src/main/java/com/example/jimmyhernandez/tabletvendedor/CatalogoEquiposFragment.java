package com.example.jimmyhernandez.tabletvendedor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogoEquiposFragment extends Fragment {


    public CatalogoEquiposFragment() {
        // Required empty public constructor
    }

    /**
     * http://www.codigoandroid.es/curso-programacion-android/tutorial-android-interfaz-de-usuario-con-pestanas/
     * http://www.androidhive.info/2015/09/android-material-design-working-with-tabs/
     * http://www.hermosaprogramacion.com/2015/06/tablayout-como-anadir-pestanas-en-android/
     * http://www.hermosaprogramacion.com/2015/07/tutorial-para-crear-un-gridview-en-android/
     * http://www.proyectosimio.com/es/programacion-android-como-usar-fragments-con-viewpager-y-efecto-swipe/
     * http://trucosandroidstudio.blogspot.cl/2015/04/como-programar-tabs-en-android-studio.html
     */



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalogo_equipos, container, false);
    }

}

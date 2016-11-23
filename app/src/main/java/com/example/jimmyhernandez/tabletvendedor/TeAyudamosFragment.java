package com.example.jimmyhernandez.tabletvendedor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeAyudamosFragment extends Fragment {

    private String idGrupo;
    private String idPantalla;
    private String server;
    private String message;
    private int port;
    private int unicode;

    public TeAyudamosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_te_ayudamos, container, false);
        Toast.makeText(getContext(), "Numero Grupo:  "+idGrupo, Toast.LENGTH_SHORT).show();

        return v;
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
    public void onMessage(Message event) {
        //mytextview.setText(event.getMessage());
        idGrupo = event.getIdGrupo();
        idPantalla = event.getIdPantalla();
        server = event.getServer();


        /*if (idGrupo.equals("1")) {
            ivGrupoPilarActivo.setVisibility(View.GONE);
            ivGrupoPilarInactivo.setVisibility(View.VISIBLE);
        }else if(idGrupo.equals("2")){
            ivGrupoVideoWallActivo.setVisibility(View.GONE);
            ivGrupoVideoWallInactivo.setVisibility(View.VISIBLE);
        }*/
    }

}

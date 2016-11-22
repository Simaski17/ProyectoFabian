package com.example.jimmyhernandez.tabletvendedor;


import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecomendamosFragment extends Fragment {


    @BindView(R.id.icnSpotify)
    ImageView icnSpotify;
    @BindView(R.id.icnNetflix)
    ImageView icnNetflix;
    @BindView(R.id.icnApple)
    ImageView icnApple;
    @BindView(R.id.icnUber)
    ImageView icnUber;
    @BindView(R.id.icnSnapchat)
    ImageView icnSnapchat;
    @BindView(R.id.icnWaze)
    ImageView icnWaze;

    ImageView imv;
    private  String mensaje;

    String TAG = "HOLA";

    PackageManager pm;

    public RecomendamosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recomendamos, container, false);
        ButterKnife.bind(this, view);


        return view;
    }


    @OnClick({R.id.icnSpotify, R.id.icnNetflix, R.id.icnApple, R.id.icnUber, R.id.icnSnapchat, R.id.icnWaze})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icnSpotify:
                mensaje = "spotify";
                imv = (ImageView) view;
                cast(icnSpotify);
                break;
            case R.id.icnNetflix:
                mensaje = "netflix";
                imv = (ImageView) view;
                cast(imv);
                break;
            case R.id.icnApple:
                mensaje = "apple";
                imv = (ImageView) view;
                cast(imv);
                break;
            case R.id.icnUber:
                mensaje = "uber";
                imv = (ImageView) view;
                cast(imv);
                break;
            case R.id.icnSnapchat:
                mensaje = "snapchat";
                imv = (ImageView) view;
                cast(imv);
                break;
            case R.id.icnWaze:
                mensaje = "waze";
                imv = (ImageView) view;
                cast(imv);
                break;
        }
    }

    public void cast(View view){
        ImageView imvf = (ImageView)  view;
        imvf.setDrawingCacheEnabled(true);
        Bitmap bitmap = imvf.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bitmapdata = stream.toByteArray();

        Intent intent = new Intent(getContext(), FondoCastActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), imv, "transitionname");
        intent.putExtra("img", bitmapdata);
        intent.putExtra("mensaje", mensaje);
        startActivity(intent, optionsCompat.toBundle());
    }

    public void  LaunchComponent (String packageName, String name){

        Log.d(TAG, "Nombre paquete " + packageName);
        Intent i = new Intent(Intent.ACTION_MAIN);
        PackageManager manager = getActivity().getPackageManager();
        i = manager.getLaunchIntentForPackage(packageName);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(i);


    }

}

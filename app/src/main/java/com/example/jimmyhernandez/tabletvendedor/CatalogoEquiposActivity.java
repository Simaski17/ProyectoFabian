package com.example.jimmyhernandez.tabletvendedor;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CatalogoEquiposActivity extends AppCompatActivity {

    @BindView(R.id.llEnPromocion)
    LinearLayout llEnPromocion;
    @BindView(R.id.llMarca)
    LinearLayout llMarca;
    @BindView(R.id.llPantalla)
    LinearLayout llPantalla;
    @BindView(R.id.llCamaraFrontal)
    LinearLayout llCamaraFrontal;
    @BindView(R.id.llCamaraTrasera)
    LinearLayout llCamaraTrasera;
    @BindView(R.id.llTodos)
    LinearLayout llTodos;
    @BindView(R.id.recyclerEquiposDestacados)
    RecyclerView recyclerEquiposDestacados;
    @BindView(R.id.ivBotonAtrasCatalogoEqupos)
    ImageView ivBotonAtrasCatalogoEqupos;
    @BindView(R.id.ivFlechaArribaCatalogoEquipos)
    ImageView ivFlechaArribaCatalogoEquipos;
    @BindView(R.id.ivFlechaAbajoCatalogoEquipos)
    ImageView ivFlechaAbajoCatalogoEquipos;
    private List<ItemCatalogoEquipos> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListaCatalogoEquiposAdapter mAdapter;

    String TAG = "HOLA";
    GridLayoutManager mLayoutManager;

    private int previousTotal = 0;
    //private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_equipos);
        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerEquiposDestacados);
        mAdapter = new ListaCatalogoEquiposAdapter(movieList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getApplication(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {


            }
        });

        initializeData();
    }

    public void onScrolled() {

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLayoutManager.getItemCount();
        firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();



        Log.i(TAG, "ITEM COUNT: " + totalItemCount);
        Log.i(TAG, "ITEM FIRST: " + firstVisibleItem);


        /*
        if (!loading && (totalItemCount - visibleItemCount)   <= (firstVisibleItem + visibleThreshold)) {
            // End has been reached

            Log.i("Yaeye!", "end called");

            // Do something

            loading = true;
        }*/
    }

    private void initializeData() {
        ItemCatalogoEquipos item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Huawei P9", "Kirin");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgtransferir, "Lg G5", "Snapdragon");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Lg G5", "Snapdragon");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);

        item = new ItemCatalogoEquipos(R.drawable.imgcuidarmegas, "Xiaomi Mi 3", "Mediatek");
        movieList.add(item);


    }


    private void selectTab(View v) {
        View parent = v.getRootView();
        ArrayList<View> tocables = parent.getTouchables();
        View view;
        for (View b : tocables) {
            if (b instanceof LinearLayout) {
                //Modificar a gusto propio
                b.setBackgroundColor(ContextCompat.getColor(this, R.color.BlancoEntel));
                for (int i = 0; i < ((LinearLayout) b).getChildCount(); i++) {
                    view = ((LinearLayout) b).getChildAt(i);
                    TextView tv = (TextView) view;
                    if (!tv.getText().equals("[") && !tv.getText().equals("_")) {
                        tv.setTextColor(ContextCompat.getColor(this, R.color.AzulEntel));
                    }
                }
            }
        }
        v.setBackgroundColor(ContextCompat.getColor(this, R.color.AzulEntel));
        ArrayList<View> text = v.getTouchables();
        for (View t : text) {
            //Modificar a gusto propio
            for (int i = 0; i < ((LinearLayout) t).getChildCount(); i++) {
                view = ((LinearLayout) t).getChildAt(i);
                TextView tv = (TextView) view;
                if (!tv.getText().equals("[") && !tv.getText().equals("_")) {
                    tv.setTextColor(ContextCompat.getColor(this, R.color.BlancoEntel));
                }
            }
        }
    }

    @OnClick({R.id.llEnPromocion, R.id.llMarca, R.id.llPantalla, R.id.llCamaraFrontal, R.id.llCamaraTrasera, R.id.ivBotonAtrasCatalogoEqupos, R.id.ivFlechaArribaCatalogoEquipos, R.id.ivFlechaAbajoCatalogoEquipos})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llEnPromocion:
                selectTab(view);
                break;
            case R.id.llMarca:
                selectTab(view);
                break;
            case R.id.llPantalla:
                selectTab(view);
                break;
            case R.id.llCamaraFrontal:
                selectTab(view);
                break;
            case R.id.llCamaraTrasera:
                selectTab(view);
                break;
            case R.id.ivBotonAtrasCatalogoEqupos:
                finish();
                break;
            case R.id.ivFlechaArribaCatalogoEquipos:
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
                previousTotal = firstVisibleItem - 3;
                Log.i(TAG, "ITEM COUNT: " + totalItemCount);
                Log.i(TAG, "ITEM FIRST: " + firstVisibleItem);

                mLayoutManager.scrollToPositionWithOffset(previousTotal,previousTotal+2);

                break;
            case R.id.ivFlechaAbajoCatalogoEquipos:
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
                previousTotal = firstVisibleItem + 3;
                Log.i(TAG, "ITEM COUNT: " + totalItemCount);
                Log.i(TAG, "ITEM FIRST: " + firstVisibleItem);

                mLayoutManager.scrollToPositionWithOffset(previousTotal,previousTotal+2);

                break;
        }
    }

}

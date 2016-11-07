package com.example.jimmyhernandez.tabletvendedor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {
    private final int SPLASH_TIME = 3000;
    int densidad;
    int ancho;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        /*
		 * Seteando el Fullscreen
		 */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);

		/*
		 * Handler que quitará el splash screen después del SPLASH_TIME y creará
		 * un intent de la actividad principal.
		 */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
				/*
				 * Creamos un Intent que lanzará nuestra Actividad principal (en
				 * nuestro caso Main.java)
				 */
                Intent miIntent = new Intent(SplashScreen.this,MainActivity.class);
                SplashScreen.this.startActivity(miIntent);
                SplashScreen.this.finish();
            }
        }, SPLASH_TIME);
    }

    @Override
    public void onPause() {
        super.onPause();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onResume() {
        super.onResume();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

}
package com.example.jimmyhernandez.tabletvendedor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FondoCastActivity extends AppCompatActivity {

    ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fondo_cast);
        imv = (ImageView) findViewById(R.id.prueba);
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("img");

        imv.setImageBitmap(ByteArraytoDrawable(byteArray));

    }


    public Bitmap ByteArraytoDrawable(byte[] byteArray){
        Bitmap bmp;
        return bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

}

package com.example.chargerapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gc.materialdesign.views.Slider;

public class Connector extends AppCompatActivity {
    ImageView nema, nema1450, j1227;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connecto);
        nema = findViewById(R.id.nema);
        nema1450 = findViewById(R.id.nema1450);

        j1227 = findViewById(R.id.j1772);
        nema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            nema.setImageDrawable(getDrawable(R.drawable.nemaya5));
            }
        });
        nema1450.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nema1450.setImageDrawable(getDrawable(R.drawable.nemayaa));
            }
        });
        j1227.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j1227.setImageDrawable(getDrawable(R.drawable.j1829));
            }
        });

    }
}

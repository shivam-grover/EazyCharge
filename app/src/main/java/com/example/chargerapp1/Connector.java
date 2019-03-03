package com.example.chargerapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gc.materialdesign.views.Slider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Connector extends AppCompatActivity {
    ImageView nema, nema1450, j1227, tesla, chadmoe, SAE;
    public int i=0,j=0,k=0,l=0,m=0,n=0;
    DatabaseReference databaseReference;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connecto);
        databaseReference = FirebaseDatabase.getInstance().getReference("Operator Details").child("Connector");
        button = findViewById(R.id.button);
        nema = findViewById(R.id.nema);
        nema1450 = findViewById(R.id.nema1450);

        j1227 = findViewById(R.id.j1772);
        tesla = findViewById(R.id.nema1450aa);
        chadmoe = findViewById(R.id.nemaaa);
        SAE = findViewById(R.id.j1772aa);
        nema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
            nema.setImageDrawable(getDrawable(R.drawable.nemaya5));
            }
        });
        nema1450.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j=1;
                nema1450.setImageDrawable(getDrawable(R.drawable.nemayaa));
            }
        });
        j1227.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k=1;
                j1227.setImageDrawable(getDrawable(R.drawable.j1829));
            }
        });
        tesla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l=1;
                tesla.setImageDrawable(getDrawable(R.drawable.teslaa));
            }
        });
        chadmoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m=1;
                chadmoe.setImageDrawable(getDrawable(R.drawable.chadmoe7));
            }
        });
        SAE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=1;
                SAE.setImageDrawable(getDrawable(R.drawable.j1772ya));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("Initial Price").setValue(i+""+j+""+k+""+l+""+m+""+n);
                startActivity(new Intent(Connector.this, Navi.class));
            }
        });

    }
}

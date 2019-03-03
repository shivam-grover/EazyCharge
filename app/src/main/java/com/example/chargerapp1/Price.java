package com.example.chargerapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.Slider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Price extends AppCompatActivity {
    Slider sliderGreen, sliderOra, sliderRed;
    TextView green, orange, red;
    DatabaseReference databaseReference;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        sliderGreen = findViewById(R.id.slider);
        sliderOra = findViewById(R.id.slider2);
        sliderRed = findViewById(R.id.slider3);
        next = findViewById(R.id.button);
        green = findViewById(R.id.textView2);
        orange = findViewById(R.id.num_med);
        red = findViewById(R.id.num_s);
        databaseReference= FirebaseDatabase.getInstance().getReference("Operator Details").child("Prices");
        sliderGreen.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                float a = sliderGreen.getValue();//                Toast.makeText(getApplicationContext(), "Slider"+ sliderGreen.getValue() + "error " + sliderGreen.getValue()%10 + " " + a, Toast.LENGTH_SHORT).show();
                green.setText(a/100+"");
            }
        });

        sliderRed.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                float a = (sliderRed.getValue());//                Toast.makeText(getApplicationContext(), "Slider"+ sliderGreen.getValue() + "error " + sliderGreen.getValue()%10 + " " + a, Toast.LENGTH_SHORT).show();
                red.setText(a/100+"");
            }
        });


        sliderOra.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                float a = sliderOra.getValue();
//                Toast.makeText(getApplicationContext(), "Slider"+ sliderGreen.getValue() + "error " + sliderGreen.getValue()%10 + " " + a, Toast.LENGTH_SHORT).show();
                orange.setText(a/100+"");
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("Level_3").setValue(green.getText().toString());
                databaseReference.child("Level_2").setValue(orange.getText().toString());
                databaseReference.child("Level_1").setValue(red.getText().toString());

                startActivity(new Intent(Price.this, Connector.class));
            }
        });
    }
}

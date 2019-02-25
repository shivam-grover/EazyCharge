package com.example.chargerapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.Slider;

public class Price extends AppCompatActivity {
    Slider sliderGreen, sliderOra, sliderRed;
    TextView green, orange, red;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        sliderGreen = findViewById(R.id.slider);
        sliderOra = findViewById(R.id.slider2);
        sliderRed = findViewById(R.id.slider3);
        green = findViewById(R.id.textView2);
        orange = findViewById(R.id.num_med);
        red = findViewById(R.id.num_s);
        sliderGreen.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                int a = sliderGreen.getValue()*10;
//                Toast.makeText(getApplicationContext(), "Slider"+ sliderGreen.getValue() + "error " + sliderGreen.getValue()%10 + " " + a, Toast.LENGTH_SHORT).show();
                green.setText(a+"");
            }
        });

        sliderRed.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                int a = sliderRed.getValue()*10;
//                Toast.makeText(getApplicationContext(), "Slider"+ sliderGreen.getValue() + "error " + sliderGreen.getValue()%10 + " " + a, Toast.LENGTH_SHORT).show();
                red.setText(a+"");
            }
        });


        sliderOra.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                int a = sliderOra.getValue()*10;
//                Toast.makeText(getApplicationContext(), "Slider"+ sliderGreen.getValue() + "error " + sliderGreen.getValue()%10 + " " + a, Toast.LENGTH_SHORT).show();
                orange.setText(a+"");
            }
        });
    }
}

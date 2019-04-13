package com.example.chargerapp1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.Slider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PriceUpdate extends AppCompatActivity {

    float i;

            DatabaseReference databaseReference;
            Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_update);
        final Slider sliderGreen =  findViewById(R.id.slider2);
        final TextView textView = findViewById(R.id.num_med);
        final TextView textView1 = findViewById(R.id.fast);
        final TextView textView2 = findViewById(R.id.med);
        final TextView textView3 = findViewById(R.id.slow);
        final DatabaseReference databaseReferencea;
        button = findViewById(R.id.button2);
        databaseReferencea = FirebaseDatabase.getInstance().getReference("Operator Details").child("Prices");
        databaseReference = FirebaseDatabase.getInstance().getReference("price_pred").child("6").child("14");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReferencea.child("Level_1").setValue(textView3.getText().toString());
                databaseReferencea.child("Level_2").setValue(textView2.getText().toString());
                databaseReferencea.child("Level_3").setValue(textView1.getText().toString());

                Toast.makeText(getApplicationContext(),"PRICES UPDATED",Toast.LENGTH_SHORT).show();
            }
        });
        //        sliderGreen.setValue(0);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                i = Float.parseFloat(dataSnapshot.getValue().toString());
                Toast.makeText(getApplicationContext(),i + "aaaaa" + dataSnapshot.getValue(),Toast.LENGTH_SHORT).show();
                textView.setText(String.format("%.2f", i )+ "%");
                textView1.setText(String.format("%.2f", 50+(50*i/10000)));
                textView2.setText(String.format("%.2f", 30+(50*i/10000)));
                textView3.setText(String.format("%.2f", 12+(50*i/10000)));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        sliderGreen.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                float a = sliderGreen.getValue();//                Toast.makeText(getApplicationContext(), "Slider"+ sliderGreen.getValue() + "error " + sliderGreen.getValue()%10 + " " + a, Toast.LENGTH_SHORT).show();
                textView.setText(a/100+"%");
                textView1.setText(String.format("%.2f", 50+(50*a/10000)));
                textView2.setText(String.format("%.2f", 30+(50*a/10000)));
                textView3.setText(String.format("%.2f", 12+(50*a/10000)));

            }
        });




    }
}

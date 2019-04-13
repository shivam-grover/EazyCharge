package com.example.chargerapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailsPace extends AppCompatActivity {

    ImageView addFast, addmed, addSlow, subFast, subMed, subS;
    Button next;
    TextView fast, med, slow;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pace);
        addFast = findViewById(R.id.imageView2);
        addmed = findViewById(R.id.addmed);
        addSlow = findViewById(R.id.adds);
        subFast = findViewById(R.id.imageView3);
        subMed = findViewById(R.id.submed);
        subS = findViewById(R.id.sub_s);
        next = findViewById(R.id.button);
        fast = findViewById(R.id.textView2);
        med = findViewById(R.id.num_med);
        slow = findViewById(R.id.num_s);
        databaseReference = FirebaseDatabase.getInstance().getReference("Operator Details").child("Ports");

        addFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(fast.getText().toString());
                a = a +1;
                fast.setText(a+ "");
            }
        });

        addmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(med.getText().toString());
                a = a +1;
                med.setText(a + "");
            }
        });

        addSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(slow.getText().toString());
                a = a +1;
                slow.setText(a + "");
            }
        });

        subFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(fast.getText().toString());
                a = a -1;
                fast.setText(a+ "");
            }
        });

        subMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(med.getText().toString());
                a = a -1;
                med.setText(a + "");
            }
        });

        subS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(slow.getText().toString());
                a = a -1;
                slow.setText(a + "");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.child("Level_1").setValue(fast.getText().toString());
                databaseReference.child("Level_2").setValue(med.getText().toString());
                databaseReference.child("Level_3").setValue(slow.getText().toString());

                startActivity(new Intent(DetailsPace.this,Price.class));
            }
        });

    }
}

package com.example.chargerapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

    Button button;
    FirebaseAuth mauth;
    EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        button = findViewById(R.id.button);
        email= findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
//        mauth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                startActivity(new Intent(SignUp.this, MainActivity.class));

    //                mauth.createUserWithEmailAndPassword(email.toString(), password.toString())
    //                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    //                            @Override
    //                            public void onComplete(@NonNull Task<AuthResult> task) {
    //                                if (task.isSuccessful()) {
    //                                    // Sign in success, update UI with the signed-in user's information
    //                                    Log.d("DON", "createUserWithEmail:success");
    //                                    FirebaseUser user = mauth.getCurrentUser();
    //                                    startActivity(new Intent(SignUp.this, MainActivity.class));
    //
    //                                } else {
    //                                    // If sign in fails, display a message to the user.
    //                                    Log.w("NOT", "createUserWithEmail:failure", task.getException());
    //                                    Toast.makeText(SignUp.this, "Authentication failed.",
    //                                            Toast.LENGTH_SHORT).show();
    //                                    updateUI(null);
    //                                }
    //
    //                            }
    //                        });
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        Fireb\aseUser currentUser = mauth.getCurrentUser();
//        startActivity(new Intent(SignUp.this, MainActivity.class));


    }


}

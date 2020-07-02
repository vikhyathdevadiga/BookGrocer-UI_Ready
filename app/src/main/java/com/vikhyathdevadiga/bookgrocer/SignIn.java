package com.vikhyathdevadiga.bookgrocer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    TextView rememberMe;
    Button signUp, signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        rememberMe = findViewById(R.id.remember);
        signUp = findViewById(R.id.signup);
        signIn = findViewById(R.id.sign_in);

        rememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rememberMe.getText().equals(getString(R.string.form_stay_logged_in))){
                    rememberMe.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_checked, 0, 0, 0);
                    rememberMe.setText(getString(R.string.form_uwill_stay_logged_in));
                }
                else {
                    rememberMe.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_unchecked, 0, 0, 0);
                    rememberMe.setText(getString(R.string.form_stay_logged_in));
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), StoreLocator.class));
            }
        });
    }
}
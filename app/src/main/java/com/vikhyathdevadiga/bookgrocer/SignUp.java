package com.vikhyathdevadiga.bookgrocer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    TextView rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        rememberMe = findViewById(R.id.remember);

        rememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newsletter_true = getString(R.string.form_newsletter);
                String newsletter_false = getString(R.string.latest_update);

                if (rememberMe.getText().equals(newsletter_true)){
                    rememberMe.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_checked, 0, 0, 0);
                    rememberMe.setText(newsletter_false);
                }
                else {
                    rememberMe.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_unchecked, 0, 0, 0);
                    rememberMe.setText(newsletter_true);
                }
            }
        });

    }
}
package com.vikhyathdevadiga.bookgrocer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_VAR = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent next = new Intent(MainActivity.this, HomePage.class);
                startActivity(next);
                finish();
            }
        }, SPLASH_VAR);
    }
}
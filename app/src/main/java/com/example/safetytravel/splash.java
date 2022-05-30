package com.example.safetytravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


public class splash extends AppCompatActivity {

    Handler h=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View overlay = findViewById(R.id.splashLayout);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                      | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                      | View.SYSTEM_UI_FLAG_FULLSCREEN);

        h.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent i = new Intent(splash.this,login.class);
                startActivity(i);
                finish();
            }
        },3000);

    }
}
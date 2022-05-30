package com.example.safetytravel;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Termandcondition extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termandcondition);
        imageView=findViewById(R.id.backIconImageButton);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent= new Intent(Termandcondition.this,Dashboard.class);
                startActivity(intent);
                finish();

            }
        });



    }
}
package com.example.safetytravel;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class forget_password extends AppCompatActivity {


    EditText send_email;
    Button btn_send;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        send_email=findViewById(R.id.mail);
        btn_send=findViewById(R.id.rest);

        firebaseAuth=FirebaseAuth.getInstance();
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=send_email.getText().toString();
                if(email.equals("")){
                    Toast.makeText(forget_password.this,"Please enter your Email",Toast.LENGTH_SHORT).show();
                }
                else{
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(forget_password.this,"Please Check your Email!",Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(forget_password.this,login.class));
                            }
                            else
                            {
                                String error= Objects.requireNonNull(task.getException()).getMessage();
                                Toast.makeText(forget_password.this,error,Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });



    }
}
package com.example.safetytravel;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    TextView btn_register,btn_forgetPassword;
    EditText txtEmail,txtPassword;
    Button btn_login;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        btn_register=findViewById(R.id.registered);
        btn_forgetPassword=findViewById(R.id.restPassword);
        btn_login=findViewById(R.id.login);
        txtEmail=findViewById(R.id.email);
        txtPassword=findViewById(R.id.password);
        mAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(login.this,register.class);
                startActivity(i);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String email=txtEmail.getText().toString();
                String password=txtPassword.getText().toString();


                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(login.this,"Please enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(login.this,"Please enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<6)
                {
                    Toast.makeText(login.this,"Password is to short",Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    progressDialog.setMessage("Please Wait Login...!");
                    progressDialog.setTitle("LOGIN");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful())
                            {
                                progressDialog.dismiss();
                                Intent i = new Intent(login.this,Dashboard.class);
                                startActivity(i);
                                finish();
                                Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                progressDialog.dismiss();
                                Toast.makeText(login.this, ""+task.getException(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });



                }



            }
        });

        btn_forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(login.this,forget_password.class);

                startActivity(i);

                finish();

            }
        });




    }

}
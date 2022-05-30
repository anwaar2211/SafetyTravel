package com.example.safetytravel;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

public class register extends AppCompatActivity {

    /////////////////////////////////////////////

    EditText txtEmail,txtPassword,txtUserName;
    Button btn_register;
    RadioButton radioButton;
    RadioGroup radioGroup;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    FirebaseUser mUser;
    private ProgressDialog progressDialog;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    TextView backLoginText;
    int SelectedId;
    String SelectedRadio;

    ///////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUserName = findViewById(R.id.Username);
        txtEmail = findViewById(R.id.email);
        txtPassword = findViewById(R.id.password);
        btn_register = findViewById(R.id.registered);
        radioGroup = findViewById(R.id.radioGroup);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        backLoginText=findViewById(R.id.Backtologintext);


        backLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(register.this,login.class);
                startActivity(i);
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });

    }

    private void PerforAuth()
    {
        String email=txtEmail.getText().toString();
        String username=txtUserName.getText().toString();
        String Password=txtPassword.getText().toString();
        SelectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(SelectedId);
        SelectedRadio = radioButton.getText().toString();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(register.this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(username))
        {
            Toast.makeText(register.this,"Please enter user  Name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Password))
        {
            Toast.makeText(register.this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(Password.length()<6)
        {
            Toast.makeText(register.this,"Password is to short",Toast.LENGTH_SHORT).show();
            return;
        }

        else
        {
            progressDialog.setMessage("Please Wait Registration...!");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            register_data registerInfo = new register_data(username,email,Password,SelectedRadio);

            firebaseAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {

                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        Toast.makeText(register.this, "Registration SuccessFull", Toast.LENGTH_SHORT).show();
                        databaseReference.child(SelectedRadio).setValue(registerInfo);
                        Intent i = new Intent(register.this,Dashboard.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(register.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

}
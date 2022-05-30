package com.example.safetytravel;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Button profileBtn,BookingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.nav_bar);
        profileBtn=findViewById(R.id.buttonProfile);
        BookingBtn = findViewById(R.id.buttonTutor);

        BookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Dashboard.this,booking.class);
                startActivity(intent);
            }
        });

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Navigation_open,R.string.Navigation_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.profileView:
                        Toast.makeText(Dashboard.this, "Profile View", Toast.LENGTH_SHORT).show();
                        Intent intent4=new Intent(Dashboard.this,Profile.class);
                        startActivity(intent4);
                        return true;

                    case R.id.privacypolicy:
                        Toast.makeText(Dashboard.this, "Privacy Policy", Toast.LENGTH_SHORT).show();
                        Intent intent3=new Intent(Dashboard.this,PrivacyPolicy.class);
                        startActivity(intent3);
                        finish();
                        return true;

                    case R.id.termandcondition:
                        Toast.makeText(Dashboard.this, "Term And Conditions", Toast.LENGTH_SHORT).show();
                        Intent intent2=new Intent(Dashboard.this,Termandcondition.class);
                        startActivity(intent2);
                        finish();
                        return true;

                    case R.id.logout:

                        new AlertDialog.Builder(Dashboard.this)
                                .setTitle("LOGOUT")
                                .setMessage("ARE YOU SURE YOU WANT TO LOGOUT?")
                                .setIcon(R.drawable.ic_baseline_warning_24)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        Toast.makeText(Dashboard.this, "Logout...!", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(Dashboard.this,login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        dialog.dismiss();
                                    }
                                })
                                .show();

                        return true;

                    case R.id.share:

                        Intent intent1=new Intent(Intent.ACTION_SEND);
                        intent1.setType("text/Plain");
                        intent1.putExtra(Intent.EXTRA_SUBJECT,"DOWNLOAD THE SAFETY TRAVEL APP");
                        intent1.putExtra(Intent.EXTRA_TEXT,"WELCOME SAFETY TRAVEL APP");
                        startActivity(Intent.createChooser(intent1,"Share Via"));
                        return true;


                }

                return false;
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent= new Intent(Dashboard.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
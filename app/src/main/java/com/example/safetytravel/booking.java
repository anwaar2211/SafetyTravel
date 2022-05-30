package com.example.safetytravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.safetytravel.adapter.RecentsAdapter;
import com.example.safetytravel.adapter.TopPlacesAdapter;
import com.example.safetytravel.model.RecentsData;
import com.example.safetytravel.model.TopPlacesData;
import com.example.safetytravel.adapter.RecentsAdapter;
import com.example.safetytravel.adapter.TopPlacesAdapter;
import com.example.safetytravel.model.RecentsData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class booking extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    ImageView imageView;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // Now here we will add some dummy data in our model class
        imageView = findViewById(R.id.returnBackImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(booking.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Muskhpuri Top","Pakistan","From Rs2000",R.drawable.mushkpuritop));
        recentsDataList.add(new RecentsData("Margara Hills","Pakistan","From RS3500",R.drawable.margallahills));
        recentsDataList.add(new RecentsData("Islamabad","Pakistan","From RS4200",R.drawable.islamabad));
        recentsDataList.add(new RecentsData("Nathia Gali","Pakistan","From RS2000",R.drawable.nathiagali));
        recentsDataList.add(new RecentsData("Murree","Pakistan","From RS2900",R.drawable.murree));
        recentsDataList.add(new RecentsData("Islamabad","Pakistan","From RS3000",R.drawable.islamabad));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("KALAR KAHAR","Pakistan","RS2000 - RS5000",R.drawable.mushkpuritop));
        topPlacesDataList.add(new TopPlacesData("MARGILLA HILLS","Pakistan","RS1000 - RS7000",R.drawable.margallahills));
        topPlacesDataList.add(new TopPlacesData("MURRUEE","Pakistan","RS4000 - RS10000",R.drawable.islamabad));
        topPlacesDataList.add(new TopPlacesData("MALL ROAD","Pakistan","RS3000 - RS8000",R.drawable.nathiagali));
        topPlacesDataList.add(new TopPlacesData("islamabad","Pakistan","RS1600 - RS5500",R.drawable.murree));

        setTopPlacesRecycler(topPlacesDataList);
    }

    private  void setRecentRecycler(List<RecentsData> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private  void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }

}

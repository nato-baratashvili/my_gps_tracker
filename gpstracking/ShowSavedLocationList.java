package com.example.gpstracking;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ShowSavedLocationList extends AppCompatActivity {
    ListView lv_savedWayPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_saved_location_list);

        MyApplication myApplication = (MyApplication) getApplicationContext();
        List<Location> savedLocations = myApplication.getMyLocations();
        lv_savedWayPoints = findViewById(R.id.lv_wayPoints);
        lv_savedWayPoints.setAdapter(new ArrayAdapter<Location>( this, android.R.layout.simple_list_item_1 , savedLocations));
    }
}
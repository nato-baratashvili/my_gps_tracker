package com.example.gpstracking;

import android.app.Application;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {
    private static  MyApplication singleton;

    public List<Location> getMyLocations() {
        return myLocations;
    }
    public List<LatLng> getMyLocationsLatLng(){
        return myLocationsLatLng;
    }
    public  void  setMyLocationsLatLng(List<LatLng> myLocationsLatLng){
        this.myLocationsLatLng = myLocationsLatLng;
    }

    public void setMyLocations(List<Location> myLocations) {
        this.myLocations = myLocations;
    }

    private List<Location> myLocations;
    private List<LatLng> myLocationsLatLng;
    public MyApplication getInstance(){
        return singleton;
    }

    public void onCreate() {

        super.onCreate();
        singleton = this;
        myLocations = new ArrayList<>();
        myLocationsLatLng = new ArrayList<>();
    }
}

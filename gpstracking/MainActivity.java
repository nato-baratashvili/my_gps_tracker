package com.example.gpstracking;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.app.ActivityCompat;

import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    public static final int DEFAULT_UPDATE_INTERVAL = 30;
    public static final int FASTEST_UPDATE_INTERVAL = 5;
    private static final int PERMISSIONS_FINE_LOCATION = 2002;
    TextView tv_lat, tv_lon, tv_altitude, tv_accuracy,
            tv_speed, tv_sensor, tv_updates, tv_address , tv_wayPointCounts;
    Switch sw_locationsUpdates, sw_gps;
    Button btn_newWaypoint, btn_addLocations , btn_bluetooth , btn_showMap;
    // Google's API for location services.
    FusedLocationProviderClient fusedLocationProviderClient;
    //location request
    LocationRequest locationRequest;
    LocationCallback locationCallBack;
    static final UUID mUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    Location currentLocation;
    List<Location> savedLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();


        // give UI variable value
        tv_lat = findViewById(R.id.tv_lat);
        tv_lon = findViewById(R.id.tv_lon);
        tv_speed = findViewById(R.id.tv_speed);
        tv_altitude = findViewById(R.id.tv_altitude);
        tv_accuracy = findViewById(R.id.tv_accuracy);
        tv_sensor = findViewById(R.id.tv_sensor);
        tv_updates = findViewById(R.id.tv_updates);
        tv_address = findViewById(R.id.tv_address);
        sw_gps = findViewById(R.id.sw_gps);
        sw_locationsUpdates = findViewById(R.id.sw_locationsupdates);
        tv_wayPointCounts = findViewById(R.id.tv_labelCountOfCrumbs);
        btn_newWaypoint = findViewById(R.id.btn_newWaypoint);
        btn_addLocations = findViewById(R.id.btn_addLocation);

        btn_showMap = findViewById(R.id.btn_showMap);


        btn_showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this ,MapsActivity.class );
                        startActivity(i);
            }
        });
        // set all properties of location request
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(1000 * DEFAULT_UPDATE_INTERVAL);
        locationRequest.setFastestInterval(1000 * FASTEST_UPDATE_INTERVAL);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        locationCallBack = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {

                // save location
                Location loc = locationResult.getLastLocation();
                updateUIValues(loc);
            }
        };
        sw_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw_gps.isChecked()) {
                    //most accurate
                    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                    tv_sensor.setText("GPS სერვისი");
                } else {
                    locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    tv_sensor.setText("ტელეფონის ანძა + Wifi");
                }
            }
        });

        sw_locationsUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw_locationsUpdates.isChecked()) {
                    // we want to turn on tracking
                    startLocationUpdates();
                } else {
                    // stop tracking
                    stopLocationUpdates();
                }
            }
        });
        btn_newWaypoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // get location and add global list
            MyApplication myApplication = (MyApplication) getApplicationContext();
            savedLocation = myApplication.getMyLocations();
            savedLocation.add(currentLocation);
                Intent i = new Intent(MainActivity.this , MapsActivity.class);
                startActivity(i);
            }
        });
        btn_addLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , addLocations.class);
                startActivity(i);
            }
        });
        updateGPs();
    }




    private void stopLocationUpdates() {
        tv_updates.setText("მეთვალყურეობა არ მიმდინარეობს");
        tv_lat.setText("მეთვალყურეობა არ მიმდინარეობს");
        tv_lon.setText("მეთვალყურეობა არ მიმდინარეობს");
        tv_address.setText("მეთვალყურეობა არ მიმდინარეობს");
        tv_speed.setText("მეთვალყურეობა არ მიმდინარეობს");
        tv_altitude.setText("მეთვალყურეობა არ მიმდინარეობს");
        tv_accuracy.setText("მეთვალყურეობა არ მიმდინარეობს");
        tv_sensor.setText("მეთვალყურეობა არ მიმდინარეობს");
        fusedLocationProviderClient.removeLocationUpdates(locationCallBack);
    }

    private void startLocationUpdates() {
        tv_updates.setText("მიმდინარეობს ადგილმდებარეობაზე მეთვალყურეობა");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallBack, null);
        updateGPs();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSIONS_FINE_LOCATION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    updateGPs();
                } else {
                    Toast.makeText(this, "ამ აპლიკაციას სჭირდება ნებართვა ადგილმდებარეობის მეთვალყურეობისთვის", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    private void updateGPs(){
        // get permissions from user to track
        //get the current location from the fused client
        // update UI
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){

            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    // we got permissions, update UI
                    updateUIValues(location);
                    currentLocation = location;
                }
            });
        } else {
            // ask for permission
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String [] { Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
            }
        }

    }

    private void updateUIValues(Location location) {
        tv_lat.setText(String.valueOf(location.getLatitude()));
        tv_lon.setText(String.valueOf(location.getLongitude()));
        tv_accuracy.setText(String.valueOf(location.getAccuracy()));
        if(location.hasAltitude()){
            tv_altitude.setText(String.valueOf(location.getAltitude()));
        } else {
            tv_altitude.setText("არ არის ხელმისაწვდომი");
        }
        if(location.hasSpeed()){
            tv_altitude.setText("არ არის ხელმისაწვდომი");
        } else {
            tv_speed.setText("არ არის ხელმისაწვდომი");
        }

        Geocoder geocoder = new Geocoder(MainActivity.this);
        try {
            // most recently seen addresses
            List<Address> addressList = geocoder.getFromLocation(location.getLatitude() , location.getLongitude() , 1);
            tv_address.setText(addressList.get(0).getAddressLine(0));
        }
        catch ( Exception e){
            tv_address.setText("ქუჩა ვერ მოიძებნა");
        }

        MyApplication myApplication = (MyApplication) getApplicationContext();
        savedLocation = myApplication.getMyLocations();
        tv_wayPointCounts.setText(Integer.toString(savedLocation.size()));

    }


}
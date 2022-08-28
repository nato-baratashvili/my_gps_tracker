package com.example.gpstracking;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.model.LatLng;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class addLocations extends AppCompatActivity {
    List<Location> savedLocations;
    List<LatLng> savedLocationsLatLng;
    LatLng locationLatLng;
    Button btn_add;
    EditText eT_Long, eT_lat;
    TextView tv_long, tv_lati;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_locations);
        btn_add = findViewById(R.id.btn_add);
        eT_lat = findViewById(R.id.eT_Lat);
        eT_Long = findViewById(R.id.eT_Long);
        tv_lati = findViewById(R.id.tv_lati);
        tv_long = findViewById(R.id.tv_long);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               fetchData2();
               fetchData();

                String lat = String.valueOf(eT_lat.getText());
                String longitude = String.valueOf(eT_Long.getText());
               if(!lat.equals("") && !longitude.equals("")){
                   Double latInt = Double.valueOf(String.valueOf(eT_lat.getText()));
                   Double longitudeInt = Double.valueOf(String.valueOf(eT_Long.getText()));

                   locationLatLng = new LatLng(latInt , longitudeInt);
                   MyApplication myApplication = (MyApplication) getApplicationContext();
                   savedLocationsLatLng = myApplication.getMyLocationsLatLng();
                   savedLocationsLatLng.add(locationLatLng);
                   eT_lat.setText("");
                   eT_Long.setText("");
                   showToast("მდებარეობა დაემტა");
                //   fetchData();
                   startActivity(new Intent(addLocations.this , MapsActivity.class));
               } else {
                   showToast("შეიყვანეთ გრძედი და განედი");
               }

            }
        });
    }
    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void fetchData(){
        String URL = "https://api.thingspeak.com/channels/1774137/fields/1.json?api_key=PB6YS2Y7019C7KMN&results=1";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Res: ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("feeds");
                    if(jsonArray.length() > 0){
                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String latitude = jsonObject1.getString("field1");
                            if(latitude != null)
                          //  showToast(latitude);
                            eT_lat.setText(latitude);
                        }


                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void fetchData2(){
        String URL = "https://api.thingspeak.com/channels/1774137/fields/2.json?api_key=PB6YS2Y7019C7KMN&results=1";
         String[] result = {""};
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void  onResponse(String response) {
                Log.e("Res: ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("feeds");
                    if(jsonArray.length() > 0){
                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String longitude = jsonObject1.getString("field2");
                           result[0] = longitude;
                                eT_Long.setText(longitude);
                             //   showToast(longitude);
                        }

                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

}
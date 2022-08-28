// Generated by view binder compiler. Do not edit!
package com.example.gpstracking.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gpstracking.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnAddLocation;

  @NonNull
  public final Button btnNewWaypoint;

  @NonNull
  public final Button btnShowMap;

  @NonNull
  public final View divider;

  @NonNull
  public final Switch swGps;

  @NonNull
  public final Switch swLocationsupdates;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView tvAccuracy;

  @NonNull
  public final TextView tvAddress;

  @NonNull
  public final TextView tvAltitude;

  @NonNull
  public final TextView tvLabelCountOfCrumbs;

  @NonNull
  public final TextView tvLabelCrumbWaypoints;

  @NonNull
  public final TextView tvLabelaccuracy;

  @NonNull
  public final TextView tvLabelaltitude;

  @NonNull
  public final TextView tvLabellat;

  @NonNull
  public final TextView tvLabellon;

  @NonNull
  public final TextView tvLabelsensor;

  @NonNull
  public final TextView tvLabelspeed;

  @NonNull
  public final TextView tvLabelupdates;

  @NonNull
  public final TextView tvLat;

  @NonNull
  public final TextView tvLbladdress;

  @NonNull
  public final TextView tvLon;

  @NonNull
  public final TextView tvSensor;

  @NonNull
  public final TextView tvSpeed;

  @NonNull
  public final TextView tvUpdates;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnAddLocation,
      @NonNull Button btnNewWaypoint, @NonNull Button btnShowMap, @NonNull View divider,
      @NonNull Switch swGps, @NonNull Switch swLocationsupdates, @NonNull Toolbar toolbar,
      @NonNull TextView tvAccuracy, @NonNull TextView tvAddress, @NonNull TextView tvAltitude,
      @NonNull TextView tvLabelCountOfCrumbs, @NonNull TextView tvLabelCrumbWaypoints,
      @NonNull TextView tvLabelaccuracy, @NonNull TextView tvLabelaltitude,
      @NonNull TextView tvLabellat, @NonNull TextView tvLabellon, @NonNull TextView tvLabelsensor,
      @NonNull TextView tvLabelspeed, @NonNull TextView tvLabelupdates, @NonNull TextView tvLat,
      @NonNull TextView tvLbladdress, @NonNull TextView tvLon, @NonNull TextView tvSensor,
      @NonNull TextView tvSpeed, @NonNull TextView tvUpdates) {
    this.rootView = rootView;
    this.btnAddLocation = btnAddLocation;
    this.btnNewWaypoint = btnNewWaypoint;
    this.btnShowMap = btnShowMap;
    this.divider = divider;
    this.swGps = swGps;
    this.swLocationsupdates = swLocationsupdates;
    this.toolbar = toolbar;
    this.tvAccuracy = tvAccuracy;
    this.tvAddress = tvAddress;
    this.tvAltitude = tvAltitude;
    this.tvLabelCountOfCrumbs = tvLabelCountOfCrumbs;
    this.tvLabelCrumbWaypoints = tvLabelCrumbWaypoints;
    this.tvLabelaccuracy = tvLabelaccuracy;
    this.tvLabelaltitude = tvLabelaltitude;
    this.tvLabellat = tvLabellat;
    this.tvLabellon = tvLabellon;
    this.tvLabelsensor = tvLabelsensor;
    this.tvLabelspeed = tvLabelspeed;
    this.tvLabelupdates = tvLabelupdates;
    this.tvLat = tvLat;
    this.tvLbladdress = tvLbladdress;
    this.tvLon = tvLon;
    this.tvSensor = tvSensor;
    this.tvSpeed = tvSpeed;
    this.tvUpdates = tvUpdates;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_addLocation;
      Button btnAddLocation = ViewBindings.findChildViewById(rootView, id);
      if (btnAddLocation == null) {
        break missingId;
      }

      id = R.id.btn_newWaypoint;
      Button btnNewWaypoint = ViewBindings.findChildViewById(rootView, id);
      if (btnNewWaypoint == null) {
        break missingId;
      }

      id = R.id.btn_showMap;
      Button btnShowMap = ViewBindings.findChildViewById(rootView, id);
      if (btnShowMap == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.sw_gps;
      Switch swGps = ViewBindings.findChildViewById(rootView, id);
      if (swGps == null) {
        break missingId;
      }

      id = R.id.sw_locationsupdates;
      Switch swLocationsupdates = ViewBindings.findChildViewById(rootView, id);
      if (swLocationsupdates == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tv_accuracy;
      TextView tvAccuracy = ViewBindings.findChildViewById(rootView, id);
      if (tvAccuracy == null) {
        break missingId;
      }

      id = R.id.tv_address;
      TextView tvAddress = ViewBindings.findChildViewById(rootView, id);
      if (tvAddress == null) {
        break missingId;
      }

      id = R.id.tv_altitude;
      TextView tvAltitude = ViewBindings.findChildViewById(rootView, id);
      if (tvAltitude == null) {
        break missingId;
      }

      id = R.id.tv_labelCountOfCrumbs;
      TextView tvLabelCountOfCrumbs = ViewBindings.findChildViewById(rootView, id);
      if (tvLabelCountOfCrumbs == null) {
        break missingId;
      }

      id = R.id.tv_labelCrumbWaypoints;
      TextView tvLabelCrumbWaypoints = ViewBindings.findChildViewById(rootView, id);
      if (tvLabelCrumbWaypoints == null) {
        break missingId;
      }

      id = R.id.tv_labelaccuracy;
      TextView tvLabelaccuracy = ViewBindings.findChildViewById(rootView, id);
      if (tvLabelaccuracy == null) {
        break missingId;
      }

      id = R.id.tv_labelaltitude;
      TextView tvLabelaltitude = ViewBindings.findChildViewById(rootView, id);
      if (tvLabelaltitude == null) {
        break missingId;
      }

      id = R.id.tv_labellat;
      TextView tvLabellat = ViewBindings.findChildViewById(rootView, id);
      if (tvLabellat == null) {
        break missingId;
      }

      id = R.id.tv_labellon;
      TextView tvLabellon = ViewBindings.findChildViewById(rootView, id);
      if (tvLabellon == null) {
        break missingId;
      }

      id = R.id.tv_labelsensor;
      TextView tvLabelsensor = ViewBindings.findChildViewById(rootView, id);
      if (tvLabelsensor == null) {
        break missingId;
      }

      id = R.id.tv_labelspeed;
      TextView tvLabelspeed = ViewBindings.findChildViewById(rootView, id);
      if (tvLabelspeed == null) {
        break missingId;
      }

      id = R.id.tv_labelupdates;
      TextView tvLabelupdates = ViewBindings.findChildViewById(rootView, id);
      if (tvLabelupdates == null) {
        break missingId;
      }

      id = R.id.tv_lat;
      TextView tvLat = ViewBindings.findChildViewById(rootView, id);
      if (tvLat == null) {
        break missingId;
      }

      id = R.id.tv_lbladdress;
      TextView tvLbladdress = ViewBindings.findChildViewById(rootView, id);
      if (tvLbladdress == null) {
        break missingId;
      }

      id = R.id.tv_lon;
      TextView tvLon = ViewBindings.findChildViewById(rootView, id);
      if (tvLon == null) {
        break missingId;
      }

      id = R.id.tv_sensor;
      TextView tvSensor = ViewBindings.findChildViewById(rootView, id);
      if (tvSensor == null) {
        break missingId;
      }

      id = R.id.tv_speed;
      TextView tvSpeed = ViewBindings.findChildViewById(rootView, id);
      if (tvSpeed == null) {
        break missingId;
      }

      id = R.id.tv_updates;
      TextView tvUpdates = ViewBindings.findChildViewById(rootView, id);
      if (tvUpdates == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, btnAddLocation, btnNewWaypoint,
          btnShowMap, divider, swGps, swLocationsupdates, toolbar, tvAccuracy, tvAddress,
          tvAltitude, tvLabelCountOfCrumbs, tvLabelCrumbWaypoints, tvLabelaccuracy, tvLabelaltitude,
          tvLabellat, tvLabellon, tvLabelsensor, tvLabelspeed, tvLabelupdates, tvLat, tvLbladdress,
          tvLon, tvSensor, tvSpeed, tvUpdates);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

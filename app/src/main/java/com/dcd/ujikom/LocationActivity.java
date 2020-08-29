package com.dcd.ujikom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity implements LocationListener {

    protected LocationManager locationManager;
    TextView tvLat,tvLong,tvAlt;
    ProgressBar pgbar;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        tvLat = findViewById(R.id.tv1);
        tvLong = findViewById(R.id.tv2);
        tvAlt = findViewById(R.id.tv3);
        pgbar = findViewById(R.id.pgbar);
        pgbar.setVisibility(View.VISIBLE);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        tvLat =  findViewById(R.id.tv1);
        pgbar.setVisibility(View.GONE);
        tvLat.setText("Latitude:" + location.getLatitude());
        tvLong.setText("Longitude:" + location.getLongitude());
        tvAlt.setText("Altitude:" + location.getAltitude());
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude", "disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude", "enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }
}

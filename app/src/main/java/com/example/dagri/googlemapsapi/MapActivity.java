package com.example.dagri.googlemapsapi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_layout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        // mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        // mMap.setMapType(GoogleMap.MAP_TYPE_NONE);

        // KOMPASS EINSCHALTEN
        mMap.getUiSettings().setCompassEnabled(true);
        // ZOOM KONTROLLEN EINSCHALTEN
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // INDOOR LEVEL LEISTE EINSCHALTEN
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        // MAP TOOLBAR EINSCHALTEN
        mMap.getUiSettings().setMapToolbarEnabled(true);
        // MEINE POSITION BUTTON EINSCHALTEN
        // https://developers.google.com/maps/documentation/android-api/location#laufzeitberechtigungen_anfordern
        mMap.getUiSettings().setMyLocationButtonEnabled(true);


    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }
}

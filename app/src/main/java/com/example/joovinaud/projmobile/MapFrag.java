package com.example.joovinaud.projmobile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import dataprovider.AcademiaDAOMock;
import dataprovider.IAcademiaDAO;
import dataprovider.IUserDAO;
import domain.Academia;

import static android.content.Context.LOCATION_SERVICE;


public class MapFrag extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    MapView mMapView;
    private GoogleMap googleMap;
   private IAcademiaDAO lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate and return the layout
        View v = inflater.inflate(R.layout.fragment_map, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        mMapView.getMapAsync(this);

        lista = new AcademiaDAOMock();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // latitude and longitude
        double latitude = -5.8448481;
        double longitude = -35.2079709;

        //user location
        MarkerOptions userMarker = new MarkerOptions().position(getLocation()).title("Você").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        userMarker.title("Você");

        // adding markers

        populateMap(googleMap);
        googleMap.addMarker(userMarker);

        // Perform any camera updates here
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
    }

    public LatLng getLocation() {
        // Get the location manager
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        Location location = locationManager.getLastKnownLocation(locationProvider);

            Double lat,lon;
            try {
                lat = location.getLatitude();
                lon = location.getLongitude();
                return new LatLng(lat, lon);
            }
            catch (NullPointerException e){
                e.printStackTrace();
                return null;
            }



    }

    public void populateMap(GoogleMap googleMap)
    {


        googleMap.setOnInfoWindowClickListener(this);

        for(Academia temp : lista.getAcademias())
        {
            MarkerOptions marker = new MarkerOptions().position(new LatLng(temp.getLat(), temp.getLon())).title(temp.getTitle());
            // Changing marker icon
            marker.icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
            marker.snippet(temp.getDesc());

            googleMap.addMarker(marker);
        }
    }



    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent i = new Intent(this.getContext(),AcademiaActivity.class);
        i.putExtra("Nome",marker.getTitle().toString());
        startActivity(i);

    }
}
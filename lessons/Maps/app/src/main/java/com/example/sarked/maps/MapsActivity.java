package com.example.sarked.maps;

import android.graphics.Color;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng - объект хранит географические координаты
        LatLng sydney = new LatLng(-34, 151);
        LatLng brisben = new LatLng(-27, 153);
        LatLng melburn = new LatLng(-37, 144);
        LatLng adelaida = new LatLng(-34, 138);
        LatLng makkay = new LatLng(-21, 149);

        Circle c = mMap.addCircle(new CircleOptions().center(sydney).radius(400).fillColor(Color.CYAN));
        Polyline p = mMap.addPolyline(new PolylineOptions().add(sydney).add(brisben).add(melburn).add(adelaida).add(makkay).geodesic(true));
        //Polygon pgn = mMap.addPolygon(new PolygonOptions());


        Marker m1=mMap.addMarker(new MarkerOptions().position(sydney).title("Cидней").draggable(true));
        Marker m2=mMap.addMarker(new MarkerOptions().position(brisben).title("Брисбен"));
        Marker m3=mMap.addMarker(new MarkerOptions().position(melburn).title("Мельбурн"));
        Marker m4=mMap.addMarker(new MarkerOptions().position(adelaida).title("Аделаида"));
        Marker m5=mMap.addMarker(new MarkerOptions().position(makkay).title("Маккай"));
        final HashMap<String,String>pts=new HashMap<>();
        pts.put(m1.getId(),"город Cидней");
        pts.put(m2.getId(),"славный град Брисбен");
        pts.put(m3.getId(),"Мельбурн-сити");
        pts.put(m4.getId(),"город Аделаида");
        pts.put(m5.getId(),"=*=Маккай=*=");

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(adelaida));

        LatLng targetCamera = googleMap.getCameraPosition().target;

        //расстояние между объектами, результат записывает в пятый аргумент, первые два - координаты первой точки, вторые - второй точки
        //массив заранее инициировать и предать туда, туда и запишется
        //Location.distanceBetween(double,double,double,double,float[]);

        //встроенная в модлуь гугл, надо подключить в build.gradle(module)
        //compile 'com.google.maps.android:android-maps-utils:0.4+'
        SphericalUtil.computeDistanceBetween(sydney,adelaida);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                showToClick(latLng.latitude,latLng.longitude);
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getApplicationContext(),pts.get(marker.getId()),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    void showToClick(double a, double b){
        Toast.makeText(this,a+" "+b,Toast.LENGTH_SHORT).show();
    }
}

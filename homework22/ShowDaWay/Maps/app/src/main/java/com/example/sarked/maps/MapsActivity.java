package com.example.sarked.maps;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
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

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnCameraIdleListener {

    private GoogleMap mMap;
    TextView text;
    TextView target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        text=(TextView)findViewById(R.id.text);
        target=(TextView)findViewById(R.id.target);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnCameraIdleListener(this);

        LatLng minsk = new LatLng(53.9, 27.56);
        final ArrayList<LatLng> list = new ArrayList<>();

        final Polyline[] p = {mMap.addPolyline(new PolylineOptions().addAll(list).geodesic(true))};

        mMap.moveCamera(CameraUpdateFactory.newLatLng(minsk));
        mMap.setMinZoomPreference(6.0f);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                LatLng coord = new LatLng(latLng.latitude, latLng.longitude);
                list.add(coord);
                Marker mark=mMap.addMarker(new MarkerOptions().position(coord).title(list.size()+""));

                System.out.println("Добавили метку "+list.size()+" с id "+mark.getId());
                p[0] =mMap.addPolyline(new PolylineOptions().addAll(list).geodesic(true));

                Double a = SphericalUtil.computeLength(list)/1000;
                text.setText("Меток: "+list.size()+", путь: "+String.format("%(.2f", a)+" км.");
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                int del=Integer.valueOf(marker.getTitle())-1;
                System.out.println("Удаляем метку "+getTitle());
                System.out.println("Del метки "+del);
                mMap.clear();
                marker.remove();
                list.remove(del);
                while (list.size()!=del){
                    list.remove(del);
                }
                int id=0;
                while (id!=list.size()){
                    mMap.addMarker(new MarkerOptions().position(list.get(id)).title((id+1)+""));
                    id=id+1;
                }
                mMap.addPolyline(new PolylineOptions().addAll(list).geodesic(true));
                Double a = SphericalUtil.computeLength(list)/1000;
                text.setText("Меток: "+list.size()+", путь: "+String.format("%(.2f", a)+" км.");

                return false;
            }
        });
    }

    @Override
    public void onCameraIdle() {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;
        LatLng targetCamera = mMap.getCameraPosition().target;
        try {
            addresses =  geocoder.getFromLocation(targetCamera.latitude, targetCamera.longitude,1);
            if(addresses.size()!=0){
                target.setText(addresses.get(0).getAddressLine(0));
            } else {
                target.setText("Где мы?");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Сорян, ошибка в определении адреса",Toast.LENGTH_SHORT).show();
        }
    }
}

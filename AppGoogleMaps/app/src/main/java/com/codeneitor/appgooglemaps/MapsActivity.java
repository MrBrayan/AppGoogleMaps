package com.codeneitor.appgooglemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng VILLAVICENCIO = new LatLng(-33.88,151.21);

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
        // Creamos un ArrayList que contiene una lista de objetos del tipo Ubicación
        // el cual en nuestro modelo de datos que contiene los parámetros
        // para agregar un marker.
        ArrayList<Ubicacion> ubicaciones = new ArrayList<>();
        ubicaciones.add(new Ubicacion("Primavera", 4.134508, -73.640015));
        ubicaciones.add(new Ubicacion("Unicentro", 4.141970, -73.634114));
        ubicaciones.add(new Ubicacion("Villacentro",4.133428, -73.637609));
        ubicaciones.add(new Ubicacion("Llanocentro", 4.134601, -73.637057));

        Bundle param = getIntent().getExtras();
        int lugar = param.getInt("lugar");
        mostrarUbicacion(ubicaciones.get(lugar));
    }

    public void mostrarUbicacion(Ubicacion ubicacion){
        LatLng lugarMapa = new LatLng(ubicacion.getLat(), ubicacion.getLang());
        // Documentacion consultada para agregar el marker:
        // https://developers.google.com/maps/documentation/android-sdk/marker#customize_the_marker_image
        mMap.addMarker(new MarkerOptions()
                .position(lugarMapa)
                .title(ubicacion.getNombre())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
        );
        //Documentación consultada para este ejercicio:
        // https://developers.google.com/maps/documentation/android-sdk/views

        // Move the camera instantly to Sydney with a zoom of 15.
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubiciacion, 15));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(VILLAVICENCIO, 15));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        // Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(lugarMapa)      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

}

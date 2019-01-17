package com.codeneitor.appgooglemaps;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by b41n on 16/01/19.
 */

public class Ubicacion {
    private String nombre;
    private double lat;
    private double lang;

    public Ubicacion(String nombre, double lat, double lang) {
        this.nombre = nombre;
        this.lat = lat;
        this.lang = lang;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }
}

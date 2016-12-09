package com.example.jimmyhernandez.tabletvendedor.models;

import java.util.ArrayList;

/**
 * Created by root on 08-12-16.
 */

public class Dispositivo
{
    private String nombre;

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getOrientacion()
    {
        return orientacion;
    }

    public void setOrientacion(String orientacion)
    {
        this.orientacion = orientacion;
    }

    public ArrayList<Equipos> getDispositivos()
    {
        return dispositivos;
    }

    public void setDispositivos(ArrayList<Equipos> dispositivos)
    {
        this.dispositivos = dispositivos;
    }

    public ArrayList<String> getVideos()
    {
        return videos;
    }

    public void setVideos(ArrayList<String> videos)
    {
        this.videos = videos;
    }

    private String orientacion;
    private ArrayList<Equipos> dispositivos;
    private ArrayList<String> videos;

}

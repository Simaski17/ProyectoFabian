package com.example.jimmyhernandez.tabletvendedor.models;

/**
 * Created by root on 08-12-16.
 */

public class Equipos
{
    private String id;
    private String nombre;
    private String ip;

    public Equipos getParent()
    {
        return parent;
    }

    public void setParent(Equipos parent)
    {
        this.parent = parent;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    private Equipos parent;


}

package com.example.jimmyhernandez.tabletvendedor.models;

import java.util.ArrayList;

/**
 * Created by root on 08-12-16.
 */

public class Elemento
{
    private String id;
    private String nombre;
    private ArrayList<Atributo> listaatributos;

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

    public ArrayList<Atributo> getListaatributos()
    {
        return listaatributos;
    }

    public void setListaatributos(ArrayList<Atributo> listaatributos)
    {
        this.listaatributos = listaatributos;
    }

    public ArrayList<Elemento> getListarelacion()
    {
        return listarelacion;
    }

    public void setListarelacion(ArrayList<Elemento> listarelacion)
    {
        this.listarelacion = listarelacion;
    }

    public ArrayList<Atributo> getPrecios()
    {
        return precios;
    }

    public void setPrecios(ArrayList<Atributo> precios)
    {
        this.precios = precios;
    }

    public ArrayList<Atributo> getHighlight()
    {
        return highlight;
    }

    public void setHighlight(ArrayList<Atributo> highlight)
    {
        this.highlight = highlight;
    }

    private ArrayList<Elemento> listarelacion;
    private ArrayList<Atributo> precios;
    private ArrayList<Atributo> highlight;
}

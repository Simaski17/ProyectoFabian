package com.example.jimmyhernandez.tabletvendedor.models;

import java.util.ArrayList;


public class OutObject
{
    private Elemento detallesegmento;
    private ArrayList<Elemento> listaproductos;
    private ArrayList<Elemento> listacategorias;
    private ArrayList<Dispositivo> grupos;
    private ArrayList<Dispositivo> listadestacados;
    private ArrayList<String> descargas;

    public Elemento getDetallesegmento()
    {
        return detallesegmento;
    }

    public void setDetallesegmento(Elemento detallesegmento)
    {
        this.detallesegmento = detallesegmento;
    }

    public ArrayList<Elemento> getListaproductos()
    {
        return listaproductos;
    }

    public void setListaproductos(ArrayList<Elemento> listaproductos)
    {
        this.listaproductos = listaproductos;
    }

    public ArrayList<Elemento> getListacategorias()
    {
        return listacategorias;
    }

    public void setListacategorias(ArrayList<Elemento> listacategorias)
    {
        this.listacategorias = listacategorias;
    }

    public ArrayList<Dispositivo> getGrupos()
    {
        return grupos;
    }

    public void setGrupos(ArrayList<Dispositivo> grupos)
    {
        this.grupos = grupos;
    }

    public ArrayList<Dispositivo> getListadestacados()
    {
        return listadestacados;
    }

    public void setListadestacados(ArrayList<Dispositivo> listadestacados)
    {
        this.listadestacados = listadestacados;
    }

    public ArrayList<String> getDescargas()
    {
        return descargas;
    }

    public void setDescargas(ArrayList<String> descargas)
    {
        this.descargas = descargas;
    }
}

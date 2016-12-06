package com.example.jimmyhernandez.tabletvendedor;

/**
 * Created by simaski on 06/12/16.
 */

public class ItemCatalogoEquipos {

    private String nombre;
    private String tipo;
    private int photoId;

    public ItemCatalogoEquipos() {
    }

    public ItemCatalogoEquipos(int photoId, String nombre, String tipo) {
        this.photoId = photoId;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

}
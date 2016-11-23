package com.example.jimmyhernandez.tabletvendedor;

/**
 * Created by simaski on 23/11/16.
 */

public class ItemEquipos {
    private String marca;
    private String nombre;
    private int photoId;

    public ItemEquipos() {
    }

    public ItemEquipos(int photoId,String marca, String nombre) {
        this.photoId = photoId;
        this.marca = marca;
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}

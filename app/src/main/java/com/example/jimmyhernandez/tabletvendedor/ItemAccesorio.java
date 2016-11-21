package com.example.jimmyhernandez.tabletvendedor;

/**
 * Created by simaski on 21/11/16.
 */

public class ItemAccesorio  {

    private String nombre;
    private String descripcion;
    private int photoId;

    public ItemAccesorio() {
    }

    public ItemAccesorio(int photoId,String nombre, String descripcion) {
        this.photoId = photoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
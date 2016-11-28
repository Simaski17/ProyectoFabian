package com.example.jimmyhernandez.tabletvendedor;

/**
 * Created by simaski on 24/11/16.
 */

public class Recordar  {
    private String mensaje;

    public Recordar(String mensaje) {
        this.mensaje = mensaje;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
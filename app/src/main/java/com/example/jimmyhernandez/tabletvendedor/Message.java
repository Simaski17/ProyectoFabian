package com.example.jimmyhernandez.tabletvendedor;

/**
 * Created by simaski on 22/11/16.
 */

public class Message  {
    private String idGrupo;
    private String idPantalla;
    private String server;
    private String cast;

    public Message(String idGrupo, String idPantalla, String server, String cast) {
        this.idGrupo = idGrupo;
        this.idPantalla = idPantalla;
        this.server = server;
        this.cast = cast;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getIdPantalla() {
        return idPantalla;
    }

    public void setIdPantalla(String idPantalla) {
        this.idPantalla = idPantalla;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }


}
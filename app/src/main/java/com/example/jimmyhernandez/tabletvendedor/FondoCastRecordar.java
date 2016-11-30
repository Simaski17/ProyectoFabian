package com.example.jimmyhernandez.tabletvendedor;

/**
 * Created by simaski on 30/11/16.
 */

public class FondoCastRecordar {

    private String idGrupo;
    private String idPantalla;
    private String server;

    public FondoCastRecordar(String idGrupo, String idPantalla, String server) {
        this.idGrupo = idGrupo;
        this.idPantalla = idPantalla;
        this.server = server;
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
}

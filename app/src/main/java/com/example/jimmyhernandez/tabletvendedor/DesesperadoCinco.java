package com.example.jimmyhernandez.tabletvendedor;

/**
 * Created by simaski on 11/12/2016.
 */

public class DesesperadoCinco {

    private String server;
    private int port;
    private String message;

    public DesesperadoCinco(String server, int port, String message) {
        this.server = server;
        this.port = port;
        this.message = message;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


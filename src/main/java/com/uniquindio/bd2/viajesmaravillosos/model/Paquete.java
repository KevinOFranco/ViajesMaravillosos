package com.uniquindio.bd2.viajesmaravillosos.model;

public class Paquete {
    private String idPaquete;
    private String idPolitica;

    // Constructor completo
    public Paquete(String idPaquete, String idPolitica) {
        this.idPaquete = idPaquete;
        this.idPolitica = idPolitica;
    }

    // Getters
    public String getIdPaquete() {
        return idPaquete;
    }

    public String getPolitica() {
        return idPolitica;
    }
}
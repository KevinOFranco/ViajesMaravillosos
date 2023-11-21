package com.uniquindio.bd2.viajesmaravillosos.model;

public class Servicio {
    private String idServicioPaquete;
    private String servicio;
    private String idPaquete;

    // Constructor completo
    public Servicio(String idServicioPaquete, String servicio, String idPaquete) {
        this.idServicioPaquete = idServicioPaquete;
        this.servicio = servicio;
        this.idPaquete = idPaquete;
    }

    // Getters
    public String getIdServicioPaquete() {
        return idServicioPaquete;
    }

    public String getServicio() {
        return servicio;
    }

    public String getIdPaquete() {
        return idPaquete;
    }
}

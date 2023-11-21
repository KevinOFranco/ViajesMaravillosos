package com.uniquindio.bd2.viajesmaravillosos.model;

public class Habitacion {

    // Atributos
    private String idHabitacion;
    private boolean estaDisponible;
    private String idHotel;
    private double precioNoche;
    private String tipoHabitacion;

    // Constructor completo (Full Constructor)
    public Habitacion(String idHabitacion, boolean estaDisponible, String idHotel, String tipoHabitacion, double precioNoche) {
        this.idHabitacion = idHabitacion;
        this.estaDisponible = estaDisponible;
        this.idHotel = idHotel;
        this.precioNoche = precioNoche;
        this.tipoHabitacion = tipoHabitacion;
    }

    // Getters
    public String getIdHabitacion() {
        return idHabitacion;
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
}

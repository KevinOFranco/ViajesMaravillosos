package com.uniquindio.bd2.viajesmaravillosos.model;

public class Auto {
    private String codigo;
    private int capacidad;
    private String gama;
    private String Marca;
    private String precio;

    public Auto(String codigo, int capacidad, String gama, String marca, String precio) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.gama = gama;
        Marca = marca;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getGama() {
        return gama;
    }

    public String getMarca() {
        return Marca;
    }

    public String getPrecio() {
        return precio;
    }
}

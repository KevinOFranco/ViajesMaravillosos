package com.uniquindio.bd2.viajesmaravillosos.model;

public class Articulo {

    // Atributos
    private String codigo;
    private String nombre;
    private double precio;

    // Constructor completo (Full Constructor)
    public Articulo(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

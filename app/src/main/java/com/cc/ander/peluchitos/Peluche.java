package com.cc.ander.peluchitos;

public class Peluche {

    private String id,nombre, cantidad, valor;

    public Peluche(String id, String nombre, String cantidad, String valor) {

        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

}

package org.menesestech.appfacturas.modelo;

public class Producto {

    private int codigo;
    private String nombre;
    private float precio;
    private static int ultimocodigo;

    public Producto() {
        this.codigo = ++ultimocodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo + "\t" + nombre + "\t" + precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}

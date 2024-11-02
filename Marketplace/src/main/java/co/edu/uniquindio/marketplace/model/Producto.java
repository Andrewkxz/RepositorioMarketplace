package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.ProductoBuilder;

public class Producto {
    private String nombre;
    private String imagen;
    private double precio;
    private Estado estado;

    public Producto(){
    }

    public Producto(String nombre, String imagen, double precio, Estado estado) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.estado = estado;
    }

    public static ProductoBuilder builder(){
        return new ProductoBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio='" + precio + '\'' +
                ", estado=" + estado +
                '}';
    }
}

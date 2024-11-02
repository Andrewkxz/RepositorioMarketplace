package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Estado;
import co.edu.uniquindio.marketplace.model.Producto;

public class ProductoBuilder {
    protected String nombre;
    protected String imagen;
    protected double precio;
    protected Estado estado;

    public ProductoBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder imagen(String imagen){
        this.imagen = imagen;
        return this;
    }

    public ProductoBuilder precio(double precio){
        this.precio = precio;
        return this;
    }

    public ProductoBuilder estado(Estado estado){
        this.estado = estado;
        return this;
    }

    public Producto build(){
        return new Producto(nombre, imagen, precio, estado);
    }
}

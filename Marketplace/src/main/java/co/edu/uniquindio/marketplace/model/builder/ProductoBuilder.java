package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Estado;
import co.edu.uniquindio.marketplace.model.Producto;

/**
 *
 */
public class ProductoBuilder {
    protected String idProducto;
    protected String nombre;
    protected String imagen;
    protected double precio;
    protected Estado estado;

    /**
     *
     * @param idProducto
     * @return
     */
    public ProductoBuilder idProducto(String idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    /**
     *
     * @param nombre
     * @return
     */
    public ProductoBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    /**
     *
     * @param imagen
     * @return
     */
    public ProductoBuilder imagen(String imagen){
        this.imagen = imagen;
        return this;
    }

    /**
     *
     * @param precio
     * @return
     */
    public ProductoBuilder precio(double precio){
        this.precio = precio;
        return this;
    }

    /**
     *
     * @param estado
     * @return
     */
    public ProductoBuilder estado(Estado estado){
        this.estado = estado;
        return this;
    }

    /**
     *
     * @return
     */
    public Producto build(){
        return new Producto(idProducto, nombre, imagen, precio, estado);
    }
}

package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Estado;
import co.edu.uniquindio.marketplace.model.Producto;

/**
 * Clase ProductoBuilder: Implementa el patrón Builder para crear instancias de la clase Producto.
 * Este patrón permite configurar las propiedades de un Producto de manera flexible y encadenada.
 */
public class ProductoBuilder {

    protected String descripcion;
    protected String nombre;
    protected String imagen;
    protected double precio;
    protected Estado estado;

    /**
     * Establece la descripción del producto.
     * @param descripcion Descripción del producto.
     * @return La instancia actual del builder para encadenar llamadas.
     */
    public ProductoBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre Nombre del producto.
     * @return La instancia actual del builder para encadenar llamadas.
     */
    public ProductoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * Establece la imagen del producto.
     * @param imagen URL o referencia de la imagen del producto.
     * @return La instancia actual del builder para encadenar llamadas.
     */
    public ProductoBuilder imagen(String imagen) {
        this.imagen = imagen;
        return this;
    }

    /**
     * Establece el precio del producto.
     * @param precio Precio del producto.
     * @return La instancia actual del builder para encadenar llamadas.
     */
    public ProductoBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    /**
     * Establece el estado del producto.
     * @param estado Estado del producto (por ejemplo, disponible, agotado, etc.).
     * @return La instancia actual del builder para encadenar llamadas.
     */
    public ProductoBuilder estado(Estado estado) {
        this.estado = estado;
        return this;
    }

    /**
     * Construye una instancia de Producto utilizando los valores configurados.
     * @return Una nueva instancia de Producto.
     */
    public Producto build() {
        return new Producto(descripcion, nombre, imagen, precio, estado);
    }
}
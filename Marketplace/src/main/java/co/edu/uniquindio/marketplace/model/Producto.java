package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.ProductoBuilder;

import java.time.LocalDateTime;

/**
 *
 */
public class Producto {
    private String idProducto;
    private String nombre;
    private String imagen;
    private double precio;
    private Estado estado;
    private LocalDateTime fechaPublicacion;

    /**
     *
     */
    public Producto(){
        this.fechaPublicacion = LocalDateTime.now();
    }

    /**
     *
     * @param idProducto
     * @param nombre
     * @param imagen
     * @param precio
     * @param estado
     */
    public Producto(String idProducto, String nombre, String imagen, double precio, Estado estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.estado = estado != null ? estado : Estado.PUBLICADO;
        this.fechaPublicacion = LocalDateTime.now();
    }

    /**
     *
     * @return
     */
    public static ProductoBuilder builder(){
        return new ProductoBuilder();
    }

    /**
     *
     */
    public void vender(){
        if (this.estado == Estado.PUBLICADO){
            this.estado = Estado.VENDIDO;
        } else {
            throw new IllegalStateException("El producto no está disponible para la venta.");
        }
    }

    /**
     *
     */
    public void cancelar(){
        if (this.estado == Estado.PUBLICADO){
            this.estado = Estado.CANCELADO;
        } else {
            throw new IllegalStateException("El producto no puede ser cancelado en este estado.");
        }
    }
    /**
     *
     * @return
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     *
     * @param idProducto
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getImagen() {
        return imagen;
    }

    /**
     *
     * @param imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */

    public void setPrecio(double precio) {
        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     *
     * @param fechaPublicacion
     */

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        if (fechaPublicacion != null && fechaPublicacion.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("La fecha de publicación no puede estar en el futuro.");
        }
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto='" + idProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}

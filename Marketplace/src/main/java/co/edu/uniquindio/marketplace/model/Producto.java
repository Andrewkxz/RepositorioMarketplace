package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.ProductoBuilder;

import java.time.LocalDateTime;

// Clase que representa un producto en el sistema de un Marketplace
public class Producto {
    private String descripcion;      // Descripción del producto
    private String nombre;           // Nombre del producto
    private String imagen;           // URL o nombre de la imagen del producto
    private double precio;           // Precio del producto
    private Estado estado;           // Estado actual del producto (e.g., publicado, vendido, cancelado)
    private LocalDateTime fechaPublicacion;  // Fecha y hora de la publicación del producto

    /**
     * Constructor por defecto de la clase Producto.
     * Este constructor no hace nada en particular.
     * Debería completarse según la lógica de negocio.
     */
    public Producto(String nombre, String imagen, double precio, Estado estado){
        // Este constructor está vacío, y podría necesitar validaciones o inicialización
    }

    /**
     * Constructor para crear un producto con todos los atributos esenciales.
     *
     * @param descripcion Descripción del producto
     * @param nombre Nombre del producto
     * @param imagen Imagen asociada al producto
     * @param precio Precio del producto
     * @param estado Estado inicial del producto (puede ser PUBLICADO, VENDIDO, CANCELADO)
     */
    public Producto(String descripcion, String nombre, String imagen, double precio, Estado estado) {
        this.descripcion = descripcion;  // Asigna la descripción del producto
        this.nombre = nombre;            // Asigna el nombre del producto
        this.imagen = imagen;            // Asigna la imagen del producto
        this.precio = precio;            // Asigna el precio del producto
        this.estado = estado != null ? estado : Estado.PUBLICADO; // Si no se pasa estado, se asigna PUBLICADO
        this.fechaPublicacion = LocalDateTime.now();  // Establece la fecha de publicación al momento de la creación
    }

    /**
     * Método estático que devuelve un builder para crear un producto de manera más flexible.
     *
     * @return Un objeto ProductoBuilder que permite construir un producto paso a paso.
     */
    public static ProductoBuilder builder(){
        return new ProductoBuilder();  // Devuelve una nueva instancia de ProductoBuilder
    }

    /**
     * Método para cambiar el estado del producto a VENDIDO.
     *
     * @throws IllegalStateException Si el producto no está publicado (no puede venderse si no está publicado)
     */
    public void vender(){
        if (this.estado == Estado.PUBLICADO){
            this.estado = Estado.VENDIDO;  // Cambia el estado a VENDIDO
        } else {
            throw new IllegalStateException("El producto ya no se encuentra publicado");
        }
    }

    /**
     * Método para cambiar el estado del producto a CANCELADO.
     *
     * @throws IllegalStateException Si el producto no está publicado (no puede cancelarse si no está publicado)
     */
    public void cancelar(){
        if (this.estado == Estado.PUBLICADO){
            this.estado = Estado.CANCELADO;  // Cambia el estado a CANCELADO
        } else {
            throw new IllegalStateException("El producto ya no se encuentra publicado");
        }
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto
     */
    public String getDescripcion() {
        return descripcion;  // Devuelve la descripción del producto
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion Nueva descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;  // Asigna la nueva descripción del producto
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto
     */
    public String getNombre() {
        return nombre;  // Devuelve el nombre del producto
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;  // Asigna el nuevo nombre al producto
    }

    /**
     * Obtiene la imagen del producto.
     *
     * @return La imagen del producto
     */
    public String getImagen() {
        return imagen;  // Devuelve la imagen del producto
    }

    /**
     * Establece la imagen del producto.
     *
     * @param imagen Nueva imagen del producto
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;  // Asigna la nueva imagen del producto
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto
     */
    public double getPrecio() {
        return precio;  // Devuelve el precio del producto
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Nuevo precio del producto
     * @throws IllegalArgumentException Si el precio es negativo
     */
    public void setPrecio(double precio) {
        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");  // Valida que el precio no sea negativo
        }
        this.precio = precio;  // Asigna el nuevo precio del producto
    }

    /**
     * Obtiene el estado del producto.
     *
     * @return El estado actual del producto
     */
    public Estado getEstado() {
        return estado;  // Devuelve el estado del producto
    }

    /**
     * Establece el estado del producto.
     *
     * @param estado Nuevo estado del producto
     */
    public void setEstado(Estado estado) {
        this.estado = estado;  // Asigna el nuevo estado al producto
    }

    /**
     * Obtiene la fecha de publicación del producto.
     *
     * @return La fecha de publicación del producto
     */
    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;  // Devuelve la fecha de publicación del producto
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return Una cadena representativa del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';  // Devuelve una representación de todos los atributos del producto
    }
}


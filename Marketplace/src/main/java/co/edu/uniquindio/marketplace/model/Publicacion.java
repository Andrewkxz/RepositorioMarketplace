package co.edu.uniquindio.marketplace.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Clase que representa una publicación de un producto realizada por un vendedor en el marketplace
public class Publicacion {
    private Producto producto;                      // Producto que está siendo publicado
    private Vendedor autor;                         // Vendedor que publica el producto
    private LocalDateTime fechaPublicacion;         // Fecha y hora en la que se publicó
    private int cantidadLikes;                      // Número de "likes" que ha recibido la publicación
    private List<Vendedor> usuariosQueDieronLike;  // Lista de vendedores que dieron "like" a la publicación
    private List<Comentario> comentarios;           // Lista de comentarios asociados a la publicación

    /**
     * Constructor por defecto de la clase Publicacion.
     * Inicializa la publicación con valores predeterminados.
     */
    public Publicacion() {
    }

    /**
     * Constructor para crear una nueva publicación con el producto y el vendedor autor.
     *
     * @param producto El producto que se está publicando
     * @param autor El vendedor que está publicando el producto
     * @throws IllegalArgumentException Si el producto o el autor son nulos
     */
    public Publicacion(Producto producto, Vendedor autor) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto es requerido");
        }
        if (autor == null) {
            throw new IllegalArgumentException("El autor es requerido");
        }
        this.producto = producto;  // Asigna el producto a la publicación
        this.autor = autor;        // Asigna el autor (vendedor) de la publicación
        this.fechaPublicacion = LocalDateTime.now();  // Establece la fecha de publicación al momento actual
        this.cantidadLikes = 0;    // Inicializa el número de "likes" en 0
        this.usuariosQueDieronLike = new ArrayList<>();  // Inicializa la lista de usuarios que dieron "like"
        this.comentarios = new ArrayList<>();            // Inicializa la lista de comentarios
    }

    /**
     * Método para agregar un "like" a la publicación por parte de un vendedor.
     *
     * @param usuario El vendedor que está dando el "like"
     * @throws IllegalArgumentException Si el usuario es nulo
     */
    public void agregarLike(Vendedor usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario es requerido");  // Lanza excepción si el usuario es nulo
        }
        if (!usuariosQueDieronLike.contains(usuario)) {  // Verifica si el vendedor ya ha dado "like"
            usuariosQueDieronLike.add(usuario);           // Si no ha dado "like", lo agrega a la lista
            cantidadLikes++;                               // Incrementa la cantidad de "likes"
        }
    }

    /**
     * Método para agregar un comentario a la publicación.
     *
     * @param comentario El comentario a agregar
     */
    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);  // Agrega el comentario a la lista de comentarios
    }

    /**
     * Obtiene la lista de comentarios de la publicación.
     *
     * @return La lista de comentarios
     */
    public List<Comentario> getComentarios() {
        return comentarios;  // Devuelve la lista de comentarios
    }

    /**
     * Obtiene el producto asociado a la publicación.
     *
     * @return El producto publicado
     */
    public Producto getProducto() {
        return producto;  // Devuelve el producto asociado a la publicación
    }

    /**
     * Establece el producto de la publicación.
     *
     * @param producto El producto a establecer en la publicación
     */
    public void setProducto(Producto producto) {
        this.producto = producto;  // Asigna el nuevo producto a la publicación
    }

    /**
     * Obtiene el vendedor que es el autor de la publicación.
     *
     * @return El autor (vendedor) de la publicación
     */
    public Vendedor getAutor() {
        return autor;  // Devuelve el autor (vendedor) de la publicación
    }

    /**
     * Establece el vendedor que es el autor de la publicación.
     *
     * @param autor El vendedor que es el autor de la publicación
     */
    public void setAutor(Vendedor autor) {
        this.autor = autor;  // Asigna el nuevo autor a la publicación
    }

    /**
     * Obtiene la fecha de publicación de la publicación.
     *
     * @return La fecha de publicación
     */
    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;  // Devuelve la fecha de publicación de la publicación
    }

    /**
     * Establece la fecha de publicación de la publicación.
     *
     * @param fechaPublicacion La fecha de publicación a establecer
     */
    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;  // Asigna la nueva fecha de publicación
    }

    /**
     * Obtiene la cantidad de "likes" que tiene la publicación.
     *
     * @return El número de "likes" de la publicación
     */
    public int getCantidadLikes() {
        return cantidadLikes;  // Devuelve la cantidad de "likes"
    }

    /**
     * Establece la cantidad de "likes" de la publicación.
     *
     * @param cantidadLikes La cantidad de "likes" a establecer
     */
    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;  // Asigna la cantidad de "likes" a la publicación
    }

    /**
     * Obtiene la lista de vendedores que han dado "like" a la publicación.
     *
     * @return La lista de vendedores que dieron "like"
     */
    public List<Vendedor> getUsuariosQueDieronLike() {
        return usuariosQueDieronLike;  // Devuelve la lista de usuarios que dieron "like"
    }

    /**
     * Devuelve una representación en cadena de la publicación.
     *
     * @return Una cadena representativa de la publicación
     */
    @Override
    public String toString() {
        return "Publicacion{" +
                ", producto='" + producto + '\'' +
                ", autor=" + autor +
                ", fechaPublicacion=" + fechaPublicacion +
                ", cantidadLikes=" + cantidadLikes +
                ", usuariosQueDieronLike=" + usuariosQueDieronLike +
                ", comentarios=" + comentarios +
                '}';  // Devuelve una cadena con la información relevante de la publicación
    }
}


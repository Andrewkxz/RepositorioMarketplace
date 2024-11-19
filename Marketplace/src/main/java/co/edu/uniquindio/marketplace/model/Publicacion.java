package co.edu.uniquindio.marketplace.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Publicacion {
    private Producto producto;
    private Vendedor autor;
    private LocalDateTime fechaPublicacion;
    private int cantidadLikes;
    private List<Vendedor> usuariosQueDieronLike;
    private List <Comentario> comentarios;

    /**
     *
     */
    public Publicacion() {
        this.fechaPublicacion = LocalDateTime.now();
        this.cantidadLikes = 0;
        this.usuariosQueDieronLike = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    /**
     *
     * @param producto
     * @param autor
     */
    public Publicacion (Producto producto, Vendedor autor) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        if (autor == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo.");
        }
        this.producto = producto;
        this.autor = autor;
        this.fechaPublicacion = LocalDateTime.now();
        this.cantidadLikes = 0;
        this.usuariosQueDieronLike = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    /**
     *
     * @param usuario
     */
    public void agregarLike(Vendedor usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        if(!usuariosQueDieronLike.contains(usuario)) {
            usuariosQueDieronLike.add(usuario);
            cantidadLikes++;
        }
    }

    /**
     *
     * @param comentario
     */
    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    /**
     *
     * @return
     */
    public List<Comentario> getComentarios() {
        return new ArrayList<> (comentarios);
    }

    /**
     *
     * @return
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     *
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     *
     * @return
     */
    public Vendedor getAutor() {
        return autor;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(Vendedor autor) {
        this.autor = autor;
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
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     *
     * @return
     */
    public int getCantidadLikes() {
        return cantidadLikes;
    }

    /**
     *
     * @param cantidadLikes
     */
    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }

    /**
     *
     * @return
     */
    public List<Vendedor> getUsuariosQueDieronLike() {
        return new ArrayList<>(usuariosQueDieronLike);
    }

    /**
     *
     * @return
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
                '}';
    }
}

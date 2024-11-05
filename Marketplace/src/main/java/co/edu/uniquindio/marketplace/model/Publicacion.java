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
    }

    /**
     *
     * @param producto
     * @param autor
     */
    public Publicacion (Producto producto, Vendedor autor) {
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
        return comentarios;
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
        return usuariosQueDieronLike;
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

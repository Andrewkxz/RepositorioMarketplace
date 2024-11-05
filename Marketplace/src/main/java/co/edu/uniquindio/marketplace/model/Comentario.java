package co.edu.uniquindio.marketplace.model;

import java.time.LocalDateTime;

/**
 *
 */
public class Comentario {
    private int id;
    private String contenido;
    private Vendedor autor;
    private LocalDateTime fechaComentario;

    /**
     *
     */
    public Comentario() {
    }

    /**
     *
     * @param id
     * @param contenido
     * @param autor
     */
    public Comentario(int id, String contenido, Vendedor autor){
        this.id = id;
        this.contenido = contenido;
        this.autor = autor;
        this.fechaComentario = LocalDateTime.now();
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getContenido() {
        return contenido;
    }

    /**
     *
     * @param contenido
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
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
    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    /**
     *
     * @param fechaComentario
     */
    public void setFechaComentario(LocalDateTime fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}

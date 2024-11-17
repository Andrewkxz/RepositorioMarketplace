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
        this.fechaComentario = LocalDateTime.now();
    }

    /**
     *
     * @param id
     * @param contenido
     * @param autor
     */
    public Comentario(int id, String contenido, Vendedor autor){
        if (contenido == null || contenido.isEmpty()){
            throw new IllegalArgumentException("El Contenido del comentario no puede estar vacio.");
        }
        if (autor == null){
            throw new IllegalArgumentException("El Autor del comentario no puede ser nulo.");
        }
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
        if (id < 0){
            throw new IllegalArgumentException("El id no puede ser negativo.");
        }
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
        if(contenido == null || contenido.isEmpty()){
            throw new IllegalArgumentException("El contenido del comentario no puede estar vacio.");
        }
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
        if (autor == null){
            throw new IllegalArgumentException("El Autor del comentario no puede ser nulo.");
        }
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
        if (fechaComentario == null || fechaComentario.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("La fecha del comentario no puede estar en el futuro");
        }
        this.fechaComentario = fechaComentario;
    }
    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                ", autor=" + (autor != null ? autor.getNombres() : "Sin autor") +
                ", fechaComentario=" + fechaComentario + '}';
    }
}

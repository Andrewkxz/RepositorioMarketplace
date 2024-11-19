package co.edu.uniquindio.marketplace.model;

import java.time.LocalDateTime;

/**
 *
 */
public class Comentario {
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
     * @param contenido
     * @param autor
     */
    public Comentario(String contenido, Vendedor autor){
        if (contenido == null || contenido.isEmpty()){
            throw new IllegalArgumentException("El contenido del comentario no puede estar vacío");
        }
        if (autor == null){
            throw new IllegalArgumentException("El autor del comentario es requerido");
        }
        this.contenido = contenido;
        this.autor = autor;
        this.fechaComentario = LocalDateTime.now();
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
        if (contenido == null || contenido.isEmpty()){
            throw new IllegalArgumentException("El contenido del comentario no puede estar vacío");
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
            throw new IllegalArgumentException("El autor del comentario es requerido");
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
            throw new IllegalArgumentException("La fecha del comentario no puede ser posterior a la fecha actual");
        }
        this.fechaComentario = fechaComentario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                ", contenido='" + contenido + '\'' +
                ", autor=" + (autor != null ? autor.getNombres() : "Sin autor") +
                ", fechaComentario=" + fechaComentario +
                '}';
    }
}

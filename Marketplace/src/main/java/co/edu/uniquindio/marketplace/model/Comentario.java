package co.edu.uniquindio.marketplace.model;

import java.time.LocalDateTime;

/**
 * Clase Comentario: Representa un comentario realizado por un vendedor, con un contenido,
 * un autor y una fecha de creación.
 */
public class Comentario {

    private String contenido; // Contenido del comentario
    private Vendedor autor; // Autor del comentario
    private LocalDateTime fechaComentario; // Fecha y hora en que se realizó el comentario

    /**
     * Constructor por defecto. Inicializa un comentario vacío sin configuraciones específicas.
     */
    public Comentario() {
    }

    /**
     * Constructor con parámetros. Inicializa el comentario con un contenido, un autor y establece
     * automáticamente la fecha de creación como la fecha actual.
     *
     * @param contenido El contenido del comentario.
     * @param autor El autor que realizó el comentario.
     * @throws IllegalArgumentException Si el contenido está vacío o el autor es nulo.
     */
    public Comentario(String contenido, Vendedor autor) {
        if (contenido == null || contenido.isEmpty()) {
            throw new IllegalArgumentException("El contenido del comentario no puede estar vacío");
        }
        if (autor == null) {
            throw new IllegalArgumentException("El autor del comentario es requerido");
        }
        this.contenido = contenido;
        this.autor = autor;
        this.fechaComentario = LocalDateTime.now(); // Establece la fecha actual
    }

    /**
     * Obtiene el contenido del comentario.
     *
     * @return El contenido del comentario.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario.
     *
     * @param contenido El nuevo contenido del comentario.
     * @throws IllegalArgumentException Si el contenido está vacío o es nulo.
     */
    public void setContenido(String contenido) {
        if (contenido == null || contenido.isEmpty()) {
            throw new IllegalArgumentException("El contenido del comentario no puede estar vacío");
        }
        this.contenido = contenido;
    }

    /**
     * Obtiene el autor del comentario.
     *
     * @return El autor del comentario.
     */
    public Vendedor getAutor() {
        return autor;
    }

    /**
     * Establece el autor del comentario.
     *
     * @param autor El nuevo autor del comentario.
     * @throws IllegalArgumentException Si el autor es nulo.
     */
    public void setAutor(Vendedor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("El autor del comentario es requerido");
        }
        this.autor = autor;
    }

    /**
     * Obtiene la fecha y hora en que se realizó el comentario.
     *
     * @return La fecha del comentario.
     */
    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    /**
     * Establece la fecha y hora del comentario.
     *
     * @param fechaComentario La nueva fecha y hora del comentario.
     * @throws IllegalArgumentException Si la fecha es nula o posterior a la fecha actual.
     */
    public void setFechaComentario(LocalDateTime fechaComentario) {
        if (fechaComentario == null || fechaComentario.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha del comentario no puede ser posterior a la fecha actual");
        }
        this.fechaComentario = fechaComentario;
    }

    /**
     * Devuelve una representación en forma de cadena del comentario.
     *
     * @return Una cadena que describe el comentario, su contenido, autor y fecha.
     */
    @Override
    public String toString() {
        return "Comentario{" +
                "contenido='" + contenido + '\'' +
                ", autor=" + (autor != null ? autor.getNombres() : "Sin autor") +
                ", fechaComentario=" + fechaComentario +
                '}';
    }
}


package co.edu.uniquindio.marketplace.model;

import java.time.LocalDateTime;

/**
 *
 */
public class Mensaje {
    private String contenido;
    private Vendedor autor;
    private LocalDateTime fechaEnvio;

    /**
     *
     */
    public Mensaje() {
        this.fechaEnvio = LocalDateTime.now();
    }

    /**
     *
     * @param contenido
     * @param autor
     */
    public Mensaje(String contenido, Vendedor autor) {
        if (contenido == null || contenido.isEmpty()) {
            throw new IllegalArgumentException("El contenido del mensaje no puede ser nulo o vacío.");
        }
        if (autor == null) {
            throw new IllegalArgumentException("El autor del mensaje no puede ser nulo.");
        }
        this.contenido = contenido;
        this.autor = autor;
        this.fechaEnvio = LocalDateTime.now();
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
        if (contenido == null || contenido.isEmpty()) {
            throw new IllegalArgumentException("El contenido del mensaje no puede ser nulo.");
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
        if (autor == null) {
            throw new IllegalArgumentException("El autor del mensaje no puede ser nulo.");
        }
        this.autor = autor;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     *
     * @param fechaEnvio
     */
    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        if (fechaEnvio == null || fechaEnvio.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de envío no puede ser nula.");
        }
        this.fechaEnvio = fechaEnvio;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "contenido='" + contenido + '\'' +
                ", autor=" + (autor != null ? autor.getNombres() : "Sin autor") +
                ", fechaEnvio=" + fechaEnvio +
                '}';
    }
}

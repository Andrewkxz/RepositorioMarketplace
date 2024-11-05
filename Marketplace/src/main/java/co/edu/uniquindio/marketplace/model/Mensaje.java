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
    public Mensaje(){
    }

    /**
     *
     * @param contenido
     * @param autor
     */
    public Mensaje(String contenido, Vendedor autor) {
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
    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     *
     * @param fechaEnvio
     */
    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}

package co.edu.uniquindio.marketplace.model;

import java.time.LocalDateTime;

// Clase que representa un mensaje enviado por un vendedor
public class Mensaje {
    private String contenido;  // Contenido del mensaje
    private Vendedor autor;  // Autor (vendedor) que envía el mensaje
    private LocalDateTime fechaEnvio;  // Fecha y hora de envío del mensaje

    public Mensaje(){
    }

    /**
     * Constructor para crear un nuevo mensaje con el contenido y el autor especificado.
     *
     * @param contenido El contenido del mensaje
     * @param autor El autor (vendedor) del mensaje
     * @throws IllegalStateException Si el contenido es nulo o vacío, o si el autor es nulo
     */
    public Mensaje(String contenido, Vendedor autor) {
        // Validaciones de entrada
        if (contenido == null || contenido.isEmpty()){
            throw new IllegalStateException("El contenido del mensaje no puede ser nulo ni vacío");
        }
        if (autor == null){
            throw new IllegalStateException("El autor del mensaje no puede ser nulo");
        }
        this.contenido = contenido;  // Se establece el contenido del mensaje
        this.autor = autor;  // Se establece el autor del mensaje
        this.fechaEnvio = LocalDateTime.now();  // La fecha de envío se establece a la fecha y hora actual
    }

    /**
     * Obtiene el contenido del mensaje.
     *
     * @return El contenido del mensaje
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del mensaje.
     *
     * @param contenido El contenido del mensaje
     * @throws IllegalStateException Si el contenido es nulo o vacío
     */
    public void setContenido(String contenido) {
        if (contenido == null || contenido.isEmpty()){
            throw new IllegalStateException("El contenido del mensaje no puede ser nulo ni vacío");
        }
        this.contenido = contenido;  // Se establece el contenido del mensaje
    }

    /**
     * Obtiene el autor del mensaje.
     *
     * @return El autor (vendedor) del mensaje
     */
    public Vendedor getAutor() {
        return autor;
    }

    /**
     * Establece el autor del mensaje.
     *
     * @param autor El autor (vendedor) del mensaje
     * @throws IllegalStateException Si el autor es nulo
     */
    public void setAutor(Vendedor autor) {
        if (autor == null){
            throw new IllegalStateException("El autor del mensaje no puede ser nulo");
        }
        this.autor = autor;  // Se establece el autor del mensaje
    }

    /**
     * Obtiene la fecha y hora de envío del mensaje.
     *
     * @return La fecha y hora de envío
     */
    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     * Establece la fecha y hora de envío del mensaje.
     *
     * @param fechaEnvio La fecha de envío
     * @throws IllegalStateException Si la fecha de envío es nula o posterior a la fecha actual
     */
    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        if (fechaEnvio == null || fechaEnvio.isAfter(LocalDateTime.now())){
            throw new IllegalStateException("La fecha de envío no puede ser nula ni posterior a la fecha actual");
        }
        this.fechaEnvio = fechaEnvio;  // Se establece la fecha de envío
    }

    /**
     * Método para representar el mensaje como una cadena de texto.
     *
     * @return La representación en forma de cadena del mensaje
     */
    @Override
    public String toString() {
        return "Mensaje{" +
                "contenido='" + contenido + '\'' +
                ", autor=" + (autor != null ? autor.getNombres() : "Sin autor") +  // Si el autor es nulo, muestra "Sin autor"
                ", fechaEnvio=" + fechaEnvio +
                '}';
    }
}


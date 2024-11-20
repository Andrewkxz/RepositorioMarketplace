package co.edu.uniquindio.marketplace.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase Chat: Representa una conversación entre dos vendedores que incluye un historial de mensajes.
 */
public class Chat {

    private Vendedor emisor; // El vendedor que inicia el chat
    private Vendedor receptor; // El vendedor que recibe los mensajes
    private List<Mensaje> mensajes; // Lista de mensajes enviados en el chat

    /**
     * Constructor por defecto. Inicializa el objeto Chat sin configuraciones específicas.
     */
    public Chat() {
    }

    /**
     * Constructor con parámetros. Configura los participantes del chat y prepara la lista de mensajes.
     *
     * @param emisor El vendedor que envía mensajes en el chat.
     * @param receptor El vendedor que recibe mensajes en el chat.
     * @throws IllegalStateException Si alguno de los vendedores es nulo o si ambos son el mismo vendedor.
     */
    public Chat(Vendedor emisor, Vendedor receptor) {
        if (emisor == null || receptor == null) {
            throw new IllegalStateException("Los vendedores no pueden ser nulos");
        }
        if (emisor.equals(receptor)) {
            throw new IllegalStateException("Se requiere que ambos vendedores sean distintos entre sí para hacer un chat");
        }
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensajes = new ArrayList<>();
    }

    /**
     * Envía un mensaje en el chat desde un vendedor específico.
     *
     * @param contenido El contenido del mensaje.
     * @param autor El vendedor que envía el mensaje.
     * @throws IllegalStateException Si el contenido es nulo/vacío o si el autor es nulo.
     */
    public void enviarMensaje(String contenido, Vendedor autor) {
        if (contenido == null || contenido.isEmpty() || autor == null) {
            throw new IllegalStateException("Todos los campos son requeridos");
        }
        Mensaje mensaje = new Mensaje(contenido, autor); // Crea un nuevo mensaje
        this.mensajes.add(mensaje); // Agrega el mensaje a la lista
    }

    /**
     * Obtiene el vendedor que actúa como emisor en el chat.
     *
     * @return El vendedor emisor.
     */
    public Vendedor getEmisor() {
        return emisor;
    }

    /**
     * Establece el vendedor emisor del chat.
     *
     * @param emisor El vendedor que actúa como emisor.
     * @throws IllegalStateException Si el vendedor es nulo.
     */
    public void setEmisor(Vendedor emisor) {
        if (emisor == null) {
            throw new IllegalStateException("Los vendedores no pueden ser nulos");
        }
        this.emisor = emisor;
    }

    /**
     * Obtiene el vendedor que actúa como receptor en el chat.
     *
     * @return El vendedor receptor.
     */
    public Vendedor getReceptor() {
        return receptor;
    }

    /**
     * Establece el vendedor receptor del chat.
     *
     * @param receptor El vendedor que actúa como receptor.
     * @throws IllegalStateException Si el vendedor es nulo.
     */
    public void setReceptor(Vendedor receptor) {
        if (receptor == null) {
            throw new IllegalStateException("Los vendedores no pueden ser nulos");
        }
        this.receptor = receptor;
    }

    /**
     * Obtiene el historial de mensajes del chat.
     *
     * @return Una lista de mensajes.
     */
    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    /**
     * Establece el historial de mensajes del chat.
     *
     * @param mensajes Una lista de mensajes para el chat.
     * @throws IllegalStateException Si la lista de mensajes es nula.
     */
    public void setMensajes(List<Mensaje> mensajes) {
        if (mensajes == null) {
            throw new IllegalStateException("La lista de mensajes no puede ser nula");
        }
        this.mensajes = mensajes;
    }

    /**
     * Retorna una representación en forma de cadena del chat, incluyendo información básica.
     *
     * @return Una cadena que describe el chat.
     */
    @Override
    public String toString() {
        return "Chat{" +
                "emisor=" + emisor +
                ", receptor=" + receptor +
                ", cantidadMensajes=" + mensajes.size() +
                '}';
    }
}
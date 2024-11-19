package co.edu.uniquindio.marketplace.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Chat {
    private Vendedor emisor;
    private Vendedor receptor;
    private List<Mensaje> mensajes;

    /**
     *
     */
    public Chat(){
    }

    /**
     *
     * @param emisor
     * @param receptor
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
     *
     * @param contenido
     * @param autor
     */
    public void enviarMensaje(String contenido, Vendedor autor){
        if (contenido == null || contenido.isEmpty() || autor == null) {
            throw new IllegalStateException("Todos los campos son requeridos");
        }
        Mensaje mensaje = new Mensaje(contenido, autor);
        this.mensajes.add(mensaje);
    }

    /**
     *
     * @return
     */
    public Vendedor getEmisor() {
        return emisor;
    }

    /**
     *
     * @param emisor
     */
    public void setEmisor(Vendedor emisor) {
        if (emisor == null) {
            throw new IllegalStateException("Los vendedores no pueden ser nulos");
        }
        this.emisor = emisor;
    }

    /**
     *
     * @return
     */
    public Vendedor getReceptor() {
        return receptor;
    }

    /**
     *
     * @param receptor
     */
    public void setReceptor(Vendedor receptor) {
        if (receptor == null) {
            throw new IllegalStateException("Los vendedores no pueden ser nulos");
        }
        this.receptor = receptor;
    }

    /**
     *
     * @return
     */
    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    /**
     *
     * @param mensajes
     */
    public void setMensajes(List<Mensaje> mensajes) {
        if (mensajes == null) {
            throw new IllegalStateException("La lista de mensajes no puede ser nula");
        }
        this.mensajes = mensajes;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "vendedor1=" + emisor +
                ", vendedor2=" + receptor +
                ", cantidadMensajes=" + mensajes.size() +
                '}';
    }
}

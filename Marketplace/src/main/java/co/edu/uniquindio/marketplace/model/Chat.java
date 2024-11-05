package co.edu.uniquindio.marketplace.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Chat {
    private Vendedor vendedor1;
    private Vendedor vendedor2;
    private List<Mensaje> mensajes;

    /**
     *
     */
    public Chat(){
    }

    /**
     *
     * @param vendedor1
     * @param vendedor2
     */
    public Chat(Vendedor vendedor1, Vendedor vendedor2) {
        this.vendedor1 = vendedor1;
        this.vendedor2 = vendedor2;
        this.mensajes = new ArrayList<>();
    }

    /**
     *
     * @param mensaje
     */
    public void enviarMensaje(Mensaje mensaje){
        this.mensajes.add(mensaje);
    }

    /**
     *
     * @return
     */
    public Vendedor getVendedor1() {
        return vendedor1;
    }

    /**
     *
     * @param vendedor1
     */
    public void setVendedor1(Vendedor vendedor1) {
        this.vendedor1 = vendedor1;
    }

    /**
     *
     * @return
     */
    public Vendedor getVendedor2() {
        return vendedor2;
    }

    /**
     *
     * @param vendedor2
     */
    public void setVendedor2(Vendedor vendedor2) {
        this.vendedor2 = vendedor2;
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
        this.mensajes = mensajes;
    }
}

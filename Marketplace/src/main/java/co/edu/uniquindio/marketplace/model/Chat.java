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
        this.mensajes = new ArrayList<>();
    }

    /**
     *
     * @param vendedor1
     * @param vendedor2
     */
    public Chat(Vendedor vendedor1, Vendedor vendedor2) {
        if (vendedor1 == null || vendedor2 == null) {
            throw new IllegalArgumentException("Los vendedores no pueden ser nulos.");
        }
        if (vendedor1.equals(vendedor2)) {
            throw new IllegalArgumentException("El chat requiere dos vendedores diferentes.");
        }
        this.vendedor1 = vendedor1;
        this.vendedor2 = vendedor2;
        this.mensajes = new ArrayList<>();
    }

    /**
     *
     * @param mensaje
     */
    public void enviarMensaje(Mensaje mensaje){
        if (mensaje == null) {
            throw new IllegalArgumentException("Los mensajes no pueden ser nulos.");
        }
        this.mensajes.add(mensaje);
    }

    /**
     *
     * @return vendedor 1
     */
    public Vendedor getVendedor1() {
        return vendedor1;
    }

    /**
     *
     * @param vendedor1
     */
    public void setVendedor1(Vendedor vendedor1) {
        if (vendedor1 == null) {
            throw new IllegalArgumentException("Los vendedores no pueden ser nulos.");
        }
        this.vendedor1 = vendedor1;
    }

    /**
     *
     * @return vendedor 2
     */

    public Vendedor getVendedor2() {
        return vendedor2;
    }

    /**
     *
     * @param vendedor2
     */
    public void setVendedor2(Vendedor vendedor2) {
        if (vendedor2 == null) {
            throw new IllegalArgumentException("Los vendedores no pueden ser nulos.");
        }
        this.vendedor2 = vendedor2;
    }

    /**
     *
     * @return lista de mensajes
     */
    public List<Mensaje> getMensajes() {
        return new ArrayList<>(mensajes);
    }

    /**
     *
     * @param mensajes lista de mensajes
     */
    public void setMensajes(List<Mensaje> mensajes) {
        if (mensajes == null) {
            throw new IllegalArgumentException("La lista de mensajes no pueden ser nula.");
        }
        this.mensajes = new ArrayList<>(mensajes);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "vendedor1=" + vendedor1.getCedula() +
                ", vendedor2=" + vendedor2.getCedula() +
                ", cantidadMensajes=" + mensajes.size()+
                '}';
    }
}

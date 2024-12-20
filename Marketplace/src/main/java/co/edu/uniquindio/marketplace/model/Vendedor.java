package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplace.services.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Vendedor extends Persona implements Observer {
    private Muro muro;
    private List <Producto> productos;
    private List <Vendedor> contactos;
    private List <Chat> chats;

    public Vendedor() {
    }

    /**
     *
     * @param nombres
     * @param apellidos
     * @param cedula
     * @param direccion
     * @param usuario
     */
    public Vendedor(String nombres, String apellidos, String cedula, String direccion, Usuario usuario) {
        super(nombres, apellidos, cedula, direccion, usuario);
        this.muro = new Muro();
        this.productos = new ArrayList<>();
        this.contactos = new ArrayList<>();
        this.chats = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public static VendedorBuilder builder() {
        return new VendedorBuilder();
    }

    public Muro getMuro() {
        return muro;
    }

    public void agregarPublicacion(Producto producto) {
        if (producto == null) {
            throw new NullPointerException("El producto es necesario para crear la publicación");
        }
        Publicacion publicacion = new Publicacion(producto, this);
        this.muro.agregarPublicacion(publicacion);
    }

    public void agregarChat(Chat chat) {
        if (chat != null) {
            this.chats.add(chat);
        }
    }

    public List <Chat> getChats() {
        return chats;
    }

    /**
     *
     * @param vendedor
     * @return
     */
    public boolean agregarContacto(Vendedor vendedor) {
        if (vendedor != null && !contactos.contains(vendedor) && contactos.size() < 10) {
            contactos.add(vendedor);
            vendedor.agregarContacto(this);
            return true;
        }
        return false;
    }

    /**
     *
     * @param vendedor
     * @return
     */
    public boolean eliminarContacto(Vendedor vendedor) {
        if (vendedor != null && contactos.contains(vendedor)){
            contactos.remove(vendedor);
            vendedor.getContactos().remove(this);
            return true;
        }
        return false;
    }

    /**
     *
     * @param producto
     */
    public void agregarProducto(Producto producto){
        if (producto != null){
            productos.add(producto);
        }
    }

    /**
     *
     * @return
     */
    public List<Producto> listarProductos(){
        if(productos.isEmpty()){
            System.out.println("No hay productos");
        }else{
            for(Producto producto: productos){
                System.out.println(producto);
            }
        }
        return productos;
    }

    /**
     *
     * @return
     */
    public List<Vendedor> getContactos() {
        return contactos;
    }

    /**
     *
     * @param contactos
     */
    public void setContactos(List<Vendedor> contactos) {
        this.contactos = contactos;
    }

    @Override
    public void actualizacion(Publicacion publicacion) {
        System.out.println("Nueva publicación de " + publicacion.getAutor().getNombres() + ": " + publicacion.getProducto().getNombre());
    }
}

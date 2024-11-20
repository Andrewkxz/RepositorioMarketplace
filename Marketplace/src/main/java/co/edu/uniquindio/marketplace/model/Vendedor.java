package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplace.services.Observer;

import java.util.ArrayList;
import java.util.List;

/** Clase que representa a un vendedor en el sistema.
 *  Hereda de Persona y implementa Observer.**/
public class Vendedor extends Persona implements Observer {
    private Muro muro;               // Muro del vendedor donde se publican productos
    private List <Producto> productos;  // Lista de productos del vendedor
    private List <Vendedor> contactos;  // Lista de vendedores con los que tiene contacto
    private List <Chat> chats;         // Lista de chats del vendedor

    /**
     * Constructor por defecto de la clase Vendedor.
     * Inicializa las listas de productos, contactos y chats.
     */
    public Vendedor() {
    }

    /**
     * Constructor para crear un Vendedor con los datos básicos de una persona.
     * Además inicializa el muro, los productos, los contactos y los chats.
     *
     * @param nombres Nombre del vendedor
     * @param apellidos Apellidos del vendedor
     * @param cedula Cédula del vendedor
     * @param direccion Dirección del vendedor
     * @param usuario Objeto Usuario asociado al vendedor
     */
    public Vendedor(String nombres, String apellidos, String cedula, String direccion, Usuario usuario) {
        super(nombres, apellidos, cedula, direccion, usuario); // Llama al constructor de la clase Persona
        this.muro = new Muro();             // Inicializa el muro del vendedor
        this.productos = new ArrayList<>(); // Lista vacía de productos
        this.contactos = new ArrayList<>(); // Lista vacía de contactos
        this.chats = new ArrayList<>();    // Lista vacía de chats
    }

    /**
     * Método estático para construir un objeto Vendedor utilizando el patrón Builder.
     *
     * @return Un objeto VendedorBuilder para crear un Vendedor
     */
    public static VendedorBuilder builder() {
        return new VendedorBuilder();
    }

    /**
     * Obtiene el muro asociado al vendedor.
     *
     * @return El muro del vendedor
     */
    public Muro getMuro() {
        return muro;  // Devuelve el muro del vendedor
    }

    /**
     * Agrega una nueva publicación al muro del vendedor con el producto especificado.
     *
     * @param producto El producto a publicar
     * @throws NullPointerException Si el producto es nulo
     */
    public void agregarPublicacion(Producto producto) {
        if (producto == null) {
            throw new NullPointerException("El producto es necesario para crear la publicación");
        }
        Publicacion publicacion = new Publicacion(producto, this);  // Crea una nueva publicación
        this.muro.agregarPublicacion(publicacion); // Agrega la publicación al muro
    }

    /**
     * Agrega un chat a la lista de chats del vendedor.
     *
     * @param chat El chat a agregar
     */
    public void agregarChat(Chat chat) {
        if (chat != null) {
            this.chats.add(chat); // Agrega el chat a la lista
        }
    }

    /**
     * Obtiene la lista de chats del vendedor.
     *
     * @return La lista de chats
     */
    public List<Chat> getChats() {
        return chats; // Devuelve la lista de chats
    }

    /**
     * Agrega un vendedor a la lista de contactos del vendedor si no está ya en la lista
     * y si no se supera el límite de 10 contactos.
     *
     * @param vendedor El vendedor a agregar a los contactos
     * @return true si el contacto fue agregado exitosamente, false si no
     */
    public boolean agregarContacto(Vendedor vendedor) {
        if (vendedor != null && !contactos.contains(vendedor) && contactos.size() < 10) {
            contactos.add(vendedor);  // Agrega el vendedor a los contactos
            vendedor.agregarContacto(this);  // Agrega al vendedor actual como contacto del otro vendedor
            return true;  // Contacto agregado con éxito
        }
        return false;  // No se pudo agregar el contacto
    }

    /**
     * Elimina un vendedor de la lista de contactos.
     *
     * @param vendedor El vendedor a eliminar de los contactos
     * @return true si el contacto fue eliminado exitosamente, false si no
     */
    public boolean eliminarContacto(Vendedor vendedor) {
        if (vendedor != null && contactos.contains(vendedor)) {
            contactos.remove(vendedor); // Elimina el contacto de la lista
            vendedor.getContactos().remove(this); // Elimina el vendedor actual de la lista de contactos del otro vendedor
            return true;  // Contacto eliminado con éxito
        }
        return false;  // No se pudo eliminar el contacto
    }

    /**
     * Agrega un producto a la lista de productos del vendedor.
     *
     * @param producto El producto a agregar
     */
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto); // Agrega el producto a la lista de productos
        }
    }

    /**
     * Lista todos los productos del vendedor.
     *
     * @return La lista de productos
     */
    public List<Producto> listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos");  // Si no hay productos, muestra un mensaje
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);  // Muestra cada producto
            }
        }
        return productos;  // Devuelve la lista de productos
    }

    /**
     * Obtiene la lista de contactos del vendedor.
     *
     * @return La lista de contactos
     */
    public List<Vendedor> getContactos() {
        return contactos;  // Devuelve la lista de contactos
    }

    /**
     * Establece la lista de contactos del vendedor.
     *
     * @param contactos La lista de contactos a establecer
     */
    public void setContactos(List<Vendedor> contactos) {
        this.contactos = contactos;  // Establece la lista de contactos
    }

    /**
     * Método implementado de la interfaz Observer. Este método recibe una actualización sobre una publicación.
     *
     * @param publicacion La publicación que generó la actualización
     */
    @Override
    public void actualizacion(Publicacion publicacion) {
        System.out.println("Nueva publicación de " + publicacion.getAutor().getNombres() + ": " + publicacion.getProducto().getNombre());
        // Muestra un mensaje con los detalles de la nueva publicación
    }
}

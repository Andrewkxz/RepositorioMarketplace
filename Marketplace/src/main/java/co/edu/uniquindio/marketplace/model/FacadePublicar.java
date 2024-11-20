package co.edu.uniquindio.marketplace.model;

// Clase que actúa como una fachada para manejar la creación de publicaciones, comentarios y mensajes
public class FacadePublicar {

    // Atributos para las clases que gestionan publicaciones, comentarios, mensajes y chats
    private Publicacion publicaciones;
    private Comentario comentarios;
    private Mensaje mensajes;
    private Chat chats;

    // Constructor que inicializa los objetos necesarios para manejar publicaciones, comentarios, mensajes y chats
    public FacadePublicar() {
        // Se crean nuevas instancias de las clases involucradas en el proceso
        publicaciones = new Publicacion();
        comentarios = new Comentario();
        mensajes = new Mensaje();
        chats = new Chat();
    }

    /**
     * Método para crear una publicación de un producto por parte de un vendedor
     * @param autor El vendedor que crea la publicación
     * @param producto El producto que se publicará
     */
    public void crearPublicacion(Vendedor autor, Producto producto) {
        // Se agrega la publicación del producto al autor (vendedor)
        publicaciones.getAutor().agregarPublicacion(producto);
        // Se imprime un mensaje indicando que la publicación fue creada con éxito
        System.out.println("Publicación creada por: " + autor.getNombres() + " con el producto: " + producto.getNombre());
    }

    /**
     * Método para crear un comentario asociado a una publicación
     * @param autor El vendedor que escribe el comentario
     * @param comentario El contenido del comentario
     */
    public void crearComentario(Vendedor autor, String comentario) {
        // Verifica que el comentario no sea nulo ni vacío
        if (comentario != null && !comentario.isEmpty()) {
            // Asigna el autor y contenido al comentario
            comentarios.setAutor(autor);
            comentarios.setContenido(comentario);
            // Agrega el comentario a la publicación
            publicaciones.agregarComentario(comentarios);
            // Imprime un mensaje de confirmación
            System.out.println("Comentario creado por: " + autor.getNombres() + " con el comentario: " + comentario);
        } else {
            // Si el comentario es nulo o vacío, imprime un mensaje de error
            System.out.println("El comentario debe tener texto");
        }
    }

    /**
     * Método para crear un mensaje enviado por un vendedor a otro a través de un chat
     * @param autor El vendedor que envía el mensaje
     * @param comentario El contenido del mensaje
     */
    public void crearMensaje(Vendedor autor, String comentario) {
        // Verifica que el mensaje no sea nulo ni vacío
        if (comentario != null && !comentario.isEmpty()) {
            // Asigna el autor y contenido al mensaje
            mensajes.setAutor(autor);
            mensajes.setContenido(comentario);
            // Envia el mensaje al chat correspondiente
            chats.enviarMensaje(comentario, autor);
            // Imprime un mensaje de confirmación
            System.out.println("Mensaje enviado por: " + autor.getNombres() + " con el comentario: " + comentario);
        }
    }
}

package co.edu.uniquindio.marketplace.model;

public class FacadePublicar {
    private Publicacion publicaciones;
    private Comentario comentarios;
    private Mensaje mensajes;
    private Chat chats;

    public FacadePublicar() {
        publicaciones = new Publicacion();
        comentarios = new Comentario();
        mensajes = new Mensaje();
        chats = new Chat();
    }

    public void crearPublicacion(Vendedor autor, Producto producto) {
        publicaciones.getAutor().agregarPublicacion(producto);
        System.out.println("Publicación creada por: " + autor.getNombres() + " con el producto: " + producto.getNombre());
    }

    public void crearComentario(Vendedor autor, String comentario) {
        if(comentario !=null && !comentario.isEmpty()){
            comentarios.setAutor(autor);
            comentarios.setContenido(comentario);
            publicaciones.agregarComentario(comentarios);
            System.out.println("Comentario creado por: " + autor.getNombres() + " con el comentario: " + comentario);
        } else {
            System.out.println("El comentario debe tener texto");
        }
    }

    public void crearMensaje(Vendedor autor, String comentario) {
        if(comentario !=null && !comentario.isEmpty()){
            mensajes.setAutor(autor);
            mensajes.setContenido(comentario);
            chats.enviarMensaje(comentario, autor);
            System.out.println("Mensaje enviado por: " + autor.getNombres() + " con el comentario: " + comentario);
        }
    }
}

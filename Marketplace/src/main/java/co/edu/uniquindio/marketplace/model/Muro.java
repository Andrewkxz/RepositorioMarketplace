package co.edu.uniquindio.marketplace.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Muro {
    private List<Publicacion> publicaciones;

    /**
     *
     */
    public Muro() {
        publicaciones = new ArrayList<Publicacion>();
    }

    /**
     *
     * @param publicacion
     */
    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    /**
     *
     * @return
     */
    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    /**
     *
     */
    public void mostrarPublicacionesEnOrden() {
        publicaciones.sort((publicacion1, publicacion2) ->
                publicacion2.getFechaPublicacion().compareTo(publicacion1.getFechaPublicacion()));
        publicaciones.forEach(System.out::println);
    }

    /**
     *
     * @param publicacion
     * @param comentario
     */
    public void agregarComentario(Publicacion publicacion, Comentario comentario) {
        if (publicaciones.contains(publicacion)) {
            publicacion.agregarComentario(comentario);
        } else {
            System.out.println("Publicación no encontrada en el muro");
        }
    }

    /**
     *
     * @param top
     * @return
     */
    public List<Publicacion> getTopPublicacionesConMasLikes(int top){
        if (top <= 0 || publicaciones.isEmpty()){
            return new ArrayList<>();
        }
        publicaciones.sort((publicacion1, publicacion2) ->
                Integer.compare(publicacion2.getCantidadLikes(), publicacion1.getCantidadLikes()));
        return publicaciones.subList(0, Math.min(top, publicaciones.size()));
    }
}

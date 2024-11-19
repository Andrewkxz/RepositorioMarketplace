package co.edu.uniquindio.marketplace.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        if (publicacion == null) {
            throw new IllegalArgumentException("La publicacion no puede ser nula");
        }
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
     * @return
     */
    public List<Publicacion> mostrarPublicacionesEnOrden() {
        return publicaciones.stream()
                .sorted(Comparator.comparing(Publicacion::getFechaPublicacion).reversed())
                .collect(Collectors.toList());
    }

    /**
     *
     * @param publicacion
     * @param comentario
     */
    public void agregarComentario(Publicacion publicacion, Comentario comentario) {
        if (publicacion == null || comentario == null) {
            throw new IllegalArgumentException("La publicacion y el comentario no pueden ser nulos");
        }
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

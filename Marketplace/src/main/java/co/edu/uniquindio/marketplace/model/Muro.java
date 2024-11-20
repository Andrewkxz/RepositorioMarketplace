package co.edu.uniquindio.marketplace.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Clase que representa el muro donde se agregan publicaciones y comentarios
public class Muro {
    private List<Publicacion> publicaciones;  // Lista que almacena las publicaciones del muro

    // Constructor vacío que inicializa la lista de publicaciones
    public Muro() {
        publicaciones = new ArrayList<Publicacion>();
    }

    /**
     * Agrega una nueva publicación al muro.
     *
     * @param publicacion La publicación que se desea agregar
     * @throws IllegalArgumentException Si la publicación es nula
     */
    public void agregarPublicacion(Publicacion publicacion) {
        if (publicacion == null) {
            throw new IllegalArgumentException("La publicacion no puede ser nula");  // Se lanza una excepción si la publicación es nula
        }
        publicaciones.add(publicacion);  // Se agrega la publicación a la lista
    }

    /**
     * Obtiene la lista de todas las publicaciones en el muro.
     *
     * @return La lista de publicaciones en el muro
     */
    public List<Publicacion> getPublicaciones() {
        return publicaciones;  // Devuelve la lista de publicaciones
    }

    /**
     * Muestra las publicaciones ordenadas por la fecha de publicación, de más reciente a más antigua.
     *
     * @return Lista de publicaciones ordenadas por fecha de publicación
     */
    public List<Publicacion> mostrarPublicacionesEnOrden() {
        return publicaciones.stream()  // Crea un flujo (stream) de las publicaciones
                .sorted(Comparator.comparing(Publicacion::getFechaPublicacion).reversed())  // Ordena las publicaciones por fecha (de más reciente a más antigua)
                .collect(Collectors.toList());  // Recoge los elementos del flujo en una nueva lista
    }

    /**
     * Agrega un comentario a una publicación existente en el muro.
     *
     * @param publicacion La publicación a la que se desea agregar el comentario
     * @param comentario El comentario que se desea agregar
     * @throws IllegalArgumentException Si la publicación o el comentario son nulos
     */
    public void agregarComentario(Publicacion publicacion, Comentario comentario) {
        if (publicacion == null || comentario == null) {
            throw new IllegalArgumentException("La publicacion y el comentario no pueden ser nulos");  // Se lanza una excepción si alguno es nulo
        }
        if (publicaciones.contains(publicacion)) {  // Verifica si la publicación está en el muro
            publicacion.agregarComentario(comentario);  // Agrega el comentario a la publicación
        } else {
            System.out.println("Publicación no encontrada en el muro");  // Si no encuentra la publicación, muestra un mensaje
        }
    }

    /**
     * Obtiene las publicaciones con más "likes", limitando el número de resultados a un valor "top".
     *
     * @param top Número máximo de publicaciones a devolver
     * @return Lista de las publicaciones con más "likes", limitado por el valor de "top"
     */
    public List<Publicacion> getTopPublicacionesConMasLikes(int top){
        if (top <= 0 || publicaciones.isEmpty()){  // Si el valor de "top" es menor o igual a cero, o si la lista de publicaciones está vacía
            return new ArrayList<>();  // Devuelve una lista vacía
        }
        publicaciones.sort((publicacion1, publicacion2) ->  // Ordena las publicaciones por la cantidad de "likes"
                Integer.compare(publicacion2.getCantidadLikes(), publicacion1.getCantidadLikes()));  // Ordena de mayor a menor
        return publicaciones.subList(0, Math.min(top, publicaciones.size()));  // Devuelve las "top" publicaciones, asegurándose de no exceder el tamaño de la lista
    }
}

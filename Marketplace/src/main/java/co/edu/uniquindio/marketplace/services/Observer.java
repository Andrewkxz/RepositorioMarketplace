package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.model.Publicacion;

/**
 * Interfaz que define el comportamiento de un observador en el patrón de diseño Observer.
 * Permite que los objetos suscritos reciban actualizaciones sobre cambios en una publicación.
 */
public interface Observer {

    /**
     * Método que recibe las actualizaciones de una publicación.
     *
     * @param publicacion La publicación que ha sufrido un cambio.
     */
    void actualizacion(Publicacion publicacion);
}

package co.edu.uniquindio.marketplace.model;

/**
 *
 */
public enum Estado {
    PUBLICADO,
    VENDIDO,
    CANCELADO;

    /**
     * Obtiene una descripción legible del estado.
     *
     * @return Descripción del estado.
     */

public String getDescripcion() {
    switch (this) {
        case PUBLICADO:
            return "El producto está publicado y disponible para la venta.";
        case VENDIDO:
            return "El producto ha sido vendido.";
        case CANCELADO:
            return "La publicación del producto ha sido cancelada.";
        default:
            throw new IllegalArgumentException("Estado desconocido.");

        }
    }
}
package co.edu.uniquindio.marketplace.model;

/**
 * Representa los estados posibles de un producto.
 */
public enum Estado {
    PUBLICADO,  // El producto está disponible para la venta.
    VENDIDO,    // El producto ha sido vendido.
    CANCELADO;  // La venta del producto ha sido cancelada.

    /**
     * Obtiene una descripción más detallada del estado.
     *
     * @return Una descripción legible y clara del estado actual.
     */
    public String getDescripcion() {
        switch (this) {
            case PUBLICADO:
                return "El producto está publicado y disponible para la venta.";
            case VENDIDO:
                return "El producto ha sido vendido.";
            case CANCELADO:
                return "El producto ha sido cancelado.";
            default:
                throw new IllegalStateException("Estado desconocido");
        }
    }
}

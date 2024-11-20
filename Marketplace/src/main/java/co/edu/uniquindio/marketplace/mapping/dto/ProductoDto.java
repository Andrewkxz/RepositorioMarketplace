package co.edu.uniquindio.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.model.Estado;

/**
 * Representa un producto en el sistema.
 * Este DTO (Data Transfer Object) contiene la información básica del producto.
 * 
 * @param nombre El nombre del producto.
 * @param imagen La URL o ruta de la imagen del producto.
 * @param precio El precio del producto.
 * @param estado El estado del producto (por ejemplo, si está disponible, agotado, etc.).
 */
public record ProductoDto(
        String nombre,      // Nombre del producto
        String imagen,     // Imagen asociada al producto (como una URL o ruta)
        double precio,     // Precio del producto
        Estado estado      // Estado del producto (por ejemplo, disponible, agotado)
) {
}

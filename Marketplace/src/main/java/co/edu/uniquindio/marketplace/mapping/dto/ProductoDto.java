package co.edu.uniquindio.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.model.Estado;

/**
 *
 * @param idProducto
 * @param nombre
 * @param imagen
 * @param precio
 * @param estado
 */
public record ProductoDto(
        String idProducto,
        String nombre,
        String imagen,
        double precio,
        Estado estado
        ){
}

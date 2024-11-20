package co.edu.uniquindio.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.model.Estado;

/**
 * La clase ProductoDto es un "Record" que sirve como un objeto de transferencia de datos (DTO).
 * Los DTOs se utilizan para transferir información entre capas de una aplicación, generalmente entre la capa
 * de presentación (como controladores) y la capa de servicio o persistencia.
 * En este caso, el ProductoDto contiene información sobre un producto, incluyendo su nombre, imagen, precio y estado.
 */
public record ProductoDto(
        String nombre,
        String imagen,
        double precio,
        Estado estado
) {
}
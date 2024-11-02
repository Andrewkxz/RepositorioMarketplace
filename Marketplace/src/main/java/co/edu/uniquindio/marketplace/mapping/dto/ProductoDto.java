package co.edu.uniquindio.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.model.Estado;

public record ProductoDto(
        String nombre,
        String imagen,
        double precio,
        Estado estado
        ){
}

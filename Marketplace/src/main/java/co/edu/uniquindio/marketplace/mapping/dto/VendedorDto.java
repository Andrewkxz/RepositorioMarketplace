package co.edu.uniquindio.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.model.Usuario;

/**
 *
 * @param nombres
 * @param apellidos
 * @param cedula
 * @param direccion
 * @param usuario
 */
public record VendedorDto(
        String nombres,
        String apellidos,
        String cedula,
        String direccion,
        Usuario usuario
){
}

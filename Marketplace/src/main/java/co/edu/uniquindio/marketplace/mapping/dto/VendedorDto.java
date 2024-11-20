package co.edu.uniquindio.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.model.Usuario;

/**
 * La clase VendedorDto es un "Record" que representa un objeto de transferencia de datos (DTO).
 * Este DTO se utiliza para transferir la información relacionada con un vendedor, incluyendo sus datos personales
 * como nombre, apellido, cédula, dirección y el usuario asociado.
 */
public record VendedorDto(
        String nombres,
        String apellidos,
        String cedula,
        String direccion,
        Usuario usuario) {
}

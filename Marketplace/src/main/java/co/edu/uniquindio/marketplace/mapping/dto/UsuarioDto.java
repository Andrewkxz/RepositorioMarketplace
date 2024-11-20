package co.edu.uniquindio.marketplace.mapping.dto;

/**
 * La clase UsuarioDto es un "Record" que representa un objeto de transferencia de datos (DTO).
 * En este caso, se utiliza para transferir la información relacionada con un usuario.
 * Este DTO contiene el nombre de usuario y la contraseña del usuario.
 */
public record UsuarioDto(
        String usuario,
        String contrasenia) {
}

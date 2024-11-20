package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Usuario;

/**
 * Clase UsuarioBuilder: Implementa el patrón Builder para crear instancias de la clase Usuario.
 * Este patrón permite construir objetos de manera flexible y encadenada, simplificando la configuración de sus atributos.
 */
public class UsuarioBuilder {
    protected String usuario;
    protected String contrasenia;
    protected String rol;

    /**
     * Establece el nombre de usuario.
     * @param usuario El nombre de usuario.
     * @return La instancia actual del builder para permitir encadenamiento.
     */
    public UsuarioBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return La instancia actual del builder para permitir encadenamiento.
     */
    public UsuarioBuilder contrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        return this;
    }

    /**
     * Establece el rol del usuario.
     * @param rol El rol del usuario (por ejemplo, "admin", "vendedor", "cliente").
     * @return La instancia actual del builder para permitir encadenamiento.
     */
    public UsuarioBuilder rol(String rol) {
        this.rol = rol;
        return this;
    }

    /**
     * Construye una instancia de Usuario utilizando los valores configurados.
     * @return Una nueva instancia de Usuario.
     */
    public Usuario build() {
        // Crea un nuevo objeto Usuario con los valores configurados en el builder
        return new Usuario(usuario, contrasenia, rol);
    }
}
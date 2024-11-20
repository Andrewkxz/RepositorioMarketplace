package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.UsuarioBuilder;

// Clase que representa a un usuario en el sistema, con nombre, contraseña y rol asociado.
public class Usuario {
    private String Usuario;      // Nombre de usuario (identificador único)
    private String contrasenia;  // Contraseña asociada al usuario
    private String rol;          // Rol del usuario (ej. admin, vendedor, comprador)

    /**
     * Constructor por defecto de la clase Usuario.
     * Inicializa el objeto de usuario con valores predeterminados.
     */
    public Usuario() {
    }

    /**
     * Constructor para crear un usuario con un nombre, contraseña y rol específicos.
     *
     * @param usuario El nombre de usuario
     * @param contrasenia La contraseña del usuario
     * @param rol El rol asociado al usuario
     * @throws IllegalStateException Si alguno de los parámetros es nulo o vacío
     */
    public Usuario(String usuario, String contrasenia, String rol) {
        if (usuario == null || usuario.isEmpty()) {
            throw new IllegalStateException("El nombre de usuario no puede ser nulo ni estar vacío");
        }
        if (contrasenia == null || contrasenia.isEmpty()) {
            throw new IllegalStateException("La contraseña no puede ser nula ni estar vacía");
        }
        if (rol == null || rol.isEmpty()) {
            throw new IllegalStateException("El rol no puede ser nulo ni estar vacío");
        }
        this.Usuario = usuario;        // Asigna el nombre de usuario
        this.contrasenia = contrasenia;  // Asigna la contraseña
        this.rol = rol;                // Asigna el rol
    }

    /**
     * Método estático que devuelve un nuevo objeto de tipo UsuarioBuilder para facilitar la creación de usuarios.
     *
     * @return Un nuevo objeto UsuarioBuilder
     */
    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();  // Devuelve una instancia de UsuarioBuilder
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario
     */
    public String getUsuario() {
        return Usuario;  // Devuelve el nombre de usuario
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param usuario El nombre de usuario a establecer
     * @throws IllegalStateException Si el nombre de usuario es nulo o vacío
     */
    public void setUsuario(String usuario) {
        if (usuario == null || usuario.isEmpty()) {
            throw new IllegalStateException("El nombre de usuario no puede ser nulo ni estar vacío");
        }
        Usuario = usuario;  // Asigna el nombre de usuario
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario
     */
    public String getContrasenia() {
        return contrasenia;  // Devuelve la contraseña
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia La contraseña a establecer
     * @throws IllegalStateException Si la contraseña es nula o vacía
     */
    public void setContrasenia(String contrasenia) {
        if (contrasenia == null || contrasenia.isEmpty()) {
            throw new IllegalStateException("La contraseña no puede ser nula ni estar vacía");
        }
        this.contrasenia = contrasenia;  // Asigna la contraseña
    }

    /**
     * Obtiene el rol asociado al usuario.
     *
     * @return El rol del usuario
     */
    public String getRol() {
        return rol;  // Devuelve el rol del usuario
    }

    /**
     * Establece el rol del usuario.
     *
     * @param rol El rol a establecer para el usuario
     * @throws IllegalStateException Si el rol es nulo o vacío
     */
    public void setRol(String rol) {
        if (rol == null || rol.isEmpty()) {
            throw new IllegalStateException("El rol no puede ser nulo ni estar vacío");
        }
        this.rol = rol;  // Asigna el rol del usuario
    }

    /**
     * Devuelve una representación en cadena del objeto Usuario.
     *
     * @return Una cadena representativa del usuario con nombre, contraseña y rol
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "Usuario='" + Usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", rol='" + rol + '\'' +
                '}';  // Devuelve la cadena representativa
    }
}


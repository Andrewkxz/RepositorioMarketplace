package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Usuario;

/**
 *
 */
public class UsuarioBuilder {
    protected String usuario;
    protected String contrasenia;
    protected String rol;

    /**
     *
     * @param usuario
     * @return
     */
    public UsuarioBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
     *
     * @param contrasenia
     * @return
     */
    public UsuarioBuilder contrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        return this;
    }

    /**
     *
     * @param rol
     * @return
     */
    public UsuarioBuilder rol(String rol) {
        this.rol = rol;
        return this;
    }

    /**
     *
     * @return
     */
    public Usuario build() {
        return new Usuario(usuario, contrasenia, rol);
    }
}

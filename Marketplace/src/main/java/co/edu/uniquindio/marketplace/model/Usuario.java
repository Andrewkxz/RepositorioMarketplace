package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.UsuarioBuilder;

/**
 *
 */
public class Usuario {
    private String Usuario;
    private String contrasenia;
    private String rol;

    /**
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param usuario
     * @param contrasenia
     */
    public Usuario(String usuario, String contrasenia, String rol) {
        this.Usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    /**
     *
     * @return
     */
    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     *
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "Usuario='" + Usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}

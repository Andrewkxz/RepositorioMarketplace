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
     * @param rol
     */
    public Usuario(String usuario, String contrasenia, String rol) {
        if (usuario == null || usuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede ser nulo.");
        }
        if (contrasenia == null || contrasenia.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula.");
        }
        if (rol == null || rol.isEmpty()) {
            throw new IllegalArgumentException("El rol no puede ser nulo.");
        }
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
        if (usuario == null || usuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede ser nulo.");
        }
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
        if (contrasenia == null || contrasenia.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula.");
        }
        this.contrasenia = contrasenia;
    }


    /**
     *
     *
     * @return
     */

    public String getRol() {
        return rol;
    }


    /**
     *
     *
     * @param rol
     */

    public void setRol(String rol) {
        if (rol == null || rol.isEmpty()) {
            throw new IllegalArgumentException("El rol no puede ser nulo.");
        }
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

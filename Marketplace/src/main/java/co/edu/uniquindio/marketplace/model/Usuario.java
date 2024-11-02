package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.UsuarioBuilder;

public class Usuario {
    private String Usuario;
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia) {
        this.Usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Usuario='" + Usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}

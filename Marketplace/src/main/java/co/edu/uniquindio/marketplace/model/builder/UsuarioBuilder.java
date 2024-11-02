package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Usuario;

public class UsuarioBuilder {
    protected String usuario;
    protected String contrasenia;

    public UsuarioBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public UsuarioBuilder contrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        return this;
    }

    public Usuario build() {
        return new Usuario(usuario, contrasenia);
    }
}

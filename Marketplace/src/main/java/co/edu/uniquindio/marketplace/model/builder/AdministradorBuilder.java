package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Administrador;
import co.edu.uniquindio.marketplace.model.Usuario;

public class AdministradorBuilder {
    protected String nombres;
    protected String apellidos;
    protected String cedula;
    protected String direccion;
    protected Usuario usuario;

    public AdministradorBuilder nombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public AdministradorBuilder apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public AdministradorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public AdministradorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public AdministradorBuilder usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Administrador build() {
        return new Administrador(nombres, apellidos, cedula, direccion, usuario);
    }
}
package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.model.Vendedor;

/**
 *
 */
public class VendedorBuilder {
    protected String nombres;
    protected String apellidos;
    protected String cedula;
    protected String direccion;
    protected Usuario usuario;

    /**
     *
     * @param nombres
     * @return
     */
    public VendedorBuilder nombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    /**
     *
     * @param apellidos
     * @return
     */
    public VendedorBuilder apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    /**
     *
     * @param cedula
     * @return
     */
    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    /**
     *
     * @param direccion
     * @return
     */
    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public VendedorBuilder usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
     *
     * @return
     */
    public Vendedor build() {
        return new Vendedor(nombres, apellidos, cedula, direccion, usuario);
    }
}

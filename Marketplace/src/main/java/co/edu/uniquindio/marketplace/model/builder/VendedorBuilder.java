package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.model.Vendedor;

/**
 * Clase VendedorBuilder: Implementa el patrón Builder para crear instancias de la clase Vendedor.
 * Este patrón permite construir objetos de manera fluida y flexible, facilitando la configuración de sus propiedades.
 */
public class VendedorBuilder {
    protected String nombres;
    protected String apellidos;
    protected String cedula;
    protected String direccion;
    protected Usuario usuario;

    /**
     * Establece los nombres del vendedor.
     * @param nombres Nombres del vendedor.
     * @return La instancia actual del builder para permitir encadenamiento.
     */
    public VendedorBuilder nombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    /**
     * Establece los apellidos del vendedor.
     * @param apellidos Apellidos del vendedor.
     * @return La instancia actual del builder para permitir encadenamiento.
     */
    public VendedorBuilder apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    /**
     * Establece la cédula del vendedor.
     * @param cedula Cédula de identidad del vendedor.
     * @return La instancia actual del builder para permitir encadenamiento.
     */
    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    /**
     * Establece la dirección del vendedor.
     * @param direccion Dirección del vendedor.
     * @return La instancia actual del builder para permitir encadenamiento.
     */
    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    /**
     * Establece el usuario asociado al vendedor.
     * @param usuario Objeto Usuario relacionado con el vendedor.
     * @return La instancia actual del builder para permitir encadenamiento.
     */
    public VendedorBuilder usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
     * Construye una instancia de Vendedor utilizando los valores configurados.
     * @return Una nueva instancia de Vendedor.
     */
    public Vendedor build() {
        // Crea un nuevo objeto Vendedor con los valores configurados en el builder
        return new Vendedor(nombres, apellidos, cedula, direccion, usuario);
    }
}


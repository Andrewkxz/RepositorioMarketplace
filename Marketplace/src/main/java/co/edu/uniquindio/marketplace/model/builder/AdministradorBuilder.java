package co.edu.uniquindio.marketplace.model.builder;

import co.edu.uniquindio.marketplace.model.Administrador;
import co.edu.uniquindio.marketplace.model.Usuario;

/**
 * Clase AdministradorBuilder: Implementa el patrón de diseño Builder para construir objetos de tipo Administrador.
 * Este patrón facilita la creación de instancias complejas de una clase, permitiendo configurar cada atributo de forma fluida.
 */
public class AdministradorBuilder {


    protected String nombres;
    protected String apellidos;
    protected String cedula;
    protected String direccion;
    protected Usuario usuario;

    /**
     * Establece el nombre del administrador.
     * @param nombres Nombre del administrador.
     * @return La instancia actual del builder, para encadenamiento.
     */
    public AdministradorBuilder nombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    /**
     * Establece los apellidos del administrador.
     * @param apellidos Apellidos del administrador.
     * @return La instancia actual del builder, para encadenamiento.
     */
    public AdministradorBuilder apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    /**
     * Establece la cédula del administrador.
     * @param cedula Cédula de identidad del administrador.
     * @return La instancia actual del builder, para encadenamiento.
     */
    public AdministradorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    /**
     * Establece la dirección del administrador.
     * @param direccion Dirección del administrador.
     * @return La instancia actual del builder, para encadenamiento.
     */
    public AdministradorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    /**
     * Establece el usuario asociado al administrador.
     * @param usuario Objeto Usuario relacionado con el administrador.
     * @return La instancia actual del builder, para encadenamiento.
     */
    public AdministradorBuilder usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
     * Construye un objeto Administrador con los valores previamente configurados.
     * @return Una nueva instancia de Administrador.
     */
    public Administrador build() {
        // Crea una instancia de Administrador usando los valores configurados en el builder
        return new Administrador(nombres, apellidos, cedula, direccion, usuario);
    }
}
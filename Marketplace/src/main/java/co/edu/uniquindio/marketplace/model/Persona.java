package co.edu.uniquindio.marketplace.model;

/**
 *
 */
public class Persona {
    private String nombres;
    private String apellidos;
    private String cedula;
    private String direccion;
    private Usuario usuario;

    /**
     *
     */
    public Persona() {
    }

    /**
     *
     * @param nombres
     * @param apellidos
     * @param cedula
     * @param direccion
     * @param usuario
     */
    public Persona(String nombres, String apellidos, String cedula, String direccion, Usuario usuario) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    /**
     *
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}

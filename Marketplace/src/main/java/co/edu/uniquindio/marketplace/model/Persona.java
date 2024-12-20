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
        if (nombres == null || nombres.isEmpty()){
            throw new IllegalArgumentException("Los nombres no pueden ser nulos ni estar vacíos");
        }
        if (apellidos == null || apellidos.isEmpty()){
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos ni estar vacíos");
        }
        if (cedula == null || cedula.isEmpty()){
            throw new IllegalStateException("La cedula no puede ser nula ni estar vacía");
        }
        if (direccion == null || direccion.isEmpty()){
            throw new IllegalStateException("La dirección no puede ser nula ni estar vacía");
        }
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
        if (nombres == null || nombres.isEmpty()){
            throw new IllegalStateException("Los nombres no pueden ser nulos");
        }
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
        if (apellidos == null || apellidos.isEmpty()){
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos ni estar vacíos");
        }
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
        if (cedula == null || cedula.isEmpty()){
            throw new IllegalStateException("La cedula no puede ser nula ni estar vacía");
        }
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
        if (direccion == null || direccion.isEmpty()){
            throw new IllegalStateException("La dirección no puede ser nula ni estar vacía");
        }
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

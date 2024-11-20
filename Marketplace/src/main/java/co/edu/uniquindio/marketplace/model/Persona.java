package co.edu.uniquindio.marketplace.model;

// Clase que representa una persona, con datos personales y un usuario asociado
public class Persona {
    private String nombres;    // Nombres de la persona
    private String apellidos;  // Apellidos de la persona
    private String cedula;     // Cédula de la persona
    private String direccion;  // Dirección de la persona
    private Usuario usuario;   // Usuario asociado a la persona

    /**
     * Constructor vacío de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor para crear una persona con datos completos.
     *
     * @param nombres Nombres de la persona
     * @param apellidos Apellidos de la persona
     * @param cedula Cédula de la persona
     * @param direccion Dirección de la persona
     * @param usuario Usuario asociado a la persona
     * @throws IllegalArgumentException Si los nombres o apellidos son nulos o vacíos
     * @throws IllegalStateException Si la cédula o dirección son nulos o vacíos
     */
    public Persona(String nombres, String apellidos, String cedula, String direccion, Usuario usuario) {
        // Validaciones de los atributos
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
        this.nombres = nombres;       // Asigna el nombre a la persona
        this.apellidos = apellidos;   // Asigna los apellidos a la persona
        this.cedula = cedula;         // Asigna la cédula a la persona
        this.direccion = direccion;   // Asigna la dirección a la persona
        this.usuario = usuario;       // Asigna el usuario asociado
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona
     */
    public String getNombres() {
        return nombres;  // Devuelve el nombre de la persona
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombres Nombre de la persona
     * @throws IllegalStateException Si el nombre es nulo o vacío
     */
    public void setNombres(String nombres) {
        if (nombres == null || nombres.isEmpty()){
            throw new IllegalStateException("Los nombres no pueden ser nulos");
        }
        this.nombres = nombres;  // Asigna el nombre a la persona
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Los apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;  // Devuelve los apellidos de la persona
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos Apellidos de la persona
     * @throws IllegalArgumentException Si los apellidos son nulos o vacíos
     */
    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.isEmpty()){
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos ni estar vacíos");
        }
        this.apellidos = apellidos;  // Asigna los apellidos a la persona
    }

    /**
     * Obtiene la cédula de la persona.
     *
     * @return La cédula de la persona
     */
    public String getCedula() {
        return cedula;  // Devuelve la cédula de la persona
    }

    /**
     * Establece la cédula de la persona.
     *
     * @param cedula Cédula de la persona
     * @throws IllegalStateException Si la cédula es nula o vacía
     */
    public void setCedula(String cedula) {
        if (cedula == null || cedula.isEmpty()){
            throw new IllegalStateException("La cedula no puede ser nula ni estar vacía");
        }
        this.cedula = cedula;  // Asigna la cédula a la persona
    }

    /**
     * Obtiene la dirección de la persona.
     *
     * @return La dirección de la persona
     */
    public String getDireccion() {
        return direccion;  // Devuelve la dirección de la persona
    }

    /**
     * Establece la dirección de la persona.
     *
     * @param direccion Dirección de la persona
     * @throws IllegalStateException Si la dirección es nula o vacía
     */
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()){
            throw new IllegalStateException("La dirección no puede ser nula ni estar vacía");
        }
        this.direccion = direccion;  // Asigna la dirección a la persona
    }

    /**
     * Obtiene el usuario asociado a la persona.
     *
     * @return El usuario asociado a la persona
     */
    public Usuario getUsuario() {
        return usuario;  // Devuelve el usuario asociado a la persona
    }

    /**
     * Establece el usuario asociado a la persona.
     *
     * @param usuario Usuario asociado a la persona
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;  // Asigna el usuario a la persona
    }

    /**
     * Devuelve una representación en cadena de la persona, incluyendo sus datos principales.
     *
     * @return Una cadena representativa de la persona
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario=" + usuario +
                '}';  // Devuelve una representación de la persona
    }
}


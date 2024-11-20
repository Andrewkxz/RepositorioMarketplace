package co.edu.uniquindio.marketplace.model;

// Clase que representa un objeto con nombre e identificador único
public class Objeto {
    private String nombre;      // Nombre del objeto
    private String idObjeto;    // Identificador único del objeto

    /**
     * Constructor para crear un objeto con nombre e idObjeto.
     *
     * @param nombre Nombre del objeto
     * @param idObjeto Identificador único del objeto
     * @throws IllegalArgumentException Si el nombre o el idObjeto son nulos o vacíos
     */
    public Objeto(String nombre, String idObjeto) {
        if (nombre == null || nombre.isEmpty()){  // Verifica que el nombre no sea nulo ni vacío
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }
        if (idObjeto == null || idObjeto.isEmpty()){  // Verifica que el idObjeto no sea nulo ni vacío
            throw new IllegalArgumentException("El idObjeto del objeto no puede ser nulo.");
        }
        this.nombre = nombre;  // Asigna el nombre al objeto
        this.idObjeto = idObjeto;  // Asigna el idObjeto al objeto
    }

    /**
     * Obtiene el nombre del objeto.
     *
     * @return El nombre del objeto
     */
    public String getNombre() {
        return nombre;  // Devuelve el nombre del objeto
    }

    /**
     * Establece el nombre del objeto.
     *
     * @param nombre Nombre que se desea asignar al objeto
     * @throws IllegalArgumentException Si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()){  // Verifica que el nombre no sea nulo ni vacío
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }
        this.nombre = nombre;  // Asigna el nuevo nombre al objeto
    }

    /**
     * Obtiene el identificador del objeto.
     *
     * @return El identificador único del objeto
     */
    public String getIdObjeto() {
        return idObjeto;  // Devuelve el idObjeto del objeto
    }

    /**
     * Establece el identificador del objeto.
     *
     * @param idObjeto Identificador que se desea asignar al objeto
     * @throws IllegalArgumentException Si el idObjeto es nulo o vacío
     */
    public void setIdObjeto(String idObjeto) {
        if (idObjeto == null || idObjeto.isEmpty()){  // Verifica que el idObjeto no sea nulo ni vacío
            throw new IllegalArgumentException("El identificador del objeto no puede ser nulo.");
        }
        this.idObjeto = idObjeto;  // Asigna el nuevo idObjeto al objeto
    }

    /**
     * Devuelve una representación en cadena del objeto.
     *
     * @return Una cadena con el nombre y el idObjeto del objeto
     */
    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +  // Muestra el nombre del objeto
                ", idObjeto='" + idObjeto + '\'' +  // Muestra el idObjeto del objeto
                '}';
    }
}

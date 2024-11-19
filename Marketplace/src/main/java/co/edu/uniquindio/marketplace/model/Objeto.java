package co.edu.uniquindio.marketplace.model;

/**
 *
 */
public class Objeto {
    private String nombre;
    private String idObjeto;

    /**
     *
     * @param nombre
     * @param idObjeto
     */
    public Objeto(String nombre, String idObjeto) {
        if (nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }
        if (idObjeto == null || idObjeto.isEmpty()){
            throw new IllegalArgumentException("El idObjeto del objeto no puede ser nulo.");
        }
        this.nombre = nombre;
        this.idObjeto = idObjeto;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getIdObjeto() {
        return idObjeto;
    }

    /**
     *
     * @param idObjeto
     */
    public void setIdObjeto(String idObjeto) {
        if (idObjeto == null || idObjeto.isEmpty()){
            throw new IllegalArgumentException("El identificador del objeto no puede ser nulo.");
        }
        this.idObjeto = idObjeto;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", idObjeto='" + idObjeto + '\'' +
                '}';
    }
}

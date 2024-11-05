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

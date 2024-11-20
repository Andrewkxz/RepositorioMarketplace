package co.edu.uniquindio.marketplace.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Administrador: Representa a un administrador que extiende de la clase Persona.
 * Un administrador gestiona una lista de vendedores y tiene la capacidad de realizar operaciones sobre ellos y sus productos.
 */
public class Administrador extends Persona {

    private List<Vendedor> vendedores;

    /**
     * Constructor sin parámetros. Inicializa el administrador sin configurar atributos específicos.
     */
    public Administrador() {
    }

    /**
     * Constructor con parámetros.
     * Inicializa un administrador con los datos proporcionados y una lista vacía de vendedores.
     *
     * @param nombres Nombres del administrador.
     * @param apellidos Apellidos del administrador.
     * @param cedula Cédula del administrador.
     * @param direccion Dirección del administrador.
     * @param usuario Objeto Usuario asociado al administrador.
     */
    public Administrador(String nombres, String apellidos, String cedula, String direccion, Usuario usuario) {
        super(nombres, apellidos, cedula, direccion, usuario);
        this.vendedores = new ArrayList<>();
    }

    /**
     * Agrega un vendedor a la lista de vendedores.
     *
     * @param vendedor El vendedor a agregar.
     * @return true si el vendedor fue agregado exitosamente, false si ya existe o es nulo.
     */
    public boolean agregarVendedor(Vendedor vendedor) {
        if (vendedor != null && !vendedores.contains(vendedor)) {
            vendedores.add(vendedor);
            return true;
        }
        return false;
    }

    /**
     * Elimina un vendedor de la lista según su cédula.
     *
     * @param cedula La cédula del vendedor a eliminar.
     * @return true si el vendedor fue eliminado, false si no se encontró o si la cédula es inválida.
     */
    public boolean eliminarVendedor(String cedula) {
        if (cedula != null && !cedula.isEmpty()) {
            return vendedores.removeIf(vendedor -> vendedor.getCedula().equals(cedula));
        }
        return false;
    }

    /**
     * Devuelve una lista de vendedores asociados al administrador.
     *
     * @return Una copia de la lista de vendedores.
     */
    public List<Vendedor> listarVendedores() {
        return new ArrayList<>(vendedores);
    }

    /**
     * Actualiza la información de un vendedor existente.
     *
     * @param id La cédula del vendedor a actualizar.
     * @param vendedorActualizado Objeto Vendedor con los datos actualizados.
     * @return true si la actualización fue exitosa, false si el vendedor no se encontró o los datos son inválidos.
     */
    public boolean actualizarVendedor(String id, Vendedor vendedorActualizado) {
        if (id == null || id.isEmpty() || vendedorActualizado == null) {
            return false;
        }
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getCedula().equals(id)) {
                vendedores.set(i, vendedorActualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Lista todos los productos asociados a los vendedores que administra.
     *
     * @return Una lista de productos de todos los vendedores.
     */
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        for (Vendedor vendedor : vendedores) {
            productos.addAll(vendedor.listarProductos());
        }
        return productos;
    }

    /**
     * Establece la lista de vendedores gestionados por el administrador.
     *
     * @param vendedores Lista de vendedores a asignar.
     */
    public void setVendedores(List<Vendedor> vendedores) {
        if (vendedores != null && !vendedores.isEmpty()) {
            this.vendedores = vendedores;
        }
    }
}

package co.edu.uniquindio.marketplace.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Administrador extends Persona{
    private List<Vendedor> vendedores;

    /**
     *
     */
    public Administrador() {
    }

    /**
     *
     * @param nombres
     * @param apellidos
     * @param cedula
     * @param direccion
     * @param usuario
     */
    public Administrador (String nombres, String apellidos, String cedula, String direccion, Usuario usuario){
        super(nombres, apellidos, cedula, direccion, usuario);
        this.vendedores = new ArrayList<>();
    }

    /**
     *
     * @param vendedor
     * @return
     */
    public boolean agregarVendedor(Vendedor vendedor){
        if (vendedor != null && !vendedores.contains(vendedor)) {
            vendedores.add(vendedor);
            return true;
        }
        return false;
    }

    /**
     *
     * @param cedula
     * @return
     */
    public boolean eliminarVendedor(String cedula) {
        if (cedula != null && !cedula.isEmpty()) {
            return vendedores.removeIf(vendedor -> vendedor.getCedula().equals(cedula));
        }
        return false;
    }

    /**
     *
     * @return
     */
    public List<Vendedor> listarVendedores() {
        return new ArrayList<>(vendedores);
    }

    /**
     *
     * @param id
     * @param vendedorActualizado
     * @return
     */
    public boolean actualizarVendedor(String id, Vendedor vendedorActualizado){
        if (id == null || !id.isEmpty() || vendedorActualizado == null) {
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
     *
     * @return
     */
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        for(Vendedor vendedor : vendedores){
            productos.addAll(vendedor.listarProductos());
        }
        return productos;
    }

    /**
     *
     * @param vendedores
     */
    public void setVendedores(List<Vendedor> vendedores) {
        if (vendedores != null && !vendedores.isEmpty()) {
            this.vendedores = vendedores;
        }
    }

}

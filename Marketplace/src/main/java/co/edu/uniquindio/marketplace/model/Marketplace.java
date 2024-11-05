package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.services.ICrudVendedor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class Marketplace implements ICrudVendedor {
    private String nombre;
    private List<Vendedor> listVendedores = new ArrayList<>();
    private List<Administrador> listAdministradores = new ArrayList<>();
    private List<Usuario> listUsuarios = new ArrayList<>();

    /**
     *
     */
    public Marketplace() {
    }

    /**
     *
     * @param nombre
     */
    public Marketplace(String nombre) {
        this.nombre = nombre;
    }

    public void agregarUsuario(Usuario usuario) {
        listUsuarios.add(usuario);
    }

    public Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : listUsuarios) {
            if(usuario.getUsuario().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    //------------------------------- CRUD VENDEDOR -----------------------

    /**
     *
     * @param newVendedor
     * @return
     */
    @Override
    public boolean crearVendedor(Vendedor newVendedor) {
        if (newVendedor != null && !verificarVendedorExistente(newVendedor.getCedula())) {
            listVendedores.add(newVendedor);
            return true;
        }
        return false;
    }

    /**
     *
     * @param cedula
     * @return
     */
    @Override
    public boolean eliminarVendedor(String cedula) {
        Vendedor vendedor = buscarVendedor(cedula);
        if (vendedor != null) {
            listVendedores.remove(vendedor);
            return true;
        }
        return false;
    }

    /**
     *
     * @param cedula
     * @param vendedor
     * @return
     */
    @Override
    public boolean actualizarVendedor(String cedula, Vendedor vendedor) {
        Vendedor vendedorExistente = buscarVendedor(cedula);
        if(vendedorExistente != null) {
            vendedorExistente.setCedula(vendedor.getCedula());
            vendedorExistente.setNombres(vendedor.getNombres());
            vendedorExistente.setApellidos(vendedor.getApellidos());
            vendedorExistente.setDireccion(vendedor.getDireccion());
            vendedorExistente.setUsuario(vendedor.getUsuario());

            return true;
        }
        return false;
    }

    /**
     *
     * @param cedula
     * @return
     */
    @Override
    public Vendedor buscarVendedor(String cedula) {
        for (Vendedor vendedor : listVendedores){
            if(vendedor.getCedula().equals(cedula)){
                return vendedor;
            }
        }
        return null;
    }

    /**
     *
     * @param cedula
     * @return
     */
    @Override
    public boolean verificarVendedorExistente(String cedula) {
        for (Vendedor vendedor : listVendedores){
            if(vendedor.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }
    //------------------------------- CRUD VENDEDOR -----------------------

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
    public List<Vendedor> getListVendedores() {
        return listVendedores;
    }

    /**
     *
     * @param listVendedores
     */
    public void setListVendedores(List<Vendedor> listVendedores) {
        this.listVendedores = listVendedores;
    }

    /**
     *
     * @return
     */
    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    /**
     *
     * @param listAdministradores
     */
    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    /**
     *
     * @return
     */
    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    /**
     *
     * @param listUsuarios
     */
    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }
}

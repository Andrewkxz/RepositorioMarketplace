package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.services.ICrudVendedor;

import java.util.ArrayList;
import java.util.List;

public class Marketplace implements ICrudVendedor {
    private String nombre;
    private List<Vendedor> listVendedores = new ArrayList<>();
    private List<Administrador> listAdministradores = new ArrayList<>();
    private List<Usuario> listUsuarios = new ArrayList<>();

    public Marketplace() {
    }

    public Marketplace(String nombre) {
        this.nombre = nombre;
    }

    //------------------------------- CRUD VENDEDOR -----------------------
    @Override
    public boolean crearVendedor(Vendedor newVendedor) {
        if (newVendedor != null) {
            getListVendedores().add(newVendedor);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        for (Vendedor vendedor : getListVendedores()) {
            if (vendedor.getCedula().equals(cedula)) {
                getListVendedores().remove(vendedor);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean actualizarVendedor(String cedula, Vendedor vendedor) {

        Vendedor vendedorExistente = buscarVendedor(cedula);

        if(vendedorExistente == null) {
            vendedorExistente.setCedula(vendedor.getCedula());
            vendedorExistente.setNombres(vendedor.getNombres());
            vendedorExistente.setApellidos(vendedor.getApellidos());
            vendedorExistente.setDireccion(vendedor.getDireccion());
            vendedorExistente.setUsuario(vendedor.getUsuario());

            return true;
        }
        return false;
    }

    @Override
    public Vendedor buscarVendedor(String cedula) {
        for (Vendedor vendedor : listVendedores){
            if(vendedor.getCedula().equals(cedula)){
                return vendedor;
            }
        }
        return null;
    }

    @Override
    public boolean verificarVendedorExistente(String cedula) {
        Vendedor vendedorExistente = null;
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getCedula().equals(cedula)){
                vendedorExistente = vendedor;
                break;
            }
        }
        if(vendedorExistente == null) {
            return true;
        }
        return false;
    }
    //------------------------------- CRUD VENDEDOR -----------------------


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vendedor> getListVendedores() {
        return listVendedores;
    }

    public void setListVendedores(List<Vendedor> listVendedores) {
        this.listVendedores = listVendedores;
    }

    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }
}

package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.services.IAutenticacionProxy;
import co.edu.uniquindio.marketplace.services.ICrudProducto;
import co.edu.uniquindio.marketplace.services.ICrudVendedor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */

public class Marketplace implements ICrudVendedor, ICrudProducto, IAutenticacionProxy {
    private String nombre;
    private List<Vendedor> listVendedores = new ArrayList<>();
    private List<Administrador> listAdministradores = new ArrayList<>();
    private List<Usuario> listUsuarios = new ArrayList<>();
    private Autenticacion autenticacion = new Autenticacion(getListVendedores());
    private FacadePublicar facadePublicar = new FacadePublicar();

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


    public boolean registrarUsuario(String nombres, String apellidos, String cedula, String direccion, String nombreUsuario, String contrasenia, String rol) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getContrasenia().equals(contrasenia)) {
                return false;
            }
        }
        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasenia, rol);

        if (rol.equalsIgnoreCase("Vendedor")){
            Vendedor vendedor = new Vendedor(nombres, apellidos, cedula, direccion, nuevoUsuario);
            listVendedores.add(vendedor);
            listUsuarios.add(nuevoUsuario);
        }else if (rol.equalsIgnoreCase("Administrador")){
            Administrador administrador = new Administrador(nombres, apellidos, cedula, direccion, nuevoUsuario);
            listAdministradores.add(administrador);
            listUsuarios.add(nuevoUsuario);
        }else {
            return false;
        }
        return true;
    }

    public void interactuar (Vendedor emisor, Producto producto, String contenido, Vendedor receptor) {
        facadePublicar.crearPublicacion(emisor,producto);
        facadePublicar.crearComentario(emisor, contenido);
        facadePublicar.crearMensaje(emisor,contenido,receptor);
    }

    public Usuario buscarUsuario(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser vacío");
        }
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
        if (cedula == null || cedula.isEmpty()) {
            throw new IllegalArgumentException("La cedula es requerida");
        }
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

    @Override
    public boolean crearProducto(Producto newProducto) {
        return false;
    }

    @Override
    public boolean eliminarProducto(String id) {
        return false;
    }

    @Override
    public boolean actualizarProducto(String id, Producto producto) {
        return false;
    }

    @Override
    public Producto buscarProducto(String id) {
        return null;
    }

    @Override
    public boolean verificarProductoExistente(String idProducto) {
        return false;
    }

    @Override
    public boolean autenticar(UsuarioDto usuarioDto) {
        String usuario = usuarioDto.usuario();
        System.out.printf("Verificando que el usuario: " + usuario + "no exista");
        boolean permitirAcceso = autenticacion.autenticar(usuarioDto);
        if (permitirAcceso) {
            System.out.printf("Acceso permitido para el usuario: " + usuario);
        } else {
            System.out.println("Acceso denegado para el usuario: " + usuario);
        }
        return permitirAcceso;
    }
}

package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.services.ICrudProducto;
import co.edu.uniquindio.marketplace.services.ICrudVendedor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Clase que representa el marketplace, donde se gestionan usuarios, vendedores y administradores
public class Marketplace implements ICrudVendedor, ICrudProducto {
    private String nombre;  // Nombre del marketplace
    private List<Vendedor> listVendedores = new ArrayList<>();  // Lista de vendedores registrados
    private List<Administrador> listAdministradores = new ArrayList<>();  // Lista de administradores registrados
    private List<Usuario> listUsuarios = new ArrayList<>();  // Lista de todos los usuarios registrados

    // Constructor vacío
    public Marketplace() {
    }

    // Constructor con nombre del marketplace
    public Marketplace(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para registrar un nuevo usuario en el marketplace.
     *
     * @param nombres Nombres del usuario
     * @param apellidos Apellidos del usuario
     * @param cedula Cédula de identidad del usuario
     * @param direccion Dirección del usuario
     * @param nombreUsuario Nombre de usuario para el login
     * @param contrasenia Contraseña del usuario
     * @param rol Rol del usuario (Vendedor o Administrador)
     * @return Retorna true si el registro fue exitoso, false si ya existe un usuario con la misma contraseña.
     */
    public boolean registrarUsuario(String nombres, String apellidos, String cedula, String direccion, String nombreUsuario, String contrasenia, String rol) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getContrasenia().equals(contrasenia)) {
                return false;  // Si ya existe un usuario con la misma contraseña, no se permite el registro.
            }
        }
        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasenia, rol);  // Se crea un nuevo usuario

        // Se verifica el rol y se crea un vendedor o administrador dependiendo del caso
        if (rol.equalsIgnoreCase("Vendedor")) {
            Vendedor vendedor = new Vendedor(nombres, apellidos, cedula, direccion, nuevoUsuario);
            listVendedores.add(vendedor);  // Se agrega el vendedor a la lista de vendedores
            listUsuarios.add(nuevoUsuario);  // Se agrega el usuario a la lista de usuarios
        } else if (rol.equalsIgnoreCase("Administrador")) {
            Administrador administrador = new Administrador(nombres, apellidos, cedula, direccion, nuevoUsuario);
            listAdministradores.add(administrador);  // Se agrega el administrador a la lista de administradores
            listUsuarios.add(nuevoUsuario);  // Se agrega el usuario a la lista de usuarios
        } else {
            return false;  // Si el rol no es válido, se retorna false
        }
        return true;  // Registro exitoso
    }

    /**
     * Método para buscar un usuario por su nombre de usuario.
     *
     * @param nombre Nombre de usuario a buscar.
     * @return El usuario si se encuentra, null si no existe un usuario con ese nombre.
     * @throws IllegalArgumentException Si el nombre de usuario es nulo o vacío.
     */
    public Usuario buscarUsuario(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser vacío");
        }
        for (Usuario usuario : listUsuarios) {
            if (usuario.getUsuario().equals(nombre)) {  // Se compara el nombre del usuario con la lista
                return usuario;
            }
        }
        return null;  // Si no se encuentra el usuario, retorna null
    }

    //------------------------------- CRUD VENDEDOR -----------------------

    /**
     * Método para crear un nuevo vendedor.
     *
     * @param newVendedor El vendedor a ser creado
     * @return Retorna true si el vendedor fue creado exitosamente, false si ya existe un vendedor con la misma cédula.
     */
    @Override
    public boolean crearVendedor(Vendedor newVendedor) {
        if (newVendedor != null && !verificarVendedorExistente(newVendedor.getCedula())) {
            listVendedores.add(newVendedor);  // Se agrega el vendedor a la lista
            return true;  // Vendedor creado exitosamente
        }
        return false;  // Si el vendedor ya existe, no se crea
    }

    /**
     * Método para eliminar un vendedor.
     *
     * @param cedula La cédula del vendedor a eliminar
     * @return Retorna true si el vendedor fue eliminado exitosamente, false si no se encontró el vendedor.
     */
    @Override
    public boolean eliminarVendedor(String cedula) {
        Vendedor vendedor = buscarVendedor(cedula);  // Se busca al vendedor por cédula
        if (vendedor != null) {
            listVendedores.remove(vendedor);  // Se elimina el vendedor de la lista
            return true;
        }
        return false;  // Si no se encuentra el vendedor, no se elimina
    }

    /**
     * Método para actualizar los datos de un vendedor.
     *
     * @param cedula La cédula del vendedor a actualizar
     * @param vendedor El vendedor con los nuevos datos
     * @return Retorna true si los datos fueron actualizados exitosamente, false si no se encontró el vendedor.
     */
    @Override
    public boolean actualizarVendedor(String cedula, Vendedor vendedor) {
        Vendedor vendedorExistente = buscarVendedor(cedula);  // Se busca al vendedor por cédula
        if (vendedorExistente != null) {
            // Se actualizan los datos del vendedor
            vendedorExistente.setCedula(vendedor.getCedula());
            vendedorExistente.setNombres(vendedor.getNombres());
            vendedorExistente.setApellidos(vendedor.getApellidos());
            vendedorExistente.setDireccion(vendedor.getDireccion());
            vendedorExistente.setUsuario(vendedor.getUsuario());
            return true;  // Los datos fueron actualizados
        }
        return false;  // Si no se encuentra el vendedor, no se actualizan los datos
    }

    /**
     * Método para buscar un vendedor por su cédula.
     *
     * @param cedula La cédula del vendedor a buscar
     * @return El vendedor si se encuentra, null si no existe un vendedor con esa cédula.
     * @throws IllegalArgumentException Si la cédula es nula o vacía.
     */
    @Override
    public Vendedor buscarVendedor(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            throw new IllegalArgumentException("La cedula es requerida");
        }
        for (Vendedor vendedor : listVendedores) {
            if (vendedor.getCedula().equals(cedula)) {  // Se compara la cédula del vendedor con la lista
                return vendedor;
            }
        }
        return null;  // Si no se encuentra el vendedor, retorna null
    }

    /**
     * Método para verificar si un vendedor con la misma cédula ya existe en la lista.
     *
     * @param cedula La cédula del vendedor a verificar
     * @return Retorna true si ya existe un vendedor con esa cédula, false si no existe.
     */
    @Override
    public boolean verificarVendedorExistente(String cedula) {
        for (Vendedor vendedor : listVendedores) {
            if (vendedor.getCedula().equals(cedula)) {  // Se verifica si la cédula ya existe
                return true;
            }
        }
        return false;  // Si no existe, retorna false
    }
    //------------------------------- CRUD VENDEDOR -----------------------

    /**
     * Método para obtener el nombre del marketplace.
     *
     * @return El nombre del marketplace.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del marketplace.
     *
     * @param nombre El nombre del marketplace.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la lista de vendedores registrados en el marketplace.
     *
     * @return Lista de vendedores.
     */
    public List<Vendedor> getListVendedores() {
        return listVendedores;
    }

    /**
     * Método para establecer la lista de vendedores registrados en el marketplace.
     *
     * @param listVendedores La lista de vendedores.
     */
    public void setListVendedores(List<Vendedor> listVendedores) {
        this.listVendedores = listVendedores;
    }

    /**
     * Método para obtener la lista de administradores registrados en el marketplace.
     *
     * @return Lista de administradores.
     */
    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    /**
     * Método para establecer la lista de administradores registrados en el marketplace.
     *
     * @param listAdministradores La lista de administradores.
     */
    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    /**
     * Método para obtener la lista de usuarios registrados en el marketplace.
     *
     * @return Lista de usuarios.
     */
    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    /**
     * Método para establecer la lista de usuarios registrados en el marketplace.
     *
     * @param listUsuarios La lista de usuarios.
     */
    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    //------------------------------- CRUD PRODUCTO -----------------------

    @Override
    public boolean crearProducto(Producto newProducto) {
        return false;  // Método no implementado
    }

    @Override
    public boolean eliminarProducto(String id) {
        return false;  // Método no implementado
    }

    @Override
    public boolean actualizarProducto(String id, Producto producto) {
        return false;  // Método no implementado
    }

    @Override
    public Producto buscarProducto(String id) {
        return null;  // Método no implementado
    }

    @Override
    public boolean verificarProductoExistente(String idProducto) {
        return false;  // Método no implementado
    }
}
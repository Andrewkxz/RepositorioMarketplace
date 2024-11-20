package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.model.Vendedor;

public interface IRegistroControllerServices {
    boolean verificarUsuario(Usuario usuario);
    boolean verificarCedula(String cedula);
    boolean crearVendedor(VendedorDto vendedor);
    boolean eliminarVendedor(String cedula);
    boolean actualizarVendedor(String cedula, VendedorDto vendedor);
}

package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.model.Vendedor;

public interface ICrudVendedor {
    boolean crearVendedor(Vendedor newVendedor);
    boolean eliminarVendedor(String cedula);
    boolean actualizarVendedor(String cedula, Vendedor vendedor);
    Vendedor buscarVendedor(String cedula);
    boolean verificarVendedorExistente(String cedula);
}

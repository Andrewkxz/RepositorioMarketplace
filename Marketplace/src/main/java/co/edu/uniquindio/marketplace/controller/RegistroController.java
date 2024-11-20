package co.edu.uniquindio.marketplace.controller;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.services.IRegistroControllerServices;

public class RegistroController implements IRegistroControllerServices {
    ModelFactory modelFactory;

    @Override
    public boolean verificarUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean verificarCedula(String cedula) {
        return modelFactory.buscarVendedor(cedula) != null;
    }

    @Override
    public boolean crearVendedor(VendedorDto vendedor) {
        return modelFactory.agregarVendedor(vendedor);
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        return modelFactory.eliminarVendedor(cedula);
    }

    @Override
    public boolean actualizarVendedor(String cedula, VendedorDto vendedor) {
        return false;
    }
}

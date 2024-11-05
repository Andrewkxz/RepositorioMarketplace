package co.edu.uniquindio.marketplace.controller;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.services.IVendedorControllerService;

import java.util.List;

/**
 *
 */
public class VendedorController implements IVendedorControllerService {
    ModelFactory modelFactory;

    /**
     *
     */
    public VendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    /**
     *
     * @return
     */
    @Override
    public List<VendedorDto> obtenerVendedoresDto() {
        return modelFactory.obtenerVendedoresDto();
    }

    /**
     *
     * @param vendedorDto
     * @return
     */
    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        return modelFactory.agregarVendedor(vendedorDto);
    }

    /**
     *
     * @param cedulaActual
     * @param vendedorDto
     * @return
     */
    @Override
    public boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto) {
        return modelFactory.actualizarVendedor(cedulaActual, vendedorDto);
    }

    /**
     *
     * @param cedula
     * @return
     */
    @Override
    public boolean eliminarVendedor(String cedula) {
        return modelFactory.eliminarVendedor(cedula);
    }
}
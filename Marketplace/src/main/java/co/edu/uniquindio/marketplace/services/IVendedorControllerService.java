package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;

import java.util.List;

public interface IVendedorControllerService {
    List<VendedorDto> obtenerVendedoresDto();
    boolean agregarVendedor(VendedorDto vendedor);
    boolean actualizarVendedor(String cedulaActual, VendedorDto vendedor);
    boolean eliminarVendedor(String cedula);

}

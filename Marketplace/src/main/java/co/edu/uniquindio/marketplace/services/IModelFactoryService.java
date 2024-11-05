package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;

import java.util.List;

/**
 *
 */
public interface IModelFactoryService {
    List<VendedorDto> obtenerVendedoresDto();
    boolean agregarVendedor(VendedorDto vendedorDto);
    boolean eliminarVendedor(String cedula);
    boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto);
    VendedorDto buscarVendedor(String texto);
    List<VendedorDto> sugerirVendedores(String cedula);

}

package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;

import java.util.List;

/**
 * Interfaz para gestionar operaciones relacionadas con vendedores en el Marketplace.
 */
public interface IVendedorControllerService {

    /**
     * Obtiene una lista de DTOs de vendedores.
     *
     * @return Una lista de DTOs de vendedores.
     */
    List<VendedorDto> obtenerVendedoresDto();

    /**
     * Agrega un nuevo vendedor.
     *
     * @param vendedor El DTO del vendedor a agregar.
     * @return true si el vendedor fue agregado con éxito, false en caso contrario.
     */
    boolean agregarVendedor(VendedorDto vendedor);

    /**
     * Actualiza la información de un vendedor existente.
     *
     * @param cedulaActual La cédula del vendedor a actualizar.
     * @param vendedor El DTO con la nueva información del vendedor.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    boolean actualizarVendedor(String cedulaActual, VendedorDto vendedor);

    /**
     * Elimina un vendedor.
     *
     * @param cedula La cédula del vendedor a eliminar.
     * @return true si el vendedor fue eliminado con éxito, false en caso contrario.
     */
    boolean eliminarVendedor(String cedula);
}

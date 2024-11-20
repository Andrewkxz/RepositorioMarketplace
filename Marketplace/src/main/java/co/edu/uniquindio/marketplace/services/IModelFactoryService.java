package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;

import java.util.List;

/**
 * Interfaz para gestionar operaciones relacionadas con vendedores en el Marketplace.
 */
public interface IModelFactoryService {

    /**
     * Obtiene una lista de DTOs de vendedores.
     *
     * @return La lista de DTOs de vendedores.
     */
    List<VendedorDto> obtenerVendedoresDto();

    /**
     * Agrega un nuevo vendedor.
     *
     * @param vendedorDto El DTO del vendedor a agregar.
     * @return true si el vendedor fue agregado con éxito, false en caso contrario.
     */
    boolean agregarVendedor(VendedorDto vendedorDto);

    /**
     * Elimina un vendedor por su cédula.
     *
     * @param cedula La cédula del vendedor a eliminar.
     * @return true si el vendedor fue eliminado con éxito, false en caso contrario.
     */
    boolean eliminarVendedor(String cedula);

    /**
     * Actualiza los datos de un vendedor.
     *
     * @param cedulaActual La cédula del vendedor a actualizar.
     * @param vendedorDto Los nuevos datos del vendedor.
     * @return true si el vendedor fue actualizado con éxito, false en caso contrario.
     */
    boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto);

    /**
     * Busca un vendedor por texto (por ejemplo, nombre o cédula).
     *
     * @param texto El texto de búsqueda.
     * @return El DTO del vendedor encontrado, o null si no se encuentra.
     */
    VendedorDto buscarVendedor(String texto);

    /**
     * Sugerir vendedores en base a la cédula del usuario.
     *
     * @param cedula La cédula del usuario para sugerir vendedores relacionados.
     * @return Una lista de DTOs de vendedores sugeridos.
     */
    List<VendedorDto> sugerirVendedores(String cedula);
}

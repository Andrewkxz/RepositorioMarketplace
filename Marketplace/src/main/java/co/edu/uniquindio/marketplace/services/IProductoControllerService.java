package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;

import java.util.List;

/**
 * Interfaz para gestionar operaciones relacionadas con productos en el Marketplace.
 */
public interface IProductoControllerService {

    /**
     * Obtiene una lista de DTOs de productos.
     *
     * @return Una lista de DTOs de productos.
     */
    List<ProductoDto> getProductosDto();

    /**
     * Agrega un nuevo producto.
     *
     * @param producto El DTO del producto a agregar.
     * @return true si el producto fue agregado con éxito, false en caso contrario.
     */
    boolean agregarProducto(ProductoDto producto);
}

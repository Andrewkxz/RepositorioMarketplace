package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.model.Vendedor;

import java.util.List;

/**
 * Interfaz para mapear objetos entre entidades y DTOs en el Marketplace.
 */
public interface IMarketplaceMapping {

    /**
     * Convierte una lista de vendedores a una lista de DTOs de vendedores.
     *
     * @param listaVendedores La lista de vendedores a convertir.
     * @return La lista de DTOs de vendedores.
     */
    List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores);

    /**
     * Convierte un vendedor a su DTO correspondiente.
     *
     * @param vendedor El vendedor a convertir.
     * @return El DTO correspondiente al vendedor.
     */
    VendedorDto vendedorToVendedorDto(Vendedor vendedor);

    /**
     * Convierte un DTO de vendedor a un vendedor.
     *
     * @param vendedorDto El DTO de vendedor a convertir.
     * @return El vendedor correspondiente al DTO.
     */
    Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);

    /**
     * Convierte una lista de productos a una lista de DTOs de productos.
     *
     * @param listaProductos La lista de productos a convertir.
     * @return La lista de DTOs de productos.
     */
    List<ProductoDto> getProductosDto(List<Producto> listaProductos);

    /**
     * Convierte un producto a su DTO correspondiente.
     *
     * @param producto El producto a convertir.
     * @return El DTO correspondiente al producto.
     */
    ProductoDto productoToProductoDto(Producto producto);

    /**
     * Convierte un DTO de producto a un producto.
     *
     * @param productoDto El DTO de producto a convertir.
     * @return El producto correspondiente al DTO.
     */
    Producto productoDtoToProducto(ProductoDto productoDto);
}


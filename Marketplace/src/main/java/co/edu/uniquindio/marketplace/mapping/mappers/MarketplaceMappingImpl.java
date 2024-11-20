package co.edu.uniquindio.marketplace.mapping.mappers;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.services.IMarketplaceMapping;

import java.util.ArrayList;
import java.util.List;
/**
 * La clase MarketplaceMappingImpl implementa la interfaz IMarketplaceMapping y se encarga de realizar las conversiones
 * entre los objetos del dominio (`Vendedor`, `Producto`) y sus respectivos DTOs (`VendedorDto`, `ProductoDto`).
 * La clase facilita la transferencia de datos entre capas, como la capa de presentación y la capa de servicio.
 */
public class MarketplaceMappingImpl implements IMarketplaceMapping {

    /**
     * Convierte una lista de objetos `Vendedor` en una lista de `VendedorDto`.
     * Este método es útil para transformar los datos de los vendedores en un formato más adecuado para la presentación o
     * la transferencia a través de la red (DTO).
     *
     * @param listaVendedores - Lista de objetos `Vendedor` a convertir.
     * @return - Lista de objetos `VendedorDto` resultante de la conversión.
     */
    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
        if (listaVendedores == null) {
            return null;
        }

        List<VendedorDto> vendedoresDto = new ArrayList<>();
        for (Vendedor vendedor : listaVendedores) {

            vendedoresDto.add(vendedorToVendedorDto(vendedor));
        }

        return vendedoresDto;
    }

    /**
     * Convierte un objeto `Vendedor` en un objeto `VendedorDto`.
     * Este método extrae los datos del objeto `Vendedor` y los encapsula en un DTO para su uso en otras capas.
     *
     * @param vendedor - El objeto `Vendedor` a convertir.
     * @return - El objeto `VendedorDto` resultante de la conversión.
     */
    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombres(),
                vendedor.getApellidos(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario());
    }

    /**
     * Convierte un objeto `VendedorDto` en un objeto `Vendedor`.
     * Este método extrae los datos del DTO y los utiliza para crear un objeto `Vendedor` correspondiente.
     *
     * @param vendedorDto - El objeto `VendedorDto` a convertir.
     * @return - El objeto `Vendedor` resultante de la conversión.
     */
    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return Vendedor.builder()
                .nombres(vendedorDto.nombres())
                .apellidos(vendedorDto.apellidos())
                .cedula(vendedorDto.cedula())
                .direccion(vendedorDto.direccion())
                .usuario(vendedorDto.usuario())
                .build();
    }

    /**
     * Convierte una lista de objetos `Producto` en una lista de `ProductoDto`.
     * Este método es útil para transformar los datos de los productos en un formato adecuado para su presentación
     * o transferencia, como los DTOs que se envían a través de una API.
     *
     * @param listaProductos - Lista de objetos `Producto` a convertir.
     * @return - Lista de objetos `ProductoDto` resultante de la conversión.
     */
    @Override
    public List<ProductoDto> getProductosDto(List<Producto> listaProductos) {
        if (listaProductos == null) {
            return null;
        }

        List<ProductoDto> productosDto = new ArrayList<>();
        for (Producto producto : listaProductos) {

            productosDto.add(productoToProductoDto(producto));
        }

        return productosDto;
    }

    /**
     * Convierte un objeto `Producto` en un objeto `ProductoDto`.
     * Este método extrae los datos del objeto `Producto` y los encapsula en un DTO para su uso en otras capas.
     *
     * @param producto - El objeto `Producto` a convertir.
     * @return - El objeto `ProductoDto` resultante de la conversión.
     */
    @Override
    public ProductoDto productoToProductoDto(Producto producto) {
        return new ProductoDto(
                producto.getNombre(),
                producto.getImagen(),
                producto.getPrecio(),
                producto.getEstado());
    }

    /**
     * Convierte un objeto `ProductoDto` en un objeto `Producto`.
     * Este método extrae los datos del DTO y los utiliza para crear un objeto `Producto` correspondiente.
     *
     * @param productoDto - El objeto `ProductoDto` a convertir.
     * @return - El objeto `Producto` resultante de la conversión.
     */
    @Override
    public Producto productoDtoToProducto(ProductoDto productoDto) {
        return Producto.builder()
                .nombre(productoDto.nombre())
                .imagen(productoDto.imagen())
                .precio(productoDto.precio())
                .estado(productoDto.estado())
                .build();
    }
}
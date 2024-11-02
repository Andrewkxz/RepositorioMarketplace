package co.edu.uniquindio.marketplace.mapping.mappers;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.services.IMarketplaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMappingImpl implements IMarketplaceMapping {
    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
        if(listaVendedores == null){
            return null;
        }

        List<VendedorDto> vendedoresDto = new ArrayList<>();
        for (Vendedor vendedor : listaVendedores) {
            vendedoresDto.add(vendedorToVendedorDto(vendedor));
        }

        return vendedoresDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombres(),
                vendedor.getApellidos(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario());
    }

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

    @Override
    public List<ProductoDto> getProductosDto(List<Producto> listaProductos) {
        if(listaProductos == null){
            return null;
        }
        List<ProductoDto> productosDto = new ArrayList<>();
        for (Producto producto : listaProductos) {
            productosDto.add(productoToProductoDto(producto));
        }
        return productosDto;
    }

    @Override
    public ProductoDto productoToProductoDto(Producto producto) {
        return new ProductoDto(
                producto.getNombre(),
                producto.getImagen(),
                producto.getPrecio(),
                producto.getEstado());
    }

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

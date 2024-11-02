package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;

import java.util.List;

public interface IProductoControllerService {
    List<ProductoDto> getProductosDto();
    boolean agregarProducto(ProductoDto producto);
}

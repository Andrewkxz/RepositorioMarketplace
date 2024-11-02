package co.edu.uniquindio.marketplace.controller;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.services.IProductoControllerService;

import java.util.List;

public class ProductoController implements IProductoControllerService {

    @Override
    public List<ProductoDto> getProductosDto() {
        return List.of();
    }

    @Override
    public boolean agregarProducto(ProductoDto producto) {
        return false;
    }
}



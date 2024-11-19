package co.edu.uniquindio.marketplace.controller;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.services.IProductoControllerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class ProductoController implements IProductoControllerService {
    ModelFactory modelFactory;

    public ProductoController(){
        modelFactory = ModelFactory.getInstance();

    }

    private List<Producto> productos = new ArrayList<>();

    /**
     *
     * @return
     */
    @Override
    public List<ProductoDto> getProductosDto() {
        return productos.stream().map(producto -> new ProductoDto(
                producto.getNombre(),
                producto.getImagen(),
                producto.getPrecio(),
                producto.getEstado()
        )).collect(Collectors.toList());
    }

    /**
     *
     * @param productoDto
     * @return
     */
    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        Producto producto = new Producto(
                productoDto.nombre(),
                productoDto.imagen(),
                productoDto.precio(),
                productoDto.estado()
        );
        return productos.add(producto);
    }
}



package co.edu.uniquindio.marketplace.controller;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.services.IProductoControllerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**Clase ProductoController la cual extiende de IProductoControllerService
 Esta clase se encarga de gestionar la lista de productos, permitiendo agregar nuevos productos
 y obtener la información de los mismos a través de objetos de transferencia de datos (DTO).
 **/
public class ProductoController implements IProductoControllerService {
    // Instancia del ModelFactory para la creación de modelos.
    ModelFactory modelFactory;

    /**
     Constructor de la clase ProductoController.
     Inicializa la instancia del ModelFactory y la lista de productos.
     **/
    public ProductoController(){
        modelFactory = ModelFactory.getInstance();

    }

    // Lista interna que almacena los productos de la tienda.
    private List<Producto> productos = new ArrayList<>();

    /**
     Método que retorna la lista de productos en formato DTO.

     Este método convierte los objetos de tipo Producto a objetos ProductoDto,
     los cuales son más adecuados para ser enviados a las vistas o interfaces de usuario.

     @return Una lista de objetos ProductoDto que representa la lista de productos.
     **/
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
     Método que agrega un nuevo producto a la lista de productos.

     Este método recibe un ProductoDto, lo convierte en un objeto Producto y lo agrega
     a la lista interna de productos.

     @param productoDto El objeto ProductoDto que contiene la información del nuevo producto.
     @return Devuelve true si el producto se agrega correctamente a la lista, false en caso contrario.
     **/
    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        Producto producto = new Producto(
                productoDto.nombre(),
                productoDto.imagen(),
                productoDto.precio(),
                productoDto.estado()
        );

        // Agrega el nuevo producto a la lista y retorna el resultado de la operación
        // (true si se agrega, false si no).
        return productos.add(producto);
    }
}



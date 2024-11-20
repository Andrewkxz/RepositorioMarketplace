package co.edu.uniquindio.marketplace.controller;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.model.Estado;
import co.edu.uniquindio.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.services.IProductoControllerService;
import org.controlsfx.control.PropertySheet;

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
                producto.getIdProducto(),
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
        if (productoDto == null || productoDto.idProducto() == null || productoDto.idProducto().isEmpty()) {
            throw new IllegalArgumentException("El ID del producto no puede ser nulo.");
        }
        if (productos.stream().anyMatch(p -> p.getIdProducto().equals(productoDto.idProducto()))) {
            System.out.println("El producto con ID " + productoDto.idProducto() + " ya existe.");
            return false;
        }
        Producto producto = new Producto(
                productoDto.idProducto(),
                productoDto.nombre(),
                productoDto.imagen(),
                productoDto.precio(),
                productoDto.estado()
        );
        return productos.add(producto);
    }

    public Producto buscarProducto (String idProducto) {
        return productos.stream().filter(p -> p.getIdProducto().equals(idProducto)).findFirst().orElse(null);
    }

    public boolean eliminarProducto(String idProducto) {
        Producto producto = buscarProducto(idProducto);
        if (producto != null) {
            return productos.remove(producto);
        }
        System.out.println("El producto con ID " + idProducto + " no encontrado.");
        return false;
    }
    public boolean actualizarProducto(ProductoDto productoDto) {
        Producto producto = buscarProducto(productoDto.idProducto());
        if (producto != null) {
            producto.setNombre(productoDto.nombre());
            producto.setImagen(productoDto.imagen());
            producto.setPrecio(productoDto.precio());
            producto.setEstado(productoDto.estado());
            return true;
        }
        System.out.println("El producto con ID " + productoDto.idProducto() + " no encontrado.");
        return false;
    }

    public List <ProductoDto> getProductosPorEstado(Estado estado) {
        return productos.stream()
                .filter(producto -> producto.getEstado() == estado)
                .map(producto -> new ProductoDto(
                        producto.getIdProducto(),
                        producto.getNombre(),
                        producto.getImagen(),
                        producto.getPrecio(),
                        producto.getEstado()
                ))
                .collect(Collectors.toList());
    }

    private void cargarProductosIniciales(){
        productos.add(new Producto("P001", "Laptop", "imagen1.png", 2500000, Estado.PUBLICADO));
        productos.add(new Producto("P002", "Celular", "imagen2.png", 1500000, Estado.PUBLICADO));

    }

}



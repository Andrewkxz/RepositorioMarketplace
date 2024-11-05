package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.model.Producto;

/**
 *
 */
public interface ICrudProducto {
    boolean crearProducto(Producto newProducto);
    boolean eliminarProducto(String id);
    boolean actualizarProducto(String id, Producto producto);
    Producto buscarProducto(String id);
    boolean verificarProductoExistente(String idProducto);
}

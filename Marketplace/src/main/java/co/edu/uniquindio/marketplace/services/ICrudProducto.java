package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.model.Producto;

/**
 * Interfaz que define las operaciones básicas de gestión de productos (CRUD).
 * Esta interfaz permite realizar operaciones de creación, eliminación, actualización,
 * búsqueda y verificación de existencia de productos en el sistema.
 */
public interface ICrudProducto {

    /**
     * Crea un nuevo producto en el sistema.
     *
     * @param newProducto El objeto Producto que se va a crear.
     * @return true si la creación fue exitosa, false si hubo un error o el producto
     *         no pudo ser creado (por ejemplo, si ya existe).
     */
    boolean crearProducto(Producto newProducto);

    /**
     * Elimina un producto del sistema identificado por su ID.
     *
     * @param id El identificador único del producto que se desea eliminar.
     * @return true si el producto fue eliminado con éxito, false si el producto
     *         no existe o no se pudo eliminar.
     */
    boolean eliminarProducto(String id);

    /**
     * Actualiza la información de un producto existente en el sistema.
     *
     * @param id El identificador único del producto a actualizar.
     * @param producto El objeto Producto con la nueva información.
     * @return true si el producto fue actualizado exitosamente, false si el
     *         producto no fue encontrado o no se pudo actualizar.
     */
    boolean actualizarProducto(String id, Producto producto);

    /**
     * Busca un producto en el sistema por su identificador único.
     *
     * @param id El identificador único del producto que se desea buscar.
     * @return El objeto Producto correspondiente al ID dado, o null si no se
     *         encontró el producto.
     */
    Producto buscarProducto(String id);

    /**
     * Verifica si un producto con el ID especificado ya existe en el sistema.
     *
     * @param idProducto El identificador único del producto a verificar.
     * @return true si el producto existe en el sistema, false si no existe.
     */
    boolean verificarProductoExistente(String idProducto);
}

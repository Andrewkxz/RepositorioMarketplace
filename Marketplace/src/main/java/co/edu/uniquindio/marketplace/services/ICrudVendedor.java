package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.model.Vendedor;

/**
 * Interfaz que define las operaciones básicas de gestión de vendedores (CRUD).
 * Esta interfaz permite realizar operaciones de creación, eliminación, actualización,
 * búsqueda y verificación de existencia de vendedores en el sistema.
 */
public interface ICrudVendedor {

    /**
     * Crea un nuevo vendedor en el sistema.
     *
     * @param newVendedor El objeto Vendedor que se va a crear.
     * @return true si la creación fue exitosa, false si hubo un error o el vendedor
     *         no pudo ser creado (por ejemplo, si ya existe).
     */
    boolean crearVendedor(Vendedor newVendedor);

    /**
     * Elimina un vendedor del sistema identificado por su cédula.
     *
     * @param cedula La cédula del vendedor que se desea eliminar.
     * @return true si el vendedor fue eliminado con éxito, false si el vendedor
     *         no existe o no se pudo eliminar.
     */
    boolean eliminarVendedor(String cedula);

    /**
     * Actualiza la información de un vendedor existente en el sistema.
     *
     * @param cedula La cédula del vendedor que se desea actualizar.
     * @param vendedor El objeto Vendedor con la nueva información.
     * @return true si el vendedor fue actualizado exitosamente, false si el
     *         vendedor no fue encontrado o no se pudo actualizar.
     */
    boolean actualizarVendedor(String cedula, Vendedor vendedor);

    /**
     * Busca un vendedor en el sistema por su cédula.
     *
     * @param cedula La cédula del vendedor que se desea buscar.
     * @return El objeto Vendedor correspondiente a la cédula dada, o null si no se
     *         encontró el vendedor.
     */
    Vendedor buscarVendedor(String cedula);

    /**
     * Verifica si un vendedor con la cédula especificada ya existe en el sistema.
     *
     * @param cedula La cédula del vendedor a verificar.
     * @return true si el vendedor existe en el sistema, false si no existe.
     */
    boolean verificarVendedorExistente(String cedula);
}


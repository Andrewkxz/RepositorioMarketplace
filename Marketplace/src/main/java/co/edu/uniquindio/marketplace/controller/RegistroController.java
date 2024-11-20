package co.edu.uniquindio.marketplace.controller;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.services.IRegistroControllerServices;

public class RegistroController implements IRegistroControllerServices {
    
    // Instancia del modelo que interactúa con los datos
    ModelFactory modelFactory;

    /**
     * Verifica si el usuario ya existe en el sistema.
     * Actualmente siempre devuelve false, indicando que no se ha implementado la lógica de verificación de usuario.
     * 
     * @param usuario El usuario a verificar.
     * @return Siempre devuelve false.
     */
    @Override
    public boolean verificarUsuario(Usuario usuario) {
        return false; // La implementación de esta lógica debe ser proporcionada
    }

    /**
     * Verifica si el vendedor con la cédula proporcionada ya existe en el sistema.
     * 
     * @param cedula La cédula del vendedor a verificar.
     * @return true si el vendedor con la cédula ya existe, false si no se encuentra en el sistema.
     */
    @Override
    public boolean verificarCedula(String cedula) {
        // Se consulta al modelo si el vendedor existe según la cédula
        return modelFactory.buscarVendedor(cedula) != null;
    }

    /**
     * Crea un nuevo vendedor en el sistema.
     * 
     * @param vendedor El objeto VendedorDto que contiene los datos del nuevo vendedor.
     * @return true si el vendedor fue agregado correctamente, false si hubo algún error.
     */
    @Override
    public boolean crearVendedor(VendedorDto vendedor) {
        // Llama al modelo para agregar el vendedor
        return modelFactory.agregarVendedor(vendedor);
    }

    /**
     * Elimina un vendedor del sistema basado en su cédula.
     * 
     * @param cedula La cédula del vendedor que se desea eliminar.
     * @return true si el vendedor fue eliminado correctamente, false si hubo algún error.
     */
    @Override
    public boolean eliminarVendedor(String cedula) {
        // Llama al modelo para eliminar al vendedor
        return modelFactory.eliminarVendedor(cedula);
    }

    /**
     * Actualiza los datos de un vendedor en el sistema.
     * Actualmente no está implementado y devuelve false.
     * 
     * @param cedula La cédula del vendedor que se desea actualizar.
     * @param vendedor Los nuevos datos del vendedor.
     * @return false, ya que la implementación no está completa.
     */
    @Override
    public boolean actualizarVendedor(String cedula, VendedorDto vendedor) {
        return false; // La implementación de esta lógica debe ser proporcionada
    }
}

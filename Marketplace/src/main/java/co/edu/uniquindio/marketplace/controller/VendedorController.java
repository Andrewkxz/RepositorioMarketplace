package co.edu.uniquindio.marketplace.controller;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.services.IVendedorControllerService;

import java.util.List;

// La clase VendedorController implementa la interfaz IVendedorControllerService, lo que significa que debe
// proporcionar la implementación de los métodos definidos en dicha interfaz.
public class VendedorController implements IVendedorControllerService {

    // Instancia de la fábrica de modelos (ModelFactory), que es utilizada para interactuar con los datos
    ModelFactory modelFactory;

    /**
     * Constructor de la clase VendedorController.
     * Inicializa la instancia de modelFactory utilizando el método getInstance(),
     * lo que asegura que se utilice una única instancia de la fábrica en todo el sistema.
     */
    public VendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    /**
     * Método que obtiene una lista de objetos VendedorDto.
     * Llama al método obtenerVendedoresDto() de la factory para obtener los vendedores.
     *
     * @return List<VendedorDto> - Lista de vendedores en formato DTO (Data Transfer Object).
     */
    @Override
    public List<VendedorDto> obtenerVendedoresDto() {
        return modelFactory.obtenerVendedoresDto();
    }

    /**
     * Método para agregar un nuevo vendedor.
     * Llama al método agregarVendedor() de la factory y le pasa el objeto vendedorDto
     * para agregarlo a la base de datos o sistema de almacenamiento correspondiente.
     *
     * @param vendedorDto - El objeto DTO del vendedor que se desea agregar.
     * @return boolean - Devuelve true si el vendedor fue agregado con éxito, false si hubo un error.
     */
    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        return modelFactory.agregarVendedor(vendedorDto);
    }

    /**
     * Método para actualizar la información de un vendedor existente.
     * Llama al método actualizarVendedor() de la factory, pasando el número de cédula actual del vendedor
     * y el nuevo objeto DTO del vendedor con los datos actualizados.
     *
     * @param cedulaActual - La cédula del vendedor que se desea actualizar.
     * @param vendedorDto - El objeto DTO con los nuevos datos del vendedor.
     * @return boolean - Devuelve true si la actualización fue exitosa, false si hubo algún error.
     */
    @Override
    public boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto) {
        return modelFactory.actualizarVendedor(cedulaActual, vendedorDto);
    }

    /**
     * Método para eliminar un vendedor según su cédula.
     * Llama al método eliminarVendedor() de la factory y le pasa la cédula del vendedor que se desea eliminar.
     *
     * @param cedula - La cédula del vendedor que se desea eliminar.
     * @return boolean - Devuelve true si el vendedor fue eliminado con éxito, false si hubo un error.
     */
    @Override
    public boolean eliminarVendedor(String cedula) {
        return modelFactory.eliminarVendedor(cedula);
    }
}
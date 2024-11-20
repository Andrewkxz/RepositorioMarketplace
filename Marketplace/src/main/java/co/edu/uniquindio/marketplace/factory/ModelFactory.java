package co.edu.uniquindio.marketplace.factory;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.marketplace.model.*;
import co.edu.uniquindio.marketplace.model.builder.ProductoBuilder;
import co.edu.uniquindio.marketplace.services.IModelFactoryService;

import java.util.List;

// La clase ModelFactory implementa la interfaz IModelFactoryService y se encarga de gestionar la creación y manipulación
// de los objetos relacionados con los vendedores, productos y marketplace. Utiliza el patrón Singleton para asegurarse de que
// solo exista una instancia de la clase en todo el sistema.
public class ModelFactory implements IModelFactoryService {

    // Instancia estática de la clase ModelFactory (patrón Singleton).
    private static ModelFactory instance;

    // Instancia de la clase Marketplace que contiene la lista de vendedores y productos.
    Marketplace marketplace;

    // Instancia de la clase MarketplaceMappingImpl que realiza la conversión entre objetos de dominio y DTOs.
    MarketplaceMappingImpl mapper;

    /**
     * Método para obtener la única instancia de ModelFactory (patrón Singleton).
     * Si no existe una instancia de ModelFactory, se crea una nueva.
     *
     * @return instancia única de ModelFactory.
     */
    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    /**
     * Constructor de la clase ModelFactory.
     * Inicializa el objeto mapper (para la conversión de datos) y la instancia de marketplace
     * con datos predeterminados a través del método inicializarDatos().
     */
    public ModelFactory() {
        mapper = new MarketplaceMappingImpl();
        marketplace = inicializarDatos();
    }

    /**
     * Método para obtener el objeto Marketplace, que contiene los vendedores y productos.
     *
     * @return marketplace - El objeto Marketplace.
     */
    public Marketplace getMarketplace() {
        return marketplace;
    }

    /**
     * Método para establecer un nuevo objeto Marketplace.
     *
     * @param marketplace - Nuevo objeto Marketplace.
     */
    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    /**
     * Método que obtiene una lista de vendedores en formato DTO (Data Transfer Object).
     *
     * @return List<VendedorDto> - Lista de vendedores en formato DTO.
     */
    @Override
    public List<VendedorDto> obtenerVendedoresDto() {
        return mapper.getVendedoresDto(getMarketplace().getListVendedores());
    }

    /**
     * Método para agregar un nuevo vendedor al marketplace.
     * Si el vendedor ya existe (se verifica por cédula), no se realiza la acción.
     *
     * @param vendedorDto - El vendedor a agregar, en formato DTO.
     * @return boolean - Devuelve true si el vendedor fue agregado exitosamente, false si ya existía.
     */
    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        if (!getMarketplace().verificarVendedorExistente(vendedorDto.cedula())){
            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedorDto);
            getMarketplace().crearVendedor(newVendedor);
            return true;

        }
        return false;
    }

    /**
     * Método para eliminar un vendedor del marketplace, dado su número de cédula.
     *
     * @param cedula - La cédula del vendedor a eliminar.
     * @return boolean - Devuelve true si el vendedor fue eliminado exitosamente, false si no se encontró.
     */
    @Override
    public boolean eliminarVendedor(String cedula) {
        return getMarketplace().eliminarVendedor(cedula);
    }

    /**
     * Método para actualizar la información de un vendedor existente en el marketplace.
     * Si el vendedor existe, se actualizan sus datos; si no, se devuelve false.
     *
     * @param cedulaActual - La cédula del vendedor a actualizar.
     * @param vendedorDto - El nuevo DTO con los datos actualizados del vendedor.
     * @return boolean - Devuelve true si el vendedor fue actualizado, false si no se encontró.
     */
    @Override
    public boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto) {
        if(getMarketplace().verificarVendedorExistente(cedulaActual)){
            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedorDto);
            return getMarketplace().actualizarVendedor(cedulaActual, newVendedor);
        }
        return false;
    }

    /**
     * Método para buscar un vendedor en el marketplace por nombre, apellido o cédula.
     * Si se encuentra un vendedor que coincida con el texto, se retorna el DTO del vendedor.
     *
     * @param texto - El nombre, apellido o cédula del vendedor a buscar.
     * @return VendedorDto - El DTO del vendedor encontrado, o null si no se encuentra.
     */
    @Override
    public VendedorDto buscarVendedor(String texto) {
        for (Vendedor vendedor : getMarketplace().getListVendedores()) {
            if (vendedor.getNombres().equals(texto) || vendedor.getApellidos().equals(texto) || vendedor.getCedula().equals(texto)) {
                return mapper.vendedorToVendedorDto(vendedor);
            }
        }
        return null;
    }

    /**
     * Método para sugerir vendedores relacionados a un vendedor según su cédula.
     * Actualmente, no se implementa ninguna lógica y simplemente devuelve una lista vacía.
     *
     * @param cedula - La cédula del vendedor.
     * @return List<VendedorDto> - Lista vacía de sugerencias.
     */
    @Override
    public List<VendedorDto> sugerirVendedores(String cedula) {
        return List.of();
    }


    /**
     * Método que inicializa los datos predeterminados para el marketplace.
     * Crea varios vendedores, productos y usuarios con datos de ejemplo.
     *
     * @return marketplace - El objeto Marketplace con los datos inicializados.
     */
    public static Marketplace inicializarDatos() {
        Marketplace marketplace = new Marketplace("Marketplace");
        Usuario usuario1 = Usuario.builder()
                .usuario("andrewkxz")
                .contrasenia("1023")
                .build();
        Vendedor vendedor1 = Vendedor.builder()
                .nombres("Andrés")
                .apellidos("Rodríguez")
                .cedula("100903")
                .direccion("casa")
                .usuario(usuario1)
                .build();

        Producto producto1 = Producto.builder()
                .nombre("PS5 Pro")
                .imagen("/Imagenes/productos/ps5Pro.jpeg")
                .descripcion("PlayStation 5 Pro")
                .precio(3500000)
                .estado(Estado.PUBLICADO)
                .build();

        Usuario usuario2 = Usuario.builder()
                .usuario("strw.jl")
                .contrasenia("134340")
                .build();
        Vendedor vendedor2 = Vendedor.builder()
                .nombres("Juliana")
                .apellidos("Bustamante")
                .cedula("134340")
                .direccion("home")
                .usuario(usuario2)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Pc gamer")
                .imagen("/Imagenes/productos/pcGamer.jpeg")
                .descripcion("Computador gamer")
                .precio(5000000)
                .estado(Estado.PUBLICADO)
                .build();

        Usuario usuario3 = Usuario.builder()
                .usuario("yer_996")
                .contrasenia("050417")
                .build();
        Vendedor vendedor3 = Vendedor.builder()
                .nombres("Yerilin")
                .apellidos("Ul Yalanda")
                .cedula("081096")
                .direccion("casita")
                .usuario(usuario3)
                .build();

        Producto producto3 = Producto.builder()
                .nombre("Iphone 16 Pro Max")
                .imagen("/Imagenes/productos/iphone 16.jpeg")
                .descripcion("256 GB Titanio del desierto")
                .precio(7000000)
                .estado(Estado.PUBLICADO)
                .build();

        marketplace.getListVendedores().add(vendedor1);
        marketplace.getListVendedores().add(vendedor2);
        marketplace.getListVendedores().add(vendedor3);
        vendedor1.agregarProducto(producto1);
        vendedor2.agregarProducto(producto2);
        vendedor3.agregarProducto(producto3);

        return marketplace;
    }
}
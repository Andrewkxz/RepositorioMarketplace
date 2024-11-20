package co.edu.uniquindio.marketplace.factory;

import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.marketplace.model.*;
import co.edu.uniquindio.marketplace.model.builder.ProductoBuilder;
import co.edu.uniquindio.marketplace.services.IModelFactoryService;

import java.util.List;

/**
 *
 */
public class ModelFactory implements IModelFactoryService {
    private static ModelFactory instance;
    Marketplace marketplace;
    MarketplaceMappingImpl mapper;

    /**
     *
     * @return
     */

    //Patrón Singleton
    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    /**
     *
     */
    public ModelFactory() {
        mapper = new MarketplaceMappingImpl();
        marketplace = inicializarDatos();
    }

    /**
     *
     * @return
     */
    public Marketplace getMarketplace() {
        return marketplace;
    }

    /**
     *
     * @param marketplace
     */
    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    /**
     *
     * @return
     */
    @Override
    public List<VendedorDto> obtenerVendedoresDto() {
        return mapper.getVendedoresDto(getMarketplace().getListVendedores());
    }

    /*public List<VendedorDto> obtenerProductosDto() {
        return mapper.getProductosDto(getMarketplace().getListProductos());
    }

    @Override
    public boolean agregarProducto(ProductoDto productoDto, VendedorDto vendedorDto) {
        return false;
    }

    @Override
    public boolean eliminarProducto(String cedula) {
        return false;
    }

    @Override
    public boolean actualizarProducto(ProductoDto productoDto, VendedorDto vendedorDto) {
        return false;
    }*/

    /**
     *
     * @param vendedorDto
     * @return
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
     *
     * @param cedula
     * @return
     */
    @Override
    public boolean eliminarVendedor(String cedula) {
        return getMarketplace().eliminarVendedor(cedula);
    }

    /**
     *
     * @param cedulaActual
     * @param vendedorDto
     * @return
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
     *
     * @param texto
     * @return
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
     *
     * @param cedula
     * @return
     */
    @Override
    public List<VendedorDto> sugerirVendedores(String cedula) {
        return List.of();
    }


    /**
     *
     * @return
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
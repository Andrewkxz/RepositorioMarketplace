package co.edu.uniquindio.marketplace.factory;

import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.marketplace.model.Marketplace;
import co.edu.uniquindio.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.services.IModelFactoryService;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory instance;
    Marketplace marketplace;
    MarketplaceMappingImpl mapper;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {
        mapper = new MarketplaceMappingImpl();
        marketplace = inicializarDatos();
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    @Override
    public List<VendedorDto> obtenerVendedoresDto() {
        return mapper.getVendedoresDto(getMarketplace().getListVendedores());
    }

    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        if (getMarketplace().verificarVendedorExistente(vendedorDto.cedula())){

            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedorDto);

            getMarketplace().crearVendedor(newVendedor);
            return true;

        }
        return false;
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        return getMarketplace().eliminarVendedor(cedula);
    }

    @Override
    public boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto) {
        if(!getMarketplace().verificarVendedorExistente(cedulaActual)){
            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedorDto);

            getMarketplace().actualizarVendedor(cedulaActual, newVendedor);
            return true;
        }
        return false;
    }

    public static Marketplace inicializarDatos() {
        Marketplace marketplace = new Marketplace();
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

        marketplace.getListVendedores().add(vendedor1);
        marketplace.getListVendedores().add(vendedor2);
        marketplace.getListVendedores().add(vendedor3);

        return marketplace;
    }



}
package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {
    private List <Producto> productos;
    public Vendedor() {
    }

    public Vendedor(String nombres, String apellidos, String cedula, String direccion, Usuario usuario) {
        super(nombres, apellidos, cedula, direccion, usuario);
        this.productos = new ArrayList<>();
    }

    public static VendedorBuilder builder() {
        return new VendedorBuilder();
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public List<Producto> listarProductos(){
        if(productos.isEmpty()){
            System.out.println("No hay productos");
        }else{
            for(Producto producto: productos){
                System.out.println(producto);
            }
        }
        return productos;
    }
}

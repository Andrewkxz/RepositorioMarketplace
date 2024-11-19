package co.edu.uniquindio.marketplace.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 */
public class Estadisticas {
    private List<Vendedor> vendedores;

    /**
     *
     */
    public Estadisticas() {
        this.vendedores = new ArrayList<>();
    }

    /**
     *
     * @param vendedores
     */
    public void setVendedores(List<Vendedor> vendedores) {
        if (vendedores == null) {
            throw new IllegalArgumentException("La lista de vendedores no puede ser nula");
        }
        this.vendedores = vendedores;
    }

    /**
     *
     * @param emisor
     * @param receptor
     * @return
     */
    public int cantidadMensajes (Vendedor emisor, Vendedor receptor) {
        if (emisor == null || receptor == null) {
            throw new IllegalArgumentException("Los venedores son requeridos");
        }
        int cantidad = 0;
        for (Chat chat : emisor.getChats()) {
            if (chat.getEmisor().equals(receptor) && chat.getReceptor().equals(emisor) ||
                    (chat.getEmisor().equals(emisor) && chat.getReceptor().equals(receptor))) {
                cantidad += chat.getMensajes().size();
            }
        }
        return cantidad;
    }

    /**
     *
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    public int cantidadProductosPublicados(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("Los fechas son requeridos");
        }
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        int cantidad = 0;
        for (Vendedor vendedor : vendedores) {
            for (Producto producto : vendedor.listarProductos()){
                if (producto.getFechaPublicacion().toLocalDate().isAfter(fechaInicio) &&
                        producto.getFechaPublicacion().toLocalDate().isBefore(fechaFin)){
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

    /**
     *
     * @param vendedor
     * @return
     */
    public int cantidadProductosPorVendedor(Vendedor vendedor) {
        if (vendedor == null) {
            throw new IllegalArgumentException("El vendedor es requerido");
        }
        return vendedor.listarProductos().size();
    }

    /**
     *
     * @return
     */
    public HashMap <Vendedor, Integer> cantidadContactosPorVendedor() {
        HashMap <Vendedor, Integer> cantidadContactos = new HashMap<>();
        for (Vendedor vendedor : vendedores) {
            cantidadContactos.put(vendedor, vendedor.getContactos().size());
        }
        return cantidadContactos;
    }

    /**
     *
     * @return
     */
    public List<Producto> top10ProductosConMasLikes() {
        List<Publicacion> todasLasPublicaciones = new ArrayList<>();
        for (Vendedor vendedor : vendedores) {
            todasLasPublicaciones.addAll(vendedor.getMuro().getPublicaciones());
        }
        todasLasPublicaciones.sort((publicacion1, publicacion2) ->
                Integer.compare(publicacion2.getCantidadLikes(), publicacion1.getCantidadLikes()));
        List<Producto> top10Productos = new ArrayList<>();
        for (int i = 0; i < Math.min(10, todasLasPublicaciones.size()); i++) {
            top10Productos.add(todasLasPublicaciones.get(i).getProducto());
        }
        return top10Productos;
    }

    /**
     *
     * @param rutaArchivo
     * @param nombreUsuario
     * @param fechaInicio
     * @param fechaFin
     * @param vendedor1
     * @param vendedor2
     */
    public void exportarEstadisticas (String rutaArchivo, String nombreUsuario, LocalDate fechaInicio,
                                      LocalDate fechaFin, Vendedor vendedor1, Vendedor vendedor2) {
        if (rutaArchivo == null || nombreUsuario == null || fechaInicio == null || fechaFin == null || vendedor1 == null || vendedor2 == null) {
            throw new IllegalArgumentException("Todos los datos son requeridos");
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))){
            writer.write("<Título> Reporte de Estadísticas\n");
            writer.write("<Fecha> Fecha: " + LocalDateTime.now() + "\n");
            writer.write("<Usuario> Reporte realizado por: " + nombreUsuario + "\n");
            writer.write("Información del reporte:\n");
            writer.write("Cantidad de productos publicados entre: " + fechaInicio + " y " + fechaFin + ": "
                    + cantidadProductosPublicados(fechaInicio, fechaFin) + "\n");
            writer.write("Cantidad mensajes entre vendedores: "
                    + cantidadMensajes(vendedor1, vendedor2) + "\n");
            writer.write("Cantidad de contactos por cada vendedor:\n");
            HashMap<Vendedor, Integer> contactos = cantidadContactosPorVendedor();
            for (Map.Entry<Vendedor, Integer> entry : contactos.entrySet()) {
                writer.write(entry.getKey().getNombres() + ": " + entry.getValue() + " contactos\n");
            }

            writer.write("Top 10 productos con más me gusta:\n");
            List<Producto> top10 = top10ProductosConMasLikes();
            for (Producto producto : top10){
                writer.write(producto.getNombre() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al generar el archivo de las estadísticas");
        }
    }

}

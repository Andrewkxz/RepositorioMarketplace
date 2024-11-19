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
        if(vendedores == null){
            throw new IllegalArgumentException("La lista de vendedores no puede ser nula.");
        }
        this.vendedores = vendedores;
    }

    /**
     *
     * @return lista de vendedores
     */

    public List<Vendedor> getVendedores() {
        return vendedores;
    }


    /**
     *
     * @param vendedor1
     * @param vendedor2
     * @return
     */
    public int cantidadMensajes (Vendedor vendedor1, Vendedor vendedor2) {
       if (vendedor1 == null || vendedor2 == null) {
           throw new IllegalArgumentException("Los vendedores no pueden ser nulos");
       }
        int cantidad = 0;
        for (Chat chat : vendedor1.getChats()) {
            if (chat.getVendedor1().equals(vendedor2) && chat.getVendedor2().equals(vendedor1) ||
                    (chat.getVendedor1().equals(vendedor1) && chat.getVendedor2().equals(vendedor2))) {
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
            throw new IllegalArgumentException("Los fechas no pueden ser nulas.");
        }
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        int cantidad = 0;
        for (Vendedor vendedor : vendedores) {
            for (Producto producto : vendedor.listarProductos()){
                LocalDate fechaPublicacion = producto.getFechaPublicacion().toLocalDate();
                if (!fechaPublicacion.isBefore(fechaInicio) && !fechaPublicacion.isAfter(fechaFin)) {
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
            throw new IllegalArgumentException("El vendedor no puede ser nulos.");
        }
        return vendedor.listarProductos().size();
    }

    /**
     *
     * @return
     */
    public Map <Vendedor, Integer> cantidadContactosPorVendedor() {
        Map <Vendedor, Integer> cantidadContactos = new HashMap<>();
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

        if (rutaArchivo == null || rutaArchivo.isEmpty()) {
            throw new IllegalArgumentException("La ruta del archivo no puede estar vacía.");
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("<Título> Reporte de Estadísticas\n");
            writer.write("<Fecha> Fecha: " + LocalDateTime.now() + "\n");
            writer.write("<Usuario> Reporte realizado por: " + nombreUsuario + "\n");
            writer.write("Información del reporte:\n");


            writer.write("Cantidad de productos publicados entre: " + fechaInicio + " y " + fechaFin + ": "
                    + cantidadProductosPublicados(fechaInicio, fechaFin) + "\n");

            writer.write("Cantidad mensajes entre vendedores: "
                    + cantidadMensajes(vendedor1, vendedor2) + "\n");

            writer.write("Cantidad de contactos por cada vendedor:\n");
            Map<Vendedor, Integer> contactos = cantidadContactosPorVendedor();
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
            System.err.println("Error al general el archivo de estadísticas.");
        }
    }

}

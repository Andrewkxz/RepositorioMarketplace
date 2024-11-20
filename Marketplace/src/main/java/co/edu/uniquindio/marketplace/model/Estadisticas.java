package co.edu.uniquindio.marketplace.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Clase Estadisticas: Proporciona métodos para calcular estadísticas relacionadas
 * con los vendedores, productos, y sus interacciones en el sistema.
 */
public class Estadisticas {

    private List<Vendedor> vendedores; // Lista de vendedores sobre los que se calcularán estadísticas

    /**
     * Constructor por defecto. Inicializa la lista de vendedores como vacía.
     */
    public Estadisticas() {
        this.vendedores = new ArrayList<>();
    }

    /**
     * Establece la lista de vendedores para generar estadísticas.
     *
     * @param vendedores Lista de vendedores.
     * @throws IllegalArgumentException Si la lista es nula.
     */
    public void setVendedores(List<Vendedor> vendedores) {
        if (vendedores == null) {
            throw new IllegalArgumentException("La lista de vendedores no puede ser nula");
        }
        this.vendedores = vendedores;
    }

    /**
     * Calcula la cantidad de mensajes entre dos vendedores.
     *
     * @param emisor El vendedor emisor de los mensajes.
     * @param receptor El vendedor receptor de los mensajes.
     * @return La cantidad total de mensajes intercambiados.
     * @throws IllegalArgumentException Si alguno de los vendedores es nulo.
     */
    public int cantidadMensajes(Vendedor emisor, Vendedor receptor) {
        if (emisor == null || receptor == null) {
            throw new IllegalArgumentException("Los vendedores son requeridos");
        }
        int cantidad = 0;
        for (Chat chat : emisor.getChats()) {
            if ((chat.getEmisor().equals(receptor) && chat.getReceptor().equals(emisor)) ||
                    (chat.getEmisor().equals(emisor) && chat.getReceptor().equals(receptor))) {
                cantidad += chat.getMensajes().size();
            }
        }
        return cantidad;
    }

    /**
     * Calcula la cantidad de productos publicados en un rango de fechas.
     *
     * @param fechaInicio Fecha de inicio del rango.
     * @param fechaFin Fecha de fin del rango.
     * @return La cantidad de productos publicados en ese rango.
     * @throws IllegalArgumentException Si las fechas son nulas o la fechaInicio es posterior a la fechaFin.
     */
    public int cantidadProductosPublicados(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("Las fechas son requeridas");
        }
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        int cantidad = 0;
        for (Vendedor vendedor : vendedores) {
            for (Producto producto : vendedor.listarProductos()) {
                if (producto.getFechaPublicacion().toLocalDate().isAfter(fechaInicio) &&
                        producto.getFechaPublicacion().toLocalDate().isBefore(fechaFin)) {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

    /**
     * Calcula la cantidad de productos publicados por un vendedor específico.
     *
     * @param vendedor El vendedor en cuestión.
     * @return La cantidad de productos publicados por el vendedor.
     * @throws IllegalArgumentException Si el vendedor es nulo.
     */
    public int cantidadProductosPorVendedor(Vendedor vendedor) {
        if (vendedor == null) {
            throw new IllegalArgumentException("El vendedor es requerido");
        }
        return vendedor.listarProductos().size();
    }

    /**
     * Obtiene un mapa de vendedores con la cantidad de contactos de cada uno.
     *
     * @return Un mapa donde las claves son vendedores y los valores son la cantidad de contactos.
     */
    public HashMap<Vendedor, Integer> cantidadContactosPorVendedor() {
        HashMap<Vendedor, Integer> cantidadContactos = new HashMap<>();
        for (Vendedor vendedor : vendedores) {
            cantidadContactos.put(vendedor, vendedor.getContactos().size());
        }
        return cantidadContactos;
    }

    /**
     * Obtiene los 10 productos con más "me gusta" en las publicaciones de los vendedores.
     *
     * @return Una lista con los 10 productos más populares.
     */
    public List<Producto> top10ProductosConMasLikes() {
        List<Publicacion> todasLasPublicaciones = new ArrayList<>();
        for (Vendedor vendedor : vendedores) {
            todasLasPublicaciones.addAll(vendedor.getMuro().getPublicaciones());
        }
        todasLasPublicaciones.sort((p1, p2) -> Integer.compare(p2.getCantidadLikes(), p1.getCantidadLikes()));
        List<Producto> top10Productos = new ArrayList<>();
        for (int i = 0; i < Math.min(10, todasLasPublicaciones.size()); i++) {
            top10Productos.add(todasLasPublicaciones.get(i).getProducto());
        }
        return top10Productos;
    }

    /**
     * Exporta las estadísticas a un archivo de texto.
     *
     * @param rutaArchivo Ruta del archivo a generar.
     * @param nombreUsuario Nombre del usuario que genera el reporte.
     * @param fechaInicio Fecha de inicio del análisis.
     * @param fechaFin Fecha de fin del análisis.
     * @param vendedor1 Primer vendedor para análisis de mensajes.
     * @param vendedor2 Segundo vendedor para análisis de mensajes.
     * @throws IllegalArgumentException Si alguno de los parámetros es nulo.
     */
    public void exportarEstadisticas(String rutaArchivo, String nombreUsuario, LocalDate fechaInicio,
                                     LocalDate fechaFin, Vendedor vendedor1, Vendedor vendedor2) {
        if (rutaArchivo == null || nombreUsuario == null || fechaInicio == null ||
                fechaFin == null || vendedor1 == null || vendedor2 == null) {
            throw new IllegalArgumentException("Todos los datos son requeridos");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("<Título> Reporte de Estadísticas\n");
            writer.write("<Fecha> Fecha: " + LocalDateTime.now() + "\n");
            writer.write("<Usuario> Reporte realizado por: " + nombreUsuario + "\n");
            writer.write("Información del reporte:\n");
            writer.write("Cantidad de productos publicados entre: " + fechaInicio + " y " + fechaFin + ": "
                    + cantidadProductosPublicados(fechaInicio, fechaFin) + "\n");
            writer.write("Cantidad de mensajes entre vendedores: "
                    + cantidadMensajes(vendedor1, vendedor2) + "\n");
            writer.write("Cantidad de contactos por cada vendedor:\n");
            for (Map.Entry<Vendedor, Integer> entry : cantidadContactosPorVendedor().entrySet()) {
                writer.write(entry.getKey().getNombres() + ": " + entry.getValue() + " contactos\n");
            }
            writer.write("Top 10 productos con más me gusta:\n");
            for (Producto producto : top10ProductosConMasLikes()) {
                writer.write(producto.getNombre() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al generar el archivo de las estadísticas");
        }
    }
}
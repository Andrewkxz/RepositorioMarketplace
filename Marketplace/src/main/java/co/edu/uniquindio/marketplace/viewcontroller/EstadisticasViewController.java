package co.edu.uniquindio.marketplace.viewcontroller;

import co.edu.uniquindio.marketplace.model.*;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;

import java.time.LocalDate;
/**
 * Controlador de la vista de estadísticas del marketplace. Maneja la interacción con
 * la interfaz gráfica para mostrar y calcular estadísticas relacionadas con los productos y vendedores.
 */
public class EstadisticasViewController {

    @FXML
    private DatePicker dpFechaInicio;

    @FXML
    private DatePicker dpFechaFin;

    @FXML
    private ComboBox <Vendedor> cbVendedor;

    @FXML
    private ListView<Producto> lvTopProductos;

    @FXML
    private Label lblCantidadProductos;

    @FXML
    private Label lblCantidadMensajes;

    @FXML
    private BarChart<String, Number> chartProductosPorVendedor;

    private Marketplace marketplace;
    private Estadisticas estadisticas;

    /**
     * Inicializa el controlador con el marketplace y configura los datos iniciales.
     * Carga la lista de vendedores en la interfaz.
     *
     * @param marketplace El objeto marketplace que contiene la información de la aplicación.
     */
    public void inicializar(Marketplace marketplace){
        this.marketplace = marketplace;
        this.estadisticas = new Estadisticas();
        this.estadisticas.setVendedores (marketplace.getListVendedores());
        cargarVendedores();
    }
    /**
     * Carga los vendedores en el combo box de vendedores.
     */
    private void cargarVendedores(){
        cbVendedor.getItems().addAll(marketplace.getListVendedores());
    }
    /**
     * Calcula la cantidad de productos publicados dentro del rango de fechas seleccionado.
     * Muestra el resultado en la interfaz.
     */
    @FXML
    private void calcularProductosPublicados(){
        LocalDate fechaInicio = dpFechaInicio.getValue();
        LocalDate fechaFin = dpFechaFin.getValue();

        if (fechaInicio == null || fechaFin == null || fechaInicio.isAfter(fechaFin)) {
            mostrarAlerta("Error", "Fechas inválidas", "Por favor, seleccione un rango de fechas válido.");
            return;
        }
        int cantidad = estadisticas.cantidadProductosPublicados(fechaInicio, fechaFin);
        lblCantidadProductos.setText("Cantidad de productos publicados: " + cantidad);
    }
    /**
     * Muestra el top 10 de productos con más likes.
     * Actualiza la lista de productos en la interfaz.
     */
    @FXML
    private void mostrarTopProductos(){
        lvTopProductos.getItems().clear();
        lvTopProductos.getItems().addAll(estadisticas.top10ProductosConMasLikes());
    }
    /**
     * Genera un gráfico de barras que muestra la cantidad de productos por vendedor.
     * Actualiza el gráfico en la interfaz.
     */
    @FXML
    private void generarGraficoProductosPorVendedor(){
        chartProductosPorVendedor.getData().clear();

        BarChart.Series<String, Number> series = new BarChart.Series<>();
        series.setName("Productos por vendedor");

        estadisticas.cantidadContactosPorVendedor().forEach((vendedor, cantidad) ->
                series.getData().add(new BarChart.Data<>(vendedor.getNombres(),cantidad)));

        chartProductosPorVendedor.getData().add(series);
    }
    /**
     * Exporta las estadísticas seleccionadas a un archivo de texto.
     *
     * @throws Exception Si ocurre un error durante la exportación.
     */
    @FXML
    private void exportarEstadisticas() {
        try{
            String rutaArchivo = "estadisticas.txt";
            estadisticas.exportarEstadisticas(rutaArchivo, "Usuario", dpFechaInicio.getValue(), dpFechaFin.getValue(), cbVendedor.getValue(), null);
            mostrarAlerta("Éxito", "Exportación completa", "Las estadisticas se han exportado correctamente.");
        }catch(Exception e){
            mostrarAlerta("Error", "No se pudieron exportar las estadísticas", e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * Muestra una alerta en la interfaz con el título, encabezado y contenido especificados.
     *
     * @param titulo El título de la alerta.
     * @param cabecera El encabezado de la alerta.
     * @param contenido El contenido de la alerta.
     */
    private void mostrarAlerta(String titulo, String cabecera, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecera);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
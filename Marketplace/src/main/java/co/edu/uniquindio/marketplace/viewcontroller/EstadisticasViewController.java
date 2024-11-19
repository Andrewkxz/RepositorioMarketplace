package co.edu.uniquindio.marketplace.viewcontroller;

import co.edu.uniquindio.marketplace.model.*;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;

import java.time.LocalDate;

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
     *
     * @Param
     */
    public void inicializar(Marketplace marketplace){
        this.marketplace = marketplace;
        this.estadisticas = new Estadisticas();
        this.estadisticas.setVendedores (marketplace.getListVendedores());
        cargarVendedores();
    }

    private void cargarVendedores(){
        cbVendedor.getItems().addAll(marketplace.getListVendedores());
    }

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

    @FXML
    private void mostrarTopProductos(){
        lvTopProductos.getItems().clear();
        lvTopProductos.getItems().addAll(estadisticas.top10ProductosConMasLikes());
    }

    @FXML
    private void generarGraficoProductosPorVendedor(){
        chartProductosPorVendedor.getData().clear();

        BarChart.Series<String, Number> series = new BarChart.Series<>();
        series.setName("Productos por vendedor");

        estadisticas.cantidadContactosPorVendedor().forEach((vendedor, cantidad) ->
                series.getData().add(new BarChart.Data<>(vendedor.getNombres(),cantidad)));

        chartProductosPorVendedor.getData().add(series);
    }

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
     *
     * @param titulo
     * @param cabecera
     * @param contenido
     */

    private void mostrarAlerta(String titulo, String cabecera, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecera);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
package co.edu.uniquindio.marketplace.viewcontroller;

import co.edu.uniquindio.marketplace.controller.VendedorController;
import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.List;

/**
 * Controlador para la vista del muro del vendedor en el marketplace.
 * Gestiona la navegación entre las pestañas de muro, productos y contactos,
 * y la visualización de publicaciones de productos.
 */
public class MuroViewController {

    private VendedorDto vendedor; // Vendedor actualmente logueado.
    private VendedorController vendedorController; // Controlador para manejar las acciones de los vendedores.

    @FXML
    private Button botonMuro; // Botón para acceder a la pestaña del muro.
    @FXML
    private Button botonContactos; // Botón para acceder a la pestaña de contactos.
    @FXML
    private Button botonMisProductos; // Botón para acceder a la pestaña de productos.
    @FXML
    private Button botonLogOut; // Botón para cerrar sesión.

    @FXML
    private AnchorPane anchorPaneMuro; // Panel para mostrar el muro.
    @FXML
    private AnchorPane anchorPaneVendedores; // Panel para mostrar los vendedores.
    @FXML
    private AnchorPane anchorPaneProductos; // Panel para mostrar los productos.
    @FXML
    private GridPane gridPaneProductos; // Contenedor para mostrar los productos en un grid.

    @FXML
    private TabPane tabPane; // Contenedor de las pestañas de la vista.
    @FXML
    private Tab tabPaneVendedores; // Pestaña para los vendedores.
    @FXML
    private Tab tabMuro; // Pestaña para el muro del vendedor.
    @FXML
    private Tab tabProductos; // Pestaña para los productos del vendedor.

    /**
     * Método para seleccionar la pestaña del muro al hacer clic en el botón correspondiente.
     *
     * @param actionEvent El evento generado por el clic del botón.
     */
    public void onMuro(ActionEvent actionEvent) {
        tabPane.getSelectionModel().select(tabMuro);
    }

    /**
     * Método para cerrar la sesión del usuario y cargar la pantalla de inicio de sesión.
     *
     * @param actionEvent El evento generado por el clic del botón de logout.
     */
    public void onCerrarSesion(ActionEvent actionEvent) {
        cargarEscena("co/edu/uniquindio/marketplace/Login.fxml", actionEvent);
    }

    /**
     * Método para seleccionar la pestaña de productos al hacer clic en el botón correspondiente
     * y mostrar las publicaciones de productos en la interfaz.
     *
     * @param actionEvent El evento generado por el clic del botón de productos.
     * @throws IOException Si ocurre un error al cargar los productos.
     */
    public void onProductos(ActionEvent actionEvent) throws IOException {
        tabPane.getSelectionModel().select(tabProductos);
        mostrarPublicaciones();
    }

    /**
     * Método para seleccionar la pestaña de vendedores al hacer clic en el botón correspondiente.
     *
     * @param actionEvent El evento generado por el clic del botón de vendedores.
     */
    public void onVendedores(ActionEvent actionEvent) {
        tabPane.getSelectionModel().select(tabPaneVendedores);
    }

    /**
     * Muestra las publicaciones de productos en el grid de productos.
     * Se obtienen los productos asociados al vendedor y se cargan en la interfaz.
     *
     * @throws IOException Si ocurre un error al cargar las vistas de productos.
     */
    public void mostrarPublicaciones() throws IOException {
        int columnas = 0;
        int filas = 0;
        gridPaneProductos.getChildren().clear(); // Limpiar grid antes de cargar nuevos productos.

        // Obtiene la lista de productos del vendedor
        List<ProductoDto> productos = vendedorController.getListaProductosDto(vendedor.cedula());

        // Itera sobre los productos y los agrega al grid
        for (ProductoDto producto : productos) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/Producto.fxml"));
            AnchorPane anchorPane = loader.load();
            ProductoViewController productoViewController = loader.getController();
            productoViewController.cambiarDatos(producto);
            gridPaneProductos.add(anchorPane, columnas, filas);
            columnas++;

            // Cambio de filas y columnas para distribuir los productos en el grid
            if (columnas > 1) {
                columnas = 0;
                filas++;
            }
        }
    }

    /**
     * Carga una nueva escena en la ventana, reemplazando la escena actual.
     *
     * @param url La URL del archivo FXML que representa la nueva escena.
     * @param actionEvent El evento generado por el clic en el botón.
     */
    private void cargarEscena(String url, Event actionEvent) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, se imprime el error en la consola.
        }
    }
}
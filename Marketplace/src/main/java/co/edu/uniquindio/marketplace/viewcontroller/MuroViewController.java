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

public class MuroViewController {

    private VendedorDto vendedor;

    VendedorController vendedorController;

    @FXML
    private Button botonMuro;

    @FXML
    private Button botonContactos;

    @FXML
    private Button botonMisProductos;

    @FXML
    private Button botonLogOut;

    @FXML
    private AnchorPane anchorPaneMuro;

    @FXML
    private AnchorPane anchorPaneVendedores;

    @FXML
    private AnchorPane anchorPaneProductos;

    @FXML
    private GridPane gridPaneProductos;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabPaneVendedores;

    @FXML
    private Tab tabMuro;

    @FXML
    private Tab tabProductos;

    public void onMuro(ActionEvent actionEvent) {
        tabPane.getSelectionModel().select(tabMuro);
    }

    public void onCerrarSesion(ActionEvent actionEvent) {
        cargarEscena("co/edu/uniquindio/marketplace/Login.fxml", actionEvent);
    }

    public void onProductos(ActionEvent actionEvent) throws IOException {
        tabPane.getSelectionModel().select(tabProductos);
        mostrarPublicaciones();
    }

    public void onVendedores(ActionEvent actionEvent) {
        tabPane.getSelectionModel().select(tabPaneVendedores);
    }

    public void mostrarPublicaciones() throws IOException {
        int columnas = 0;
        int filas = 0;
        gridPaneProductos.getChildren().clear();
        List<ProductoDto> productos = vendedorController.getListaProductosDto(vendedor.cedula());
        for (ProductoDto producto : productos) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/Producto.fxml"));
            AnchorPane anchorPane = loader.load();
            ProductoViewController productoViewController = loader.getController();
            productoViewController.cambiarDatos(producto);
            gridPaneProductos.add(anchorPane, columnas, filas);
            columnas++;
            if (columnas > 1){
                columnas = 0;
                filas++;
            }
        }
    }

    private void cargarEscena (String url, Event actionEvent) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();

        }
    }
}

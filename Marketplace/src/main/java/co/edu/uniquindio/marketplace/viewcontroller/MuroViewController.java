package co.edu.uniquindio.marketplace.viewcontroller;

import co.edu.uniquindio.marketplace.controller.VendedorController;
import co.edu.uniquindio.marketplace.mapping.dto.VendedorDto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MuroViewController {

    private VendedorDto vendedor;

    VendedorController vendedorController;

    @FXML
    private ImageView botonMuro;

    @FXML
    private ImageView botonContactos;

    @FXML
    private ImageView botonMisProductos;

    @FXML
    private ImageView botonLogOut;

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
    private Tab tabVendedores;

    @FXML
    private Tab tabMuro;

    @FXML
    private Tab tabProductos;

    @FXML
    private void initialize() {
    }

    public void onMuro(javafx.scene.input.MouseEvent mouseEvent) {
        tabPane.getSelectionModel().select(tabMuro);
    }

    public void onVendedores(javafx.scene.input.MouseEvent mouseEvent) {
        tabPane.getSelectionModel().select(tabVendedores);
    }

    public void onProductos(javafx.scene.input.MouseEvent mouseEvent) {
        tabPane.getSelectionModel().select(tabProductos);
    }

    public void onCerrarSesion(javafx.scene.input.MouseEvent mouseEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/LoginPrueba.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) botonLogOut.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void mostrarPublicaciones() throws IOException {
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
    }*/

}

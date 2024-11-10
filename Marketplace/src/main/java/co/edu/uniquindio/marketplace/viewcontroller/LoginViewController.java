package co.edu.uniquindio.marketplace.viewcontroller;

import co.edu.uniquindio.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.model.Marketplace;
import co.edu.uniquindio.marketplace.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {
    private Marketplace marketplace;

    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contrasenia;
    @FXML
    private ChoiceBox<String> rol;
    @FXML
    private Button ingresar;
    @FXML
    private Button registrar;


    public LoginViewController() {
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    @FXML
    public void initialize() {
        rol.getItems().addAll("Vendedor", "Administrador");
    }

    @FXML
    public void ingresar(ActionEvent event) {
        String nombreUsuario = usuario.getText();
        String contraseniaUsuario = contrasenia.getText();
        String rolUsuario = rol.getValue();

        Usuario usuarioEncontrado = marketplace.buscarUsuario(nombreUsuario);

        if (usuarioEncontrado != null && usuarioEncontrado.getContrasenia().equals(contraseniaUsuario) && usuarioEncontrado.getRol().equals(rolUsuario)) {
        mostrarAlerta("Éxito","Inicio de sesión exitoso.", AlertType.INFORMATION);
        mostrarPaginaRegistro();

        } else {
            mostrarAlerta("Error","Usuario o contraseña incorrectos.", AlertType.ERROR);

        }
        }

    @FXML
    public void registro(ActionEvent event) {
        mostrarPaginaRegistro();
    }

    private void mostrarPaginaRegistro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/Registro.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) usuario.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "Error al mostrar el registro.", AlertType.ERROR);
        }
    }

    private void mostrarPaginaPrincipal(String rolUsuario) {
        try {
            FXMLLoader loader;
            if (rolUsuario.equals("Vendedor")) {
                loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/Muro.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/Estadisticas.fxml"));
            }
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ingresar.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
            mostrarAlerta("Error", "Error al cargar la página principal.", AlertType.ERROR);
        }

    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipoAlerta) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
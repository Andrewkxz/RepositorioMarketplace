package co.edu.uniquindio.marketplace.viewcontroller;

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

    private Marketplace marketplace;

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

        Usuario usuario = marketplace.buscarUsuario(nombreUsuario);

        if (usuario != null && usuario.getContrasenia().equals(contraseniaUsuario) && usuario.getRol().equals(rolUsuario)) {
            mostrarAlerta("Exito", "Inicio de sesión exitoso.", AlertType.INFORMATION);
        } else if (usuario == null) {
            mostrarAlerta("Error", "El usuario no existe. Por favor, regístrate.", AlertType.ERROR);
            mostrarPaginaRegistro();
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos", AlertType.ERROR);
        }
    }

    @FXML
    public void registro(ActionEvent event) {
        mostrarPaginaRegistro();
    }

    private void mostrarPaginaRegistro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/RegistroPrueba.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) ingresar.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "Error al mostrar el registro.", AlertType.ERROR);
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
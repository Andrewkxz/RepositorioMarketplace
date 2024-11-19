package co.edu.uniquindio.marketplace.viewcontroller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroViewController {

    @FXML
    private TextField nombresField; // Campo para los nombres

    @FXML
    private TextField apellidosField; // Campo para los apellidos

    @FXML
    private TextField cedulaField; // Campo para la cédula

    @FXML
    private TextField direccionField; // Campo para la dirección

    @FXML
    private ChoiceBox<String> tipoUsuarioChoiceBox; // ChoiceBox para el tipo de usuario

    @FXML
    private PasswordField contraseniaField; // Campo para la contraseña

    @FXML
    private Button registrarseButton; // Botón de registro

    @FXML
    private void initialize() {

        tipoUsuarioChoiceBox.getItems().addAll("Vendedor", "Administrador");

        registrarseButton.setOnAction(event -> registro());
    }

    private void registro() {
        String nombres = nombresField.getText();
        String apellidos = apellidosField.getText();
        String cedula = cedulaField.getText();
        String direccion = direccionField.getText();
        String tipoUsuario = tipoUsuarioChoiceBox.getValue();
        String contrasena = contraseniaField.getText();

        if (nombres.isEmpty() || apellidos.isEmpty() || cedula.isEmpty() || direccion.isEmpty() ||
                tipoUsuario == null || contrasena.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return;
        }

        System.out.println("Registro exitoso:");
        System.out.println("Nombres: " + nombres + ", Apellidos: " + apellidos +
                ", Cédula: " + cedula + ", Dirección: " + direccion +
                ", Tipo de usuario: " + tipoUsuario);

        mostrarAlerta("Registro Exitoso", "Usuario registrado correctamente.");
        mostrarPaginaMuro();

    }
    private void mostrarPaginaMuro(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/Muro.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) registrarseButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
            mostrarAlerta("Error", "Error al mostrar la pagina");
        }
}
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

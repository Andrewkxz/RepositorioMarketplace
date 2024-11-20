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

/**
 * Controlador para la vista de registro de usuario en el marketplace.
 * Gestiona el registro de nuevos usuarios en el sistema.
 */
public class RegistroViewController {

    @FXML
    private TextField nombresField; // Campo para ingresar los nombres del usuario

    @FXML
    private TextField apellidosField; // Campo para ingresar los apellidos del usuario

    @FXML
    private TextField cedulaField; // Campo para ingresar la cédula del usuario

    @FXML
    private TextField direccionField; // Campo para ingresar la dirección del usuario

    @FXML
    private ChoiceBox<String> tipoUsuarioChoiceBox; // ChoiceBox para seleccionar el tipo de usuario (Vendedor/Administrador)

    @FXML
    private PasswordField contraseniaField; // Campo para ingresar la contraseña del usuario

    @FXML
    private Button registrarseButton; // Botón para ejecutar el registro

    /**
     * Método de inicialización para configurar el ChoiceBox y el evento del botón de registro.
     */
    @FXML
    private void initialize() {
        tipoUsuarioChoiceBox.getItems().addAll("Vendedor", "Administrador"); // Agrega las opciones al ChoiceBox

        // Asocia el evento de clic del botón "Registrarse" al método de registro
        registrarseButton.setOnAction(event -> registro());
    }

    /**
     * Método para realizar el registro del nuevo usuario.
     */
    private void registro() {
        // Obtiene los valores de los campos de texto
        String nombres = nombresField.getText();
        String apellidos = apellidosField.getText();
        String cedula = cedulaField.getText();
        String direccion = direccionField.getText();
        String tipoUsuario = tipoUsuarioChoiceBox.getValue();
        String contrasena = contraseniaField.getText();

        // Verifica si alguno de los campos está vacío
        if (nombres.isEmpty() || apellidos.isEmpty() || cedula.isEmpty() || direccion.isEmpty() ||
                tipoUsuario == null || contrasena.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return;
        }

        // Simula un registro exitoso (aquí se puede agregar lógica para registrar el usuario en la base de datos)
        System.out.println("Registro exitoso:");
        System.out.println("Nombres: " + nombres + ", Apellidos: " + apellidos +
                ", Cédula: " + cedula + ", Dirección: " + direccion +
                ", Tipo de usuario: " + tipoUsuario);

        // Muestra una alerta de éxito
        mostrarAlerta("Registro Exitoso", "Usuario registrado correctamente.");

        // Redirige a la página del muro después del registro
        mostrarPaginaMuro();
    }

    /**
     * Método para cargar la vista del muro después del registro.
     */
    private void mostrarPaginaMuro() {
        try {
            // Carga el archivo FXML de la vista del muro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/Muro.fxml"));
            Parent root = loader.load();

            // Establece la nueva escena en la ventana actual
            Scene scene = new Scene(root);
            Stage stage = (Stage) registrarseButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "Error al mostrar la página del muro");
        }
    }

    /**
     * Método para mostrar una alerta con un mensaje determinado.
     *
     * @param titulo Título de la alerta
     * @param mensaje Mensaje de la alerta
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        // Crea y muestra una alerta de tipo información
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

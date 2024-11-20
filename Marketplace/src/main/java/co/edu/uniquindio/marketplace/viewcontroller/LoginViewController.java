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

/**
 * Controlador para la vista de inicio de sesión en el marketplace. Gestiona la autenticación
 * de usuarios y la navegación a la página de registro.
 */
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

    /**
     * Constructor vacío de la clase.
     */
    public LoginViewController() {
    }

    /**
     * Establece el objeto marketplace para acceder a los datos de los usuarios.
     *
     * @param marketplace El objeto Marketplace que contiene los usuarios.
     */
    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    /**
     * Inicializa la vista, cargando las opciones de rol (Vendedor o Administrador) en el ChoiceBox.
     */
    @FXML
    public void initialize() {
        rol.getItems().addAll("Vendedor", "Administrador");
    }

    /**
     * Método llamado al hacer clic en el botón "Ingresar". Verifica las credenciales del usuario
     * y muestra un mensaje de éxito o error.
     *
     * @param event El evento generado por el botón.
     */
    @FXML
    public void ingresar(ActionEvent event) {
        String nombreUsuario = usuario.getText();
        String contraseniaUsuario = contrasenia.getText();
        String rolUsuario = rol.getValue();

        Usuario usuario = marketplace.buscarUsuario(nombreUsuario);

        // Verifica las credenciales del usuario
        if (usuario != null && usuario.getContrasenia().equals(contraseniaUsuario) && usuario.getRol().equals(rolUsuario)) {
            mostrarAlerta("Éxito", "Inicio de sesión exitoso.", AlertType.INFORMATION);
        } else if (usuario == null) {
            mostrarAlerta("Error", "El usuario no existe. Por favor, regístrate.", AlertType.ERROR);
            mostrarPaginaRegistro();
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos", AlertType.ERROR);
        }
    }

    /**
     * Método llamado al hacer clic en el botón "Registrar". Muestra la página de registro.
     *
     * @param event El evento generado por el botón.
     */
    @FXML
    public void registro(ActionEvent event) {
        mostrarPaginaRegistro();
    }

    /**
     * Carga la vista de registro y la muestra en la ventana principal.
     */
    private void mostrarPaginaRegistro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/Registro.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) ingresar.getScene().getWindow();

            // Cambia la escena a la página de registro
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "Error al mostrar el registro.", AlertType.ERROR);
        }
    }

    /**
     * Muestra una alerta con un título, contenido y tipo de alerta especificado.
     *
     * @param titulo El título de la alerta.
     * @param contenido El contenido de la alerta.
     * @param tipoAlerta El tipo de alerta a mostrar.
     */
    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipoAlerta) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
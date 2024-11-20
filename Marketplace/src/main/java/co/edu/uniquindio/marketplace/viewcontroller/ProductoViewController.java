package co.edu.uniquindio.marketplace.viewcontroller;
import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.model.Producto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Controlador para la vista de un producto en el marketplace.
 * Muestra la información detallada de un producto en la interfaz.
 */
public class ProductoViewController {

    @FXML
    private Label nombreProducto; // Etiqueta para mostrar el nombre del producto.

    @FXML
    private ImageView imagenProducto; // Imagen del producto (actualmente comentada, se puede descomentar en el futuro).

    @FXML
    private Label descripcionProducto; // Etiqueta para mostrar la descripción del producto.

    @FXML
    private Label precioProducto; // Etiqueta para mostrar el precio del producto.

    private ProductoDto productoDto; // Objeto DTO del producto para mantener los datos.

    /**
     * Método para actualizar los datos de la vista con los valores del ProductoDto.
     *
     * @param productoDto El objeto DTO que contiene los datos del producto a mostrar.
     */
    public void cambiarDatos(ProductoDto productoDto) {
        nombreProducto.setText(productoDto.nombre()); // Establece el nombre del producto.

        // Descomentar cuando se tenga la funcionalidad de cargar la imagen.
        // imagenProducto.setImage(productoDto.imagen()); // Establece la imagen del producto.

        precioProducto.setText(String.valueOf(productoDto.precio())); // Establece el precio del producto.

        this.productoDto = productoDto; // Asocia el objeto DTO para acceder a los datos si es necesario más adelante.
    }
}

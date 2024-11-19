package co.edu.uniquindio.marketplace.viewcontroller;
import co.edu.uniquindio.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.model.Producto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProductoViewController {

    @FXML
    private Label nombreProducto;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Label descripcionProducto;

    @FXML
    private Label precioProducto;

    ProductoDto productoDto;

    public void cambiarDatos(ProductoDto productoDto) {
        nombreProducto.setText(productoDto.nombre());
        //imagenProducto.setImage(productoDto.imagen());
        precioProducto.setText(String.valueOf(productoDto.precio()));
        this.productoDto = productoDto;

    }
}

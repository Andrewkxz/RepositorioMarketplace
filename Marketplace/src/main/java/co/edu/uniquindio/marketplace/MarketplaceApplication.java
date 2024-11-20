package co.edu.uniquindio.marketplace;

import co.edu.uniquindio.marketplace.model.Marketplace;
import co.edu.uniquindio.marketplace.viewcontroller.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MarketplaceApplication extends Application {

    private Marketplace marketplace;

    @Override
    public void start(Stage primaryStage) throws Exception {
        marketplace = new Marketplace();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/LoginPrueba.fxml"));
        Parent root = loader.load();

        LoginViewController controller = loader.getController();
        controller.setMarketplace(new Marketplace());

        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }
}
module co.edu.uniquindio.marketplace {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens co.edu.uniquindio.marketplace.viewcontroller to javafx.fxml;
    exports co.edu.uniquindio.marketplace;
}
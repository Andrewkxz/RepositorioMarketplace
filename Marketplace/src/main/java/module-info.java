module co.edu.uniquindio.marketplace {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens co.edu.uniquindio.marketplace to javafx.fxml;
    exports co.edu.uniquindio.marketplace;
    exports co.edu.uniquindio.marketplace.controller;
    opens co.edu.uniquindio.marketplace.controller to javafx.fxml;
}
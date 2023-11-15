module com.uniquindio.bd2.viajesmaravillosos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.uniquindio.bd2.viajesmaravillosos to javafx.fxml;
    exports com.uniquindio.bd2.viajesmaravillosos;
}
module com.uniquindio.bd2.viajesmaravillosos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires ojdbc10;

    opens com.uniquindio.bd2.viajesmaravillosos to javafx.fxml;
    exports com.uniquindio.bd2.viajesmaravillosos;
    exports com.uniquindio.bd2.viajesmaravillosos.database;
    opens com.uniquindio.bd2.viajesmaravillosos.database to javafx.fxml;
    opens com.uniquindio.bd2.viajesmaravillosos.auto to javafx.base;
}
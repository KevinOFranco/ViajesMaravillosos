package com.uniquindio.bd2.viajesmaravillosos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioUsuarioController {

    private Stage ventana;

    @FXML
    void irVistaReservaArticulo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reserva-articulo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        ventana.close();
    }

    @FXML
    void irVistaLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        ventana.close();
    }

    public void setStage(Stage ventana) {
        this.ventana = ventana;
    }
}

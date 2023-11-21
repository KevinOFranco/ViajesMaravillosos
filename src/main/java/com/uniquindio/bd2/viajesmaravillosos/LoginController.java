package com.uniquindio.bd2.viajesmaravillosos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Stage ventana;

    @FXML
    void irVistaAdmin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inicio-admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        InicioAdminController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        ventana.close();
    }

    @FXML
    void irVistaUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inicio-usuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        InicioUsuarioController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        ventana.close();
    }

    public void setStage(Stage stage) {
        this.ventana = stage;
    }
}

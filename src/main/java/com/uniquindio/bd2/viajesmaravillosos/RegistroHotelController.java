package com.uniquindio.bd2.viajesmaravillosos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroHotelController {
    private Stage stage;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField txtNombre;

    @FXML
    void registrar(ActionEvent event) {
        stage.close();
    }

    @FXML
    void initialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("contenido-registro-hotel.fxml"));
        scrollPane.setContent(fxmlLoader.load());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

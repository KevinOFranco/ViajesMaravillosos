package com.uniquindio.bd2.viajesmaravillosos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroAutoController {
    private Stage stage;

    @FXML
    private TextField txtNombre;

    @FXML
    void registrar(ActionEvent event) {
        stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

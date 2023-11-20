package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.database.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegistroAutoController {

    @FXML
    private TextField txtGama;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtPrecio;

    @FXML
    void actualizarAuto(ActionEvent event) {

    }

    @FXML
    void eliminarAuto(ActionEvent event) {

    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        txtGama.clear();
        txtMarca.clear();
        txtPrecio.clear();
    }

    @FXML
    void registrarAuto(ActionEvent event) {
        DataBase.conexion("SELECT * FROM TRANSACCION");
    }

}

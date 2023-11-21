package com.uniquindio.bd2.viajesmaravillosos.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class Util {
    public static void asignarColumna(TableColumn columna, String nombre){
        columna.setCellValueFactory(new PropertyValueFactory<>(nombre));
    }

    public static boolean isConfirmacion (String titulo, String pregunta){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(pregunta);
        Optional<ButtonType> action = alert.showAndWait();

        return action.get() == ButtonType.OK;
    }
}

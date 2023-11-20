package com.uniquindio.bd2.viajesmaravillosos.util;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Util {
    public static void asignarColumna(TableColumn columna, String nombre){
        columna.setCellValueFactory(new PropertyValueFactory<>(nombre));
    }
}

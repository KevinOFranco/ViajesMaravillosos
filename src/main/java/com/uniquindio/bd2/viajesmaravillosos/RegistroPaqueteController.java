package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.database.DataBase;
import com.uniquindio.bd2.viajesmaravillosos.model.Paquete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.uniquindio.bd2.viajesmaravillosos.util.Util.asignarColumna;
public class RegistroPaqueteController {

    @FXML
    private TableColumn<?, ?> columnaCodigoPaquete;

    @FXML
    private TableColumn<?, ?> columnaCodigoPolitica;

    @FXML
    private TableView<Paquete> tablaPaquete;

    @FXML
    private TextField txtCodigoPaquete;

    @FXML
    private TextField txtCodigoPolitica;

    private ObservableList<Paquete> datosTabla;

    @FXML
    private void initialize() throws SQLException {
        asignarColumna(columnaCodigoPaquete, "Codigo Paquete");
        asignarColumna(columnaCodigoPolitica, "Codigo Politica");

        datosTabla = FXCollections.observableArrayList();
        tablaPaquete.setItems(datosTabla);

        ResultSet resultado = DataBase.conexion("SELECT * FROM paquete_turistico");

        while (resultado.next()) {
            datosTabla.add(
                    new Paquete(
                            resultado.getString(1),
                            resultado.getString(2)
                    )
            );
        }
    }

    @FXML
    void registrarPaquete(ActionEvent event) {
        DataBase.conexion("INSERT INTO paquete_turistico (id_paquete, id_politica) " +
                "VALUES (" +
                "'" + txtCodigoPaquete.getText() + "', " +
                "'" + txtCodigoPolitica.getText() + "')");
    }

    @FXML
    void actualizarPaquete(ActionEvent event) {
        DataBase.conexion("UPDATE paquete_turistico SET " +
                "id_politica = '" + txtCodigoPolitica.getText() + "' " +
                "WHERE id_paquete = '" + txtCodigoPaquete.getText() + "'");
    }

    @FXML
    void eliminarPaquete(ActionEvent event) {
        DataBase.conexion("DELETE FROM paquete_turistico WHERE id_paquete='" + txtCodigoPaquete.getText() + "'");
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        txtCodigoPaquete.clear();
        txtCodigoPolitica.clear();
    }
}

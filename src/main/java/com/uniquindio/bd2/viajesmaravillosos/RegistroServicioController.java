package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.database.DataBase;
import com.uniquindio.bd2.viajesmaravillosos.model.Servicio;
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

public class RegistroServicioController {

    @FXML
    private TableColumn<?, ?> columnaCodigoPaquete;

    @FXML
    private TableColumn<?, ?> columnaCodigoServicio;

    @FXML
    private TableColumn<?, ?> columnaServicio;

    @FXML
    private TableView<Servicio> tablaServicio;

    @FXML
    private TextField txtCodigoPaquete;

    @FXML
    private TextField txtCodigoServicio;

    @FXML
    private TextField txtServicio;

    private ObservableList<Servicio> datosTabla;

    @FXML
    private void initialize() throws SQLException {
        asignarColumna(columnaCodigoPaquete, "Codigo Servicio");
        asignarColumna(columnaCodigoServicio, "Servicio");
        asignarColumna(columnaServicio, "Codigo Paquete");

        datosTabla = FXCollections.observableArrayList();
        tablaServicio.setItems(datosTabla);

        // Obtener datos de la base de datos y cargar en la tabla
        ResultSet resultado = DataBase.conexion("SELECT * FROM servicio_paquete");

        while (resultado.next()) {
            datosTabla.add(
                    new Servicio(
                            resultado.getString(1),
                            resultado.getString(2),
                            resultado.getString(3)
                    )
            );
        }
    }

    @FXML
    void registrarServicio(ActionEvent event) {
        DataBase.conexion("INSERT INTO servicio_paquete (id_servicio_paquete, servicio, id_paquete) " +
                "VALUES (" +
                "'" + txtCodigoServicio.getText() + "', " +
                "'" + txtServicio.getText() + "', " +
                "'" + txtCodigoPaquete.getText() + "')");
    }
    @FXML
    void actualizarServicio(ActionEvent event) {
        DataBase.conexion("UPDATE servicio_paquete SET " +
                "servicio = '" + txtServicio.getText() + "', " +
                "id_paquete = '" + txtCodigoPaquete.getText() + "' " +
                "WHERE id_servicio_paquete = '" + txtCodigoServicio.getText() + "'");
    }

    @FXML
    void eliminarServicio(ActionEvent event) {
        DataBase.conexion("DELETE FROM servicio_paquete WHERE id_servicio_paquete='" + txtCodigoServicio.getText() + "'");
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        txtCodigoPaquete.clear();
        txtCodigoServicio.clear();
        txtServicio.clear();
    }
}

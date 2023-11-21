package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.database.DataBase;
import com.uniquindio.bd2.viajesmaravillosos.model.Servicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.uniquindio.bd2.viajesmaravillosos.util.Util.asignarColumna;
import static com.uniquindio.bd2.viajesmaravillosos.util.Util.isConfirmacion;

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
        asignarColumna(columnaCodigoPaquete, "idPaquete");
        asignarColumna(columnaCodigoServicio, "idServicioPaquete");
        asignarColumna(columnaServicio, "servicio");

        datosTabla = FXCollections.observableArrayList();
        tablaServicio.setItems(datosTabla);

        capturarDatosEnInputs();
        actualizarTabla();
    }

    private void capturarDatosEnInputs() {
        tablaServicio.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (isConfirmacion("Capturar datos", "¿Estas seguro de sobreescribir los campos?"))){
                    Servicio servicio = tablaServicio.getSelectionModel().getSelectedItem();
                    txtServicio.setText(servicio.getServicio());
                    txtCodigoPaquete.setText(servicio.getIdPaquete());
                    txtCodigoServicio.setText(servicio.getIdServicioPaquete());
            }
        });
    }

    private void actualizarTabla () throws SQLException {
        datosTabla.clear();

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
    void registrarServicio(ActionEvent event) throws SQLException {
        DataBase.conexion("INSERT INTO servicio_paquete (id_servicio_paquete, servicio, id_paquete) " +
                "VALUES (" +
                "'" + txtCodigoServicio.getText() + "', " +
                "'" + txtServicio.getText() + "', " +
                "'" + txtCodigoPaquete.getText() + "')");

        actualizarTabla();
    }
    @FXML
    void actualizarServicio(ActionEvent event) throws SQLException {
        DataBase.conexion("UPDATE servicio_paquete SET " +
                "servicio = '" + txtServicio.getText() + "', " +
                "id_paquete = '" + txtCodigoPaquete.getText() + "' " +
                "WHERE id_servicio_paquete = '" + txtCodigoServicio.getText() + "'");

        actualizarTabla();
    }

    @FXML
    void eliminarServicio(ActionEvent event) {
        if (isConfirmacion("Eliminar registro", "¿Desea eliminar el registro?"))
            DataBase.conexion("DELETE FROM servicio_paquete WHERE id_servicio_paquete='" + txtCodigoServicio.getText() + "'");
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        txtCodigoPaquete.clear();
        txtCodigoServicio.clear();
        txtServicio.clear();
    }
}

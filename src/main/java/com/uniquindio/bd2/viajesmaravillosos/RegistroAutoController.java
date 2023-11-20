package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.auto.Auto;
import com.uniquindio.bd2.viajesmaravillosos.database.DataBase;
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

public class RegistroAutoController {
    @FXML
    private TableColumn<?, ?> columnaCapacidad;

    @FXML
    private TableColumn<?, ?> columnaCodigo;

    @FXML
    private TableColumn<?, ?> columnaGama;

    @FXML
    private TableColumn<?, ?> columnaMarca;

    @FXML
    private TableColumn<?, ?> columnaPrecio;

    @FXML
    private TableView<Auto> tablaAutos;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtGama;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtPrecio;

    private ObservableList<Auto> datosTabla;

    @FXML
    private void initialize() throws SQLException {
        asignarColumna(columnaCodigo, "codigo");
        asignarColumna(columnaCapacidad, "capacidad");
        asignarColumna(columnaMarca, "marca");
        asignarColumna(columnaGama, "gama");
        asignarColumna(columnaPrecio, "precio");

        datosTabla = FXCollections.observableArrayList();
        tablaAutos.setItems(datosTabla);

        ResultSet resultado = DataBase.conexion("SELECT * FROM AUTO");

        while ( resultado.next() )
        {
            datosTabla.add(
                    new Auto(
                            resultado.getString(1),
                            resultado.getInt(2),
                            resultado.getString(3),
                            resultado.getString(4),
                            String.valueOf(resultado.getFloat(7))
                    )
            );
        }
    }

    @FXML
    void actualizarAuto(ActionEvent event) {
        DataBase.conexion("UPDATE AUTO SET MARCA = '" + txtMarca.getText() + "' WHERE id_auto = 'A001' ");
        DataBase.conexion("UPDATE AUTO SET CAPACIDAD = '" + txtCapacidad.getText() + "' WHERE id_auto = 'A001' ");
        DataBase.conexion("UPDATE AUTO SET PRECIO = '" + txtPrecio.getText() + "' WHERE id_auto = 'A001' ");
        DataBase.conexion("UPDATE AUTO SET GAMA = '" + txtGama.getText() + "' WHERE id_auto = 'A001' ");
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
        DataBase.conexion("INSERT INTO auto (id_auto, capacidad, marca, gama, estadisponible, id_hotel, precio) " +
                "VALUES (" +
                "'" + txtCodigo.getText() + "', " +
                "" + txtCapacidad.getText() + ", " +
                "'" + txtMarca.getText() + "', " +
                "'" + txtGama.getText() + "', " +
                "'1', 'H024', " +
                "" + txtPrecio.getText() + ")");

    }

}

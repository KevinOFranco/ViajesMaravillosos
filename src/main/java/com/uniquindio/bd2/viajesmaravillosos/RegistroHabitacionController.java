package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.database.DataBase;
import com.uniquindio.bd2.viajesmaravillosos.model.Habitacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.uniquindio.bd2.viajesmaravillosos.util.Util.asignarColumna;

public class RegistroHabitacionController {

    @FXML
    private TableColumn<?, ?> columnaCodigoHabitacion;

    @FXML
    private TableColumn<?, ?> columnaCodigoHotel;

    @FXML
    private TableColumn<?, ?> columnaPrecio;

    @FXML
    private TableColumn<?, ?> columnaTipoHabitacion;

    @FXML
    private TableView<Habitacion> tablaHabitaciones;

    @FXML
    private TextField txtCodigoHabitacion;

    @FXML
    private TextField txtCodigoHotel;

    @FXML
    private TextField txtPrecio;

    @FXML
    private ComboBox<?> txtTipo;

    private ObservableList<Habitacion> datosTabla;

    @FXML
    private void initialize() throws SQLException {
        asignarColumna(columnaCodigoHabitacion, "Codigo Habitación");
        asignarColumna(columnaCodigoHotel, "Codigo Hotel");
        asignarColumna(columnaTipoHabitacion, "Tipo Habitación");
        asignarColumna(columnaPrecio, "Precio Noche");

        datosTabla = FXCollections.observableArrayList();
        tablaHabitaciones.setItems(datosTabla);

        ResultSet resultado = DataBase.conexion("SELECT * FROM habitacion");

        while ( resultado.next() )
        {
            datosTabla.add(
                    new Habitacion(
                            resultado.getString(1),
                            true,
                            resultado.getString(2),
                            resultado.getString(3),
                            resultado.getFloat(4)
                    )
            );
        }
    }

    void registrarHabitacion(ActionEvent event) {
        String idHabitacion = txtCodigoHabitacion.getText();
        boolean estaDisponible = true;
        String idHotel = txtCodigoHotel.getText();
        double precioNoche = Double.parseDouble(txtPrecio.getText());
        String tipoHabitacion = (String) txtTipo.getValue();

        datosTabla.add(new Habitacion(idHabitacion, estaDisponible, idHotel, tipoHabitacion, precioNoche));

        DataBase.conexion("INSERT INTO habitacion (id_habitacion, estadisponible, id_hotel, precio_noche, tipo_habitacion) " +
                "VALUES ('" + idHabitacion + "', '" + estaDisponible + "', '" + idHotel + "', " + precioNoche + ", '" + tipoHabitacion + "')");
    }

    @FXML
    void actualizarHabitacion(ActionEvent event) {
        String nuevoCodigoHotel = txtCodigoHotel.getText();
        double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
        String nuevoTipo = (String) txtTipo.getValue();

        // Actualiza la habitación en la base de datos
        DataBase.conexion("UPDATE habitacion SET " +
                "id_hotel = '" + nuevoCodigoHotel + "', " +
                "precio_noche = " + nuevoPrecio + ", " +
                "tipo_habitacion = '" + nuevoTipo + "' " +
                "WHERE id_habitacion = '" + txtCodigoHabitacion.getText() + "'");
    }

    void eliminarHabitacion(ActionEvent event) {
        String idHabitacionEliminar = txtCodigoHabitacion.getText();

        // Elimina la habitación de la base de datos
        DataBase.conexion("DELETE FROM habitacion WHERE id_habitacion='" + idHabitacionEliminar + "'");
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        txtCodigoHabitacion.clear();
        txtCodigoHotel.clear();
        txtPrecio.clear();
        txtTipo.getSelectionModel().clearSelection();
    }
}

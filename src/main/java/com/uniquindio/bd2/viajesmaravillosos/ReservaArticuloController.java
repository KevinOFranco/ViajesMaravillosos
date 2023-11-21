package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.database.DataBase;
import com.uniquindio.bd2.viajesmaravillosos.model.Articulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import static com.uniquindio.bd2.viajesmaravillosos.util.Util.asignarColumna;

public class ReservaArticuloController {

    @FXML
    private TableColumn<?, ?> columnaCodigoDisponibles;

    @FXML
    private TableColumn<?, ?> columnaCodigoUsuario;

    @FXML
    private TableColumn<?, ?> columnaNombreDisponibles;

    @FXML
    private TableColumn<?, ?> columnaNombreUsuario;

    @FXML
    private TableColumn<?, ?> columnaPrecioDisponibles;

    @FXML
    private TableColumn<?, ?> columnaPrecioUsuario;

    @FXML
    private TableView<Articulo> tablaArticulosDisponibles;

    @FXML
    private TableView<Articulo> tablaArticulosUsuario;

    private ObservableList<Articulo> datosTablaDisponibles;

    private ObservableList<Articulo> datosTablaUsuarios;

    Articulo articuloSeleccionado;

    @FXML
    private void initialize() throws SQLException {
        asignarColumna(columnaCodigoDisponibles, "Codigo");
        asignarColumna(columnaNombreDisponibles, "Nombre");
        asignarColumna(columnaPrecioDisponibles, "Precio");

        datosTablaDisponibles = FXCollections.observableArrayList();
        tablaArticulosDisponibles.setItems(datosTablaDisponibles);

        ResultSet resultado = DataBase.conexion("SELECT * FROM articulo_tienda");

        while (resultado.next()) {
            datosTablaDisponibles.add(
                    new Articulo(
                            resultado.getString(1),
                            resultado.getString(2),
                            resultado.getFloat(3)
                    )
            );
        }

        tablaArticulosDisponibles.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                articuloSeleccionado = tablaArticulosDisponibles.getSelectionModel().getSelectedItem();
            }
        });

        asignarColumna(columnaCodigoUsuario, "Codigo");
        asignarColumna(columnaNombreUsuario, "Nombre");
        asignarColumna(columnaPrecioUsuario, "Precio");

        datosTablaUsuarios = FXCollections.observableArrayList();
        tablaArticulosUsuario.setItems(datosTablaUsuarios);

        resultado = DataBase.conexion("SELECT * FROM articulo_tienda art " +
                "JOIN pedido ped ON art.id_articulo = ped.id_articulo AND "+
                "ped.id_persona = 'P001'");

        while (resultado.next()) {
            datosTablaUsuarios.add(
                    new Articulo(
                            resultado.getString(1),
                            resultado.getString(2),
                            resultado.getFloat(3)
                    )
            );
        }

        tablaArticulosUsuario.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                articuloSeleccionado = tablaArticulosUsuario.getSelectionModel().getSelectedItem();
            }
        });
    }

    @FXML
    void reservarArticulo(ActionEvent event) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(900) + 100;

        DataBase.conexion("INSERT INTO pedido (" +
                "id_detalle_reserva, fecha, saldo, " +
                "cantidad, estapagado, id_persona, " +
                "id_articulo) " +
                "VALUES (" +
                "'D'"+numeroAleatorio+", TO_DATE('2023-11-21', 'YYYY-MM-DD'), "+ articuloSeleccionado.getPrecio() + ", " +
                "2, 0, 'P001', '" +
                articuloSeleccionado.getCodigo() + "')");
    }

    @FXML
    void removerArticulo(ActionEvent event) {
        DataBase.conexion("DELETE FROM pedido WHERE id_persona='P001' AND id_articulo="+articuloSeleccionado.getCodigo());
    }
}

package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.model.Articulo;
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

public class RegistroArticuloController {
    @FXML
    private TableColumn<?, ?> columnaCodigo;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaPrecio;

    @FXML
    private TableView<Articulo> tablaArticulos;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    private ObservableList<Articulo> datosTabla;

    @FXML
    private void initialize() throws SQLException {
        asignarColumna(columnaCodigo, "codigo");
        asignarColumna(columnaNombre, "nombre");
        asignarColumna(columnaPrecio, "precio");

        datosTabla = FXCollections.observableArrayList();
        tablaArticulos.setItems(datosTabla);

        ResultSet resultado = DataBase.conexion("SELECT * FROM articulo_tienda");

        while ( resultado.next() )
        {
            datosTabla.add(
                    new Articulo(
                            resultado.getString(1),
                            resultado.getString(2),
                            resultado.getFloat(3)
                    )
            );
        }
    }

    @FXML
    void registrarAuto(ActionEvent event) {
        DataBase.conexion("INSERT INTO articulo_tienda (id_articulo, nombre_articulo, precio_articulo) " +
                "VALUES (" +
                "'" + txtCodigo.getText() + "', " +
                "'" + txtNombre.getText() + "', " +
                "" + txtPrecio.getText() + " " + ")");
    }

    @FXML
    void actualizarAuto(ActionEvent event) {
        DataBase.conexion("UPDATE articulo_tienda SET "+
                "NOMBRE = '" + txtNombre.getText() + "', "+
                "PRECIO = "+ txtPrecio.getText() + " " +
                "WHERE id_articulo = '"+txtCodigo.getText()+"' ");
    }

    @FXML
    void eliminarArticulo(ActionEvent event) {
        DataBase.conexion("DELETE FROM articulo_tienda WHERE id_articulo="+ txtCodigo.getText());
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
    }
}

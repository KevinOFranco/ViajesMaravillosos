package com.uniquindio.bd2.viajesmaravillosos;

import com.uniquindio.bd2.viajesmaravillosos.model.Articulo;
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
import static com.uniquindio.bd2.viajesmaravillosos.util.Util.isConfirmacion;

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

        actualizarTabla();
        capturarDatosEnInputs();
    }

    @FXML
    void registrarArticulo(ActionEvent event) throws SQLException {
        DataBase.conexion("INSERT INTO articulo_tienda (id_articulo, nombre_articulo, precio_articulo) " +
                "VALUES (" +
                "'" + txtCodigo.getText() + "', " +
                "'" + txtNombre.getText() + "', " +
                "" + txtPrecio.getText() + " " + ")");
        actualizarTabla();
    }

    @FXML
    void actualizarArticulo(ActionEvent event) throws SQLException {
        if (isConfirmacion("Actualizar datos", "¿Estas seguro de actualizar los datos?")) {
            DataBase.conexion("UPDATE articulo_tienda SET "+
                    "nombre_articulo = '" + txtNombre.getText() + "', "+
                    "precio_articulo = "+ txtPrecio.getText() + " " +
                    "WHERE id_articulo = '"+txtCodigo.getText()+"' ");
            actualizarTabla();
        }
    }

    @FXML
    void eliminarArticulo(ActionEvent event) throws SQLException {
        if (isConfirmacion("Borrar datos", "¿Estas seguro de borrar los datos?")) {
            DataBase.conexion("DELETE FROM articulo_tienda WHERE id_articulo="+ txtCodigo.getText());
            actualizarTabla();
        }
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
    }

    private void actualizarTabla () throws SQLException {
        datosTabla.clear();
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

    private void capturarDatosEnInputs() {
        tablaArticulos.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (isConfirmacion("Capturar datos", "¿Estas seguro de sobreescribir los campos?"))){
                Articulo obj = tablaArticulos.getSelectionModel().getSelectedItem();
                txtCodigo.setText(obj.getCodigo());
                txtNombre.setText(obj.getNombre());
                txtPrecio.setText(obj.getPrecio() + "");
            }
        });
    }
}

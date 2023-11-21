package com.uniquindio.bd2.viajesmaravillosos.database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataBase {

    public static ResultSet conexion (String query){
        try
        {
            //Se carga el driver JDBC
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            //nombre del servidor
            String nombre_servidor = "127.0.0.1";
            //numero del puerto
            String numero_puerto = "1521";
            //SID
            String sid = "xe";
            //URL "jdbc:oracle:thin:@nombreServidor:numeroPuerto:SID"
            String url = "jdbc:oracle:thin:@" + nombre_servidor + ":" + numero_puerto + ":" + sid;

            //Nombre usuario y password
            String usuario = "VICTOR_PROY_2";
            String password = "123";

            //Obtiene la conexion
            Connection conexion = DriverManager.getConnection( url, usuario, password );

            //Para realiza una consulta
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery( query );

            //Cerramos la sentencia
            //sentencia.close();

            return resultado;
        }catch( Exception e ){
            e.printStackTrace();
        }
        return null;
    }
}
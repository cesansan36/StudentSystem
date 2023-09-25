package com.cess.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection getConnectionBD() {
        // Objeto para guardar la conexion
        Connection connection = null;

        // Variables de conexion
        String db = "sena_db";
        String url = "jdbc:mysql://localhost:3307/" + db;
        String name = "root";
        String pass = "root";

        try {
            // Comprobar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Intenta conectarse a la base de datos
            connection = DriverManager.getConnection(url, name, pass);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Ocurrio un error en la conexion: " + ex.getMessage());

        }

        return connection;
    }

    public static void main(String[] args) {
        Connection conexion = ConnectionDB.getConnectionBD();

        if (conexion != null) {
            System.out.println("Conexion exitosa: " + conexion);
        }
        else {
            System.out.println("Error en la conexion: " + conexion);
        }
    }
}

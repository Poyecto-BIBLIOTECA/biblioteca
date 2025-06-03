package org.biblioteca.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public static Connection initConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Conexion cerrada correctamente");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

}

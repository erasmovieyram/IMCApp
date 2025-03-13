/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/IMCAppDB?serverTimezone=UTC"; // Ajusta según tu configuración
    private static final String USER = "root"; // Usuario de la base de datos
    private static final String PASSWORD = "12345678"; // Contraseña de la base de datos

    public static Connection getConnection() {
        try {
            // Cargar el controlador MySQL (opcional en versiones modernas)
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null; // Retorna null si hay un error
        }
    }
}
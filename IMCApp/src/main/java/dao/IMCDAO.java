/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.IMC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IMCDAO {
    private Connection conexion;

    public IMCDAO() {
        this.conexion = ConexionBD.getConnection(); // Usa la clase de conexión creada anteriormente
    }

    // Método para guardar una nueva medición de IMC
    public void guardar(IMC imc) {
        String query = "INSERT INTO IMC (usuario_id, imc, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, imc.getUsuarioId());
            stmt.setFloat(2, imc.getImc());
            stmt.setDate(3, new java.sql.Date(imc.getFecha().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener el historial de IMC de un usuario
    public List<IMC> obtenerHistorial(int usuarioId) {
        List<IMC> historial = new ArrayList<>();
        String query = "SELECT * FROM IMC WHERE usuario_id = ? ORDER BY fecha DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                IMC imc = new IMC(
                    rs.getInt("usuario_id"),
                    rs.getFloat("imc"),
                    rs.getDate("fecha")
                );
                imc.setId(rs.getInt("id")); // Asigna el ID de la medición
                historial.add(imc); // Agrega la medición al historial
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historial; // Retorna el historial de IMC
    }
}
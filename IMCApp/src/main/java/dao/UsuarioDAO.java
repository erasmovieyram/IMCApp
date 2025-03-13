/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Usuario;
import java.sql.*;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO() {
        this.conexion = ConexionBD.getConnection(); // Obtiene la conexión
        if (this.conexion == null) {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
        }
    }

    // Método para registrar un nuevo usuario
    public boolean registrar(Usuario usuario) {
        String query = "INSERT INTO Usuario (nombre_completo, edad, sexo, estatura, peso, nombre_usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombreCompleto());
            stmt.setInt(2, usuario.getEdad());
            stmt.setString(3, usuario.getSexo());
            stmt.setFloat(4, usuario.getEstatura());
            stmt.setFloat(5, usuario.getPeso());
            stmt.setString(6, usuario.getNombreUsuario());
            stmt.setString(7, usuario.getContrasena());
            stmt.executeUpdate();
            return true; // Registro exitoso
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error al registrar
        }
    }

    // Método para autenticar un usuario
    public Usuario autenticar(String nombreUsuario, String contrasena) {
        String query = "SELECT * FROM Usuario WHERE nombre_usuario = ? AND contrasena = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombreUsuario);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("nombre_completo"),
                    rs.getInt("edad"),
                    rs.getString("sexo"),
                    rs.getFloat("estatura"),
                    rs.getFloat("peso"),
                    rs.getString("nombre_usuario"),
                    rs.getString("contrasena")
                );
                usuario.setId(rs.getInt("id")); // Asigna el ID del usuario
                return usuario; // Retorna el usuario si existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encuentra el usuario
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;

@WebServlet("/RegistroUsuarioServlet")
public class RegistroUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String nombreCompleto = request.getParameter("nombre_completo");
        String nombreUsuario = request.getParameter("nombre_usuario");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        float estatura = Float.parseFloat(request.getParameter("estatura"));
        float peso = Float.parseFloat(request.getParameter("peso"));
        String contrasena = request.getParameter("contrasena");

        // Validaciones
        if (estatura < 1 || estatura > 2.5) {
            request.setAttribute("error", "La estatura debe estar entre 1m y 2.5m.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        if (edad < 15) {
            request.setAttribute("error", "La edad mínima es 15 años.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        // Crear objeto Usuario
        Usuario usuario = new Usuario(nombreCompleto, edad, sexo, estatura, peso, nombreUsuario, contrasena);

        // Guardar en la base de datos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean registrado = usuarioDAO.registrar(usuario);

        if (registrado) {
            response.sendRedirect("login.jsp"); // Redirigir al inicio de sesión
        } else {
            request.setAttribute("error", "El nombre de usuario ya está en uso.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}

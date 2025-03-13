/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.IMCDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.IMC;
import modelo.Usuario;

import java.io.IOException;
import java.util.Date;

@WebServlet("/CalcularIMCServlet")
public class CalcularIMCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp"); // Redirigir si no hay sesión
            return;
        }

        // Obtener la masa corporal
        float masa = Float.parseFloat(request.getParameter("masa"));

        // Validar la masa corporal
        if (masa <= 0) {
            request.setAttribute("error", "La masa corporal debe ser mayor a 0.");
            request.getRequestDispatcher("calculo.jsp").forward(request, response);
            return;
        }

        // Calcular el IMC
        float imc = masa / (usuario.getEstatura() * usuario.getEstatura());

        // Guardar el IMC en la base de datos
        IMC nuevoIMC = new IMC(usuario.getId(), imc, new Date());
        IMCDAO imcDAO = new IMCDAO();
        imcDAO.guardar(nuevoIMC);

        // Mostrar el resultado
        request.setAttribute("imc", imc);
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}
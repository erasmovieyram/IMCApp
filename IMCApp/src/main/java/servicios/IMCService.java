/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dao.IMCDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import modelo.IMC;

import java.util.List;

@Path("/api") // Define la ruta base del servicio REST
public class IMCService {

    @GET
    @Path("/imc") // Define el endpoint específico
    @Produces(MediaType.APPLICATION_JSON) // Indica que el servicio devuelve JSON
    public List<IMC> getHistorial(@QueryParam("usuario_id") int usuarioId) {
        // Obtener el historial de IMC desde la base de datos
        IMCDAO imcDAO = new IMCDAO();
        return imcDAO.obtenerHistorial(usuarioId);
    }
}
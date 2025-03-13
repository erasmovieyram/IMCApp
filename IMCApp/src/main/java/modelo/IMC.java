/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

public class IMC {
    private int id; // Identificador único (se asigna automáticamente en la base de datos)
    private int usuarioId; // ID del usuario asociado
    private float imc; // Valor del IMC calculado
    private Date fecha; // Fecha de la medición

    // Constructor vacío (necesario para frameworks como Hibernate)
    public IMC() {}

    // Constructor con parámetros
    public IMC(int usuarioId, float imc, Date fecha) {
        this.usuarioId = usuarioId;
        this.imc = imc;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

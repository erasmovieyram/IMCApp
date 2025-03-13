/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Usuario {
    private int id; // Identificador único (se asigna automáticamente en la base de datos)
    private String nombreCompleto;
    private int edad;
    private String sexo;
    private float estatura; // En metros
    private float peso; // En kilogramos
    private String nombreUsuario; // Nombre de usuario único
    private String contrasena; // Contraseña del usuario

    // Constructor vacío (necesario para frameworks como Hibernate)
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombreCompleto, int edad, String sexo, float estatura, float peso, String nombreUsuario, String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sexo = sexo;
        this.estatura = estatura;
        this.peso = peso;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public boolean esEdadValida(int edad) {
    return edad >= 15;
    }
    
    public boolean esEstaturaValida(float estatura) {
    return estatura >= 1.0 && estatura <= 2.5;
    }
    
}
package org.example.modelo;

public class Cliente {
    private int id;
    private String nombreCompleto;
    private String correo;

    public Cliente(int id, String nombreCompleto, String correo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    public int getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getCorreo() { return correo; }
}
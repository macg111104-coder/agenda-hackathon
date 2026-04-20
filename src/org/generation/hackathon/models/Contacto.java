package org.generation.hackathon.models;

public class Contacto {
    private int id;
    private String nombre;
    private String apellido;
    private long telefono;
    private static int idContacto = 1;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, long telefono) {
        this.id = idContacto++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public static int getIdContacto() {
        return idContacto;
    }

    public static void setIdContacto(int idContacto) {
        Contacto.idContacto = idContacto;
    }

    @Override
    public String toString() {
        return "Contacto [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + "]";
    }
}

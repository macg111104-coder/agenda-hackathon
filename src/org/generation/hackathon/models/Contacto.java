package org.generation.hackathon.models;

import java.util.Objects;

public class Contacto {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private static int idContacto = 1;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String telefono) {
        this.id = idContacto++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static int getIdContacto() {
        return idContacto;
    }

    public static void setIdContacto(int idContacto) {
        Contacto.idContacto = idContacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto c = (Contacto) o;
        return nombre.equalsIgnoreCase(c.nombre) &&
               apellido.equalsIgnoreCase(c.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    @Override
    public String toString() {
        return "Contacto [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + "]";
    }
    
    


}

package org.generation.hackathon.models;

import java.util.Objects;

public class Contacto {
    private String nombre;
    private String apellido;

    public Contacto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

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
}

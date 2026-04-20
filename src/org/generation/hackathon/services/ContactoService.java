package org.generation.hackathon.services;
import org.generation.hackathon.models.Contacto;

public class ContactoService {
    private Map<String, Contacto> contactos = new LinkedHashMap<>();
    public void buscarContacto(String nombre, String apellido) {
        String clave = (nombre + apellido).toLowerCase();
        Contacto encontrado = contactos.get(clave);
        if (encontrado != null) {
            System.out.println("Teléfono: " + encontrado.getTelefono());
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
}

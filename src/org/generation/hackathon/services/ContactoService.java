package org.generation.hackathon.services;

import java.util.*;

import org.generation.hackathon.models.Contacto;

public class ContactoService {

    private List<Contacto> contactos;
    private int capaidadmax;

    public ContactoService() {
        this.capaidadmax = 10;
        this.contactos = new ArrayList<>();
    }

    public ContactoService(int capaidadmax) {
        this.capaidadmax = capaidadmax;
        this.contactos = new ArrayList<>();
    }

    //Eliminar un contacto por nombre y apellido
    public void eliminarContacto(Contacto contacto) {
        if (contactos.remove(contacto)) {
            System.out.println("Contacto eliminado: " + contacto.getNombre() + " " + contacto.getApellido());
        }else {
            System.out.println("Contacto no encontrado: " + contacto.getNombre() + " " + contacto.getApellido());
        }
    }

    //Modificar un contacto por nombre y apellido
    public void modificarContacto(String nombre, String apellido, int nuevo){
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && 
                c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevo);
                System.out.println("Contacto modificado: " + 
                c.getNombre() + " " + 
                c.getApellido() + " " + 
                c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado: " + nombre + " " + apellido);
    }

}

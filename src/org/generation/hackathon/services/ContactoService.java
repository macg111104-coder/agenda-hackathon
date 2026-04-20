package org.generation.hackathon.services;

import org.generation.hackathon.models.Contacto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactoService {
    private Map<Integer, Contacto> agenda = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void añadirContacto(){
        if (agendaLlena()){
            System.out.println("La lista esta llena ya no puede ingresar mas datos");
            System.exit(1);
        }else
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        if (existeContacto(nombre, apellido)) {
            System.out.println("ADVERTENCIA: El contacto '" + nombre + " " + apellido + "' ya existe en la agenda.");
            return;
        }

        System.out.print("Teléfono: ");
        long tel = Long.parseLong(sc.nextLine());

        Contacto nuevo = new Contacto(nombre, apellido, tel);

        agenda.put(nuevo.getId(), nuevo);
    }
    private boolean existeContacto(String nombre, String apellido) {
        for (Contacto c : agenda.values()) {
            // Comparamos ignorando mayúsculas/minúsculas
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                return true;
            }
        }
        return false;
    }
}

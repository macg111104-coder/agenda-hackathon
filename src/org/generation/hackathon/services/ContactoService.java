package org.generation.hackathon.services;

import org.generation.hackathon.models.Contacto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactoService {
    private Map<Integer, Contacto> agenda = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void añadirContacto(Contacto contacto){
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
        String tel = sc.nextLine();

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

    public boolean agendaLlena(){
        return agenda.size() > 10;
    }

    public String espaciosLibres(){

        if(agenda.size() <= 10){
            return "Espacios disponibles: "+ (10 - agenda.size())+" espacios";
        }else {
            return "Ya no hay espacio caaarrrrrrrrrrrrrrrnal :v";
        }
    }
    public void listarContactos(List<Contacto> agenda) {
        if (agenda == null || agenda.isEmpty()) {
            System.out.println("La agenda está vacia... ");
            return;
        }

        // Creando una copia para no alterar la lista original si no se especifica
        List<Contacto> listaOrdenada = new ArrayList<>(agenda);

        // Ordenando alfabéticamente por Nombre y luego por Apellido.
        listaOrdenada.sort(Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER));

        // Mostrando los contactos con el formato de nombre + apellido + telefono
        System.out.println("\n--- CONTACTOS ---");
        for (Contacto c : listaOrdenada) {
            System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
        }
    }
}
package org.generation.hackathon.services;

import java.util.*;

import org.generation.hackathon.models.Contacto;

public class ContactoService {

    private List<Contacto> contactos = new ArrayList<>();
    private int cantidadMax;

    public ContactoService() {
        this.cantidadMax = 10;
    }

    public ContactoService(int cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    // Añadir contacto
    public void anadirContacto(Contacto contacto) {
        if (contacto.getNombre().isBlank() || contacto.getApellido().isBlank()) {
            System.out.println("Error: No se pueden ingresar campos vacíos.");
            return;
        }

        if (agendaLlena()) {
            System.out.println("La lista esta llena ya no puede ingresar mas datos");
            return;
        }
        if (contactos.contains(contacto)) {
            System.out.println("ADVERTENCIA: El contacto '" + contacto.getNombre() + " " + contacto.getApellido()
                    + "' ya existe en la agenda.");
        }
        contactos.add(contacto);
        System.out.println("Contacto añadido: " + contacto.getNombre() + " " + contacto.getApellido());
    }

    // Listar contactos
    public List<Contacto> listarContactos() {
        if (contactos == null || contactos.isEmpty()) {
            return new ArrayList<>(); // Retorna una lista vacía si no hay contactos
        }

        // Creando una copia para no alterar la lista original si no se especifica
        List<Contacto> listaOrdenada = new ArrayList<>(contactos);

        // Ordenando alfabéticamente por Nombre y luego por Apellido.
        listaOrdenada.sort(Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER));

        return listaOrdenada;
    }

    // Opcional: Método para imprimir (si aún necesitas la funcionalidad de
    // impresión)
    public void imprimirContactos() {
        List<Contacto> contactosOrdenados = listarContactos();
        if (contactosOrdenados.isEmpty()) {
            System.out.println("La agenda está vacía...");
            return;
        }

        System.out.println("\n--- CONTACTOS ---");
        for (Contacto c : contactosOrdenados) {
            System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
        }
    }

    // Existe comtacto
    private boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    // Eliminar un contacto por nombre y apellido
    public void eliminarContacto(String nombre, String apellido) {
        Contacto contacto = new Contacto(nombre, apellido, "");
        if (contactos.remove(contacto)) {
            System.out.println("Contacto eliminado: " + contacto.getNombre() + " " + contacto.getApellido());
        } else {
            System.out.println("Contacto no encontrado: " + contacto.getNombre() + " " + contacto.getApellido());
        }
    }

    // Modificar un telefono por nombre y apellido
    public void modificarTelefono(String nombre, String apellido, String nuevo) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevo);
                System.out.println("Telefono modificado: " +
                        c.getNombre() + " " +
                        c.getApellido() + " " +
                        c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado: " + nombre + " " + apellido);
    }

    // Agenda llena
    public boolean agendaLlena() {
        return contactos.size() >= cantidadMax;
    }

    // Espacios libres
    public int espaciosLibres() {
        return cantidadMax - contactos.size();
    }

}
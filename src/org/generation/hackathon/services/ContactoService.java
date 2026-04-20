package org.generation.hackathon.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactoService {

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

package org.generation.hackathon.main;
import org.generation.hackathon.models.Contacto;
import org.generation.hackathon.services.ContactoService;

public class ContactoMain {
    public static void main(String[] args) {
        Contacto contactos = new Contacto();
        ContactoService contactoService = new ContactoService();

        System.out.println(contactos.getSuperContactos());
        System.out.println(contactoService.agendaLlena());
        System.out.println(contactoService.espaciosLibres());


    }
}

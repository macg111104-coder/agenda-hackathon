package org.generation.hackathon.main;

import org.generation.hackathon.models.Contacto;
import org.generation.hackathon.services.ContactoService;
import java.util.Scanner;

public class ContactoMain {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ContactoService servicio = new ContactoService();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n1.Añadir 2.Buscar 3.Eliminar 4.Listar 5.Modificar 6.Estado 7.Espacios libres 8.Salir");
            System.out.print("Opción: ");
            String opc = sn.nextLine();

            switch (opc) {
                case "1":
                    System.out.print("Nombre: ");
                    String nombre = sn.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sn.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sn.nextLine();
                    servicio.anadirContacto(new Contacto(nombre, apellido, telefono));
                    break;

                case "2":
                    // Opción de buscar
                    System.out.print("Nombre del contacto: ");
                    nombre = sn.nextLine();
                    System.out.print("Apellido del contacto: ");
                    apellido = sn.nextLine();
                    servicio.buscarContacto(nombre, apellido);
                    break;

                case "3":
                    System.out.println("nombre del contacto: ");
                    nombre = sn.nextLine();
                    System.out.println("apellido del contacto: ");
                    apellido = sn.nextLine();
                    servicio.eliminarContacto(nombre, apellido);
                    break;

                case "4":
                    servicio.imprimirContactos();
                    break;

                case "5":
                    System.out.print("Nombre del contacto: ");
                    nombre = sn.nextLine();
                    System.out.print("Apellido del contacto: ");
                    apellido = sn.nextLine();
                    System.out.print("Nuevo Teléfono: ");
                    telefono = sn.nextLine();
                    servicio.modificarTelefono(nombre, apellido, telefono);
                    break;

                case "6":
                    // Mostrar si está llena o no
                    if (servicio.agendaLlena()) {
                        System.out.println("La agenda ESTÁ LLENA");
                    } else {
                        System.out.println("La agenda NO está llena");
                    }
                    break;

                case "7":
                    System.out.println("Espacios libres: " + servicio.espaciosLibres());
                    break;
                case "8":
                    System.out.println("Saliendo... ");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sn.close();
    }
}

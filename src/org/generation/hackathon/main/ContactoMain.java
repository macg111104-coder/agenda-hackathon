package org.generation.hackathon.main;

import java.util.Scanner;

import org.generation.hackathon.models.Contacto;
import org.generation.hackathon.services.ContactoService;

public class ContactoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactoService service = new ContactoService();

        int opcion;
        do {
            System.out.println("--- Menú de Agenda ---");
            System.out.println("1. Eliminar contacto");
            System.out.println("2. Modificar contacto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el apellido del contacto a eliminar: ");
                    String apellido = sc.nextLine();
                    service.eliminarContacto(new Contacto(nombre, apellido, 0));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del contacto a modificar: ");
                    String nombreModificar = sc.nextLine();
                    System.out.print("Ingrese el apellido del contacto a modificar: ");
                    String apellidoModificar = sc.nextLine();
                    System.out.print("Ingrese el nuevo número de teléfono: ");
                    int nuevoTelefono = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea
                    service.modificarContacto(nombreModificar, apellidoModificar, nuevoTelefono);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

    }
}

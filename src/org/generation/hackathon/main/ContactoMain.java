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
                    System.out.print("Nombre: "); String n1 = sn.nextLine();
                    System.out.print("Apellido: "); String a1 = sn.nextLine();
                    System.out.print("Teléfono: "); String t1 = sn.nextLine();
                    servicio.anadirContacto(new Contacto(n1, a1, t1));
                    break;

                case "2":
                    System.out.println("Buscar contacto:");
                    break;

                case "3":
                    System.out.println("nombre del contacto: "); 
                    String nombre = sn.nextLine();
                    System.out.println("apellido del contacto: "); 
                    String apellido = sn.nextLine();
                    servicio.eliminarContacto(nombre, apellido);
                    break;

                case "4":
                    servicio.imprimirContactos();
                    break;

                case "5":
                    System.out.print("Nombre del contacto: "); String n5 = sn.nextLine();
                    System.out.print("Apellido del contacto: "); String a5 = sn.nextLine();
                    System.out.print("Nuevo Teléfono: "); String nt = sn.nextLine();
                    servicio.modificarTelefono(n5, a5, nt);
                    break;

                case "6":
                    servicio.agendaLlena();
                    break;

                case "7":
                    servicio.espaciosLibres();
                    break;

                case "8":
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sn.close();
    }
}

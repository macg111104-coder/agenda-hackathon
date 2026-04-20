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
                    servicio.añadirContacto(new Contacto(n1, a1, t1));
                    break;

                case "2":
//                    System.out.print("Nombre a buscar: "); String n2 = sn.nextLine();
//                    System.out.print("Apellido a buscar: "); String a2 = sn.nextLine();
                    //servicio.buscarContacto(n2, a2);
                    break;

                case "3":
//                    System.out.print("Nombre a eliminar: "); String n3 = sn.nextLine();
//                    System.out.print("Apellido a eliminar: "); String a3 = sn.nextLine();
//                    //servicio.eliminarContacto(new Contacto(n3, a3));
                    break;

                case "4":
                    //servicio.listarContactos();
                    break;

                case "5":
//                    System.out.print("Nombre del contacto: "); String n5 = sn.nextLine();
//                    System.out.print("Apellido del contacto: "); String a5 = sn.nextLine();
//                    System.out.print("Nuevo Teléfono: "); String nt = sn.nextLine();
//                    //servicio.modificarTelefono(n5, a5, nt);
                    break;

                case "6":
                    if (servicio.agendaLlena()){
                        System.out.println("Agenda llena pa");
                    }else {
                        System.out.println("Hay cupo, ¿cuantos?, checa la opción 7 pa");
                    }
                    break;

                case "7":
                    System.out.println(servicio.espaciosLibres());
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

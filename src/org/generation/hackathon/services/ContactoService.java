package org.generation.hackathon.services;

import org.generation.hackathon.models.Contacto;

public class ContactoService {

    public boolean agendaLlena(){
        Contacto contactos = new Contacto();

        return
    }

    public String espaciosLibres(){
        Contacto contactos = new Contacto();

        if(contactos.tamaño() <= 10){
            return "Espacios disponibles: "+ (10 - contactos.tamaño())+" espacios";
        }else {
            return "Ya no hay espacio caaarrrrrrrrrrrrrrrnal :v";
        }
    }


}

package org.generation.hackathon.models;

import java.util.HashMap;
import java.util.Map;

public class Contacto {

        public HashMap<String, Long> SuperContactos = new HashMap<>();

        public Contacto(){
            SuperContactos.put("Erick", 123456789L);
            SuperContactos.put("Eric",1234556767L);
        }

    public HashMap<String, Long> getSuperContactos() {
        return SuperContactos;
    }

    public int tamaño() {
            return SuperContactos.size();
    }

    public void setSuperContactos(HashMap<String, Long> superContactos) {
        SuperContactos = superContactos;
    }

}

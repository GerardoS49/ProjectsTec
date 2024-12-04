package com.centromedico.server;

import java.util.*;

public class Database {
    private Map<String, String> pacientes = new HashMap<>();

    public void agregarPaciente(String id, String datos) {
        pacientes.put(id, datos);
    }

    public String obtenerPaciente(String id) {
        return pacientes.get(id);
    }

    // Métodos adicionales para gestionar estudios y reportes
}

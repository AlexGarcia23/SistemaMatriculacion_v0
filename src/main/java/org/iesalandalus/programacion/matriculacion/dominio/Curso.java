package org.iesalandalus.programacion.matriculacion.dominio;

public enum Curso {
    PRIMERO("Primero"),
    SEGUNDO("Segundo");

    private final String cadenaAMostrar;

    // Constructor
    private Curso(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    // Método imprimir
    public String imprimir() {
        return String.format("%d.-%s", this.ordinal(), cadenaAMostrar);
    }

    // Método toString
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}


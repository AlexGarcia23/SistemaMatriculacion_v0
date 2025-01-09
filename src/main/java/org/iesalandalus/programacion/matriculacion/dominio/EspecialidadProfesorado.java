package org.iesalandalus.programacion.matriculacion.dominio;

public enum EspecialidadProfesorado {
    INFORMATICA("INFORMATICA"),
    SISTEMAS("SISTEMAS"),
    FOL("FOL");

    private final String cadenaAMostrar;

    // Constructor
    private EspecialidadProfesorado(String cadenaAMostrar) {
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

package org.iesalandalus.programacion.matriculacion.dominio;

public enum Grado {
    GDCFGB("GDCFGB"),
    GDCFGM("GDCFGM"),
    GDCFGS("GDCFGS");

    private final String cadenaAMostrar;

    // Constructor
    private Grado(String cadenaAMostrar) {
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


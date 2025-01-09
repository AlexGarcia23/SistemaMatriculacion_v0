package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Asignaturas {
    private Asignatura[] coleccionAsignaturas;
    private int tamano;
    private int capacidad;

    // Constructor con capacidad
    public Asignaturas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.coleccionAsignaturas = new Asignatura[capacidad];
        this.tamano = 0;
    }

    // Método getCapacidad
    public int getCapacidad() {
        return capacidad;
    }

    // Método getTamano
    public int getTamano() {
        return tamano;
    }

    // Método get: devuelve una copia profunda de la colección
    public Asignatura[] get() {
        Asignatura[] copia = new Asignatura[tamano];
        for (int i = 0; i < tamano; i++) {
            copia[i] = new Asignatura(coleccionAsignaturas[i]); // Copia profunda usando el constructor copia
        }
        return copia;
    }

    // Método insertar
    public void insertar(Asignatura asignatura) throws OperationNotSupportedException {
        if (asignatura == null) {
            throw new NullPointerException("ERROR: No se puede insertar una asignatura nula.");
        }
        if (tamano >= capacidad) {
            throw new OperationNotSupportedException("ERROR: No se aceptan más asignaturas.");
        }
        if (buscar(asignatura) != null) {
            throw new OperationNotSupportedException("ERROR: Ya existe una asignatura con ese código.");
        }
        coleccionAsignaturas[tamano] = new Asignatura(asignatura); // Copia profunda al insertar
        tamano++;
    }

    // Método buscar
    public Asignatura buscar(Asignatura asignatura) {
        if (asignatura == null) {
            return null;
        }
        for (int i = 0; i < tamano; i++) {
            if (coleccionAsignaturas[i].equals(asignatura)) {
                return coleccionAsignaturas[i];
            }
        }
        return null;
    }

    // Método borrar
    public void borrar(Asignatura asignatura) throws OperationNotSupportedException {
        if (asignatura == null) {
            throw new NullPointerException("ERROR: No se puede borrar una asignatura nula.");
        }
        int indice = indiceAsignatura(asignatura);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna asignatura como la indicada.");
        }
        desplazarIzquierda(indice);
        tamano--;
    }

    // Método auxiliar: encuentra el índice de una asignatura
    private int indiceAsignatura(Asignatura asignatura) {
        for (int i = 0; i < tamano; i++) {
            if (coleccionAsignaturas[i].equals(asignatura)) {
                return i;
            }
        }
        return -1;
    }

    // Método auxiliar: desplaza los elementos hacia la izquierda para compactar el array
    private void desplazarIzquierda(int indice) {
        for (int i = indice; i < tamano - 1; i++) {
            coleccionAsignaturas[i] = coleccionAsignaturas[i + 1];
        }
        coleccionAsignaturas[tamano - 1] = null;
    }
}

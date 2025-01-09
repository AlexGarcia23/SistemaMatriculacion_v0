package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Alumnos {

    private List<Alumno> coleccionAlumnos;
    private int capacidad;

    // Constructor con capacidad
    public Alumnos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        coleccionAlumnos = new ArrayList<>(capacidad);
    }

    // Método getCapacidad
    public int getCapacidad() {
        return capacidad;
    }

    // Método getTamano
    public int getTamano() {
        return coleccionAlumnos.size();
    }

    // Método get (copia profunda)
    public Alumno[] get() {
        return copiaProfundaAlumnos();
    }

    private Alumno[] copiaProfundaAlumnos() {
        Alumno[] copia = new Alumno[coleccionAlumnos.size()];
        for (int i = 0; i < coleccionAlumnos.size(); i++) {
            copia[i] = new Alumno(coleccionAlumnos.get(i));
        }
        return copia;
    }

    // Método insertar
    public void insertar(Alumno alumno) throws OperationNotSupportedException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: No se puede insertar un alumno nulo.");
        }
        if (coleccionAlumnos.contains(alumno)) {
            throw new OperationNotSupportedException("ERROR: Ya existe un alumno con ese dni.");
        }
        if (coleccionAlumnos.size() >= capacidad) {
            throw new OperationNotSupportedException("ERROR: No se aceptan más alumnos.");
        }
        coleccionAlumnos.add(alumno);
    }

    // Método buscar
    public Alumno buscar(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        int index = coleccionAlumnos.indexOf(alumno);
        return index != -1 ? new Alumno(coleccionAlumnos.get(index)) : null;
    }

    // Método borrar
    public void borrar(Alumno alumno) throws OperationNotSupportedException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: No se puede borrar un alumno nulo.");
        }
        if (!coleccionAlumnos.remove(alumno)) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
        }
    }
}

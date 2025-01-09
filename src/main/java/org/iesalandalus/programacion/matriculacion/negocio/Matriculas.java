package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Matriculas {
    private Matricula[] coleccionMatriculas;
    private int tamano;
    private int capacidad;

    public Matriculas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        coleccionMatriculas = new Matricula[capacidad];
        tamano = 0;
    }

    public Matricula[] get() {
        Matricula[] copia = new Matricula[tamano];
        for (int i = 0; i < tamano; i++) {
            copia[i] = new Matricula(coleccionMatriculas[i]); // Copia profunda
        }
        return copia;
    }

    public void insertar(Matricula matricula) throws OperationNotSupportedException {
        if (matricula == null) {
            throw new NullPointerException("ERROR: No se puede insertar una matrícula nula.");
        }
        if (tamano >= capacidad) {
            throw new OperationNotSupportedException("ERROR: No se aceptan más matrículas.");
        }
        if (buscar(matricula) != null) {
            throw new OperationNotSupportedException("ERROR: Ya existe una matrícula con ese identificador.");
        }
        coleccionMatriculas[tamano] = new Matricula(matricula); // Copia profunda
        tamano++;
    }

    public Matricula buscar(Matricula matricula) {
        if (matricula == null) {
            return null;
        }
        for (int i = 0; i < tamano; i++) {
            if (coleccionMatriculas[i].equals(matricula)) {
                return new Matricula(coleccionMatriculas[i]); // Copia profunda
            }
        }
        return null;
    }

    public void borrar(Matricula matricula) throws OperationNotSupportedException {
        if (matricula == null) {
            throw new NullPointerException("ERROR: No se puede borrar una matrícula nula.");
        }
        int indice = buscarIndice(matricula);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna matrícula como la indicada.");
        }
        desplazarIzquierda(indice);
        tamano--;
    }

    private int buscarIndice(Matricula matricula) {
        for (int i = 0; i < tamano; i++) {
            if (coleccionMatriculas[i].equals(matricula)) {
                return i;
            }
        }
        return -1;
    }

    private void desplazarIzquierda(int indice) {
        for (int i = indice; i < tamano - 1; i++) {
            coleccionMatriculas[i] = coleccionMatriculas[i + 1];
        }
        coleccionMatriculas[tamano - 1] = null;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Matricula[] get(Alumno alumno) {
        if (alumno == null) {
            throw new NullPointerException("ERROR: El alumno no puede ser nulo.");
        }
        List<Matricula> listaMatriculas = new ArrayList<>();
        for (int i = 0; i < tamano; i++) {
            if (coleccionMatriculas[i].getAlumno().equals(alumno)) {
                listaMatriculas.add(new Matricula(coleccionMatriculas[i])); // Copia profunda
            }
        }
        return listaMatriculas.toArray(new Matricula[0]);
    }

    public Matricula[] get(String cursoAcademico) {
        if (cursoAcademico == null || cursoAcademico.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: El curso académico no puede ser nulo o vacío.");
        }
        List<Matricula> listaMatriculas = new ArrayList<>();
        for (int i = 0; i < tamano; i++) {
            if (coleccionMatriculas[i].getCursoAcademico().equals(cursoAcademico)) {
                listaMatriculas.add(new Matricula(coleccionMatriculas[i])); // Copia profunda
            }
        }
        return listaMatriculas.toArray(new Matricula[0]);
    }

    public Matricula[] get(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            throw new NullPointerException("ERROR: El ciclo formativo no puede ser nulo.");
        }
        List<Matricula> listaMatriculas = new ArrayList<>();
        for (int i = 0; i < tamano; i++) {
            if (tieneCicloFormativo(coleccionMatriculas[i], cicloFormativo)) {
                listaMatriculas.add(new Matricula(coleccionMatriculas[i])); // Copia profunda
            }
        }
        return listaMatriculas.toArray(new Matricula[0]);
    }

    private boolean tieneCicloFormativo(Matricula matricula, CicloFormativo cicloFormativo) {
        for (Asignatura asignatura : matricula.getColeccionAsignaturas()) {
            if (asignatura.getCicloFormativo().equals(cicloFormativo)) {
                return true;
            }
        }
        return false;
    }
}





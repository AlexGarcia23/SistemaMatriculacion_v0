package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.dominio.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Consola {

    private Consola() {
        // Constructor privado para evitar instanciación
    }

    public static void mostrarMenu() {
        System.out.println("Opciones del menú:");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    public static Opcion elegirOpcion() {
        Opcion opcionElegida = null;
        do {
            try {
                System.out.print("Elige una opción: ");
                int ordinal = Entrada.entero();
                opcionElegida = Opcion.values()[ordinal];
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println("ERROR: Opción no válida. Intenta de nuevo.");
            }
        } while (opcionElegida == null);
        return opcionElegida;
    }

    public static Alumno leerAlumno() {
        try {
            System.out.print("Introduce el nombre del alumno: ");
            String nombre = Entrada.cadena();
            System.out.print("Introduce el DNI del alumno: ");
            String dni = Entrada.cadena();
            System.out.print("Introduce el correo del alumno: ");
            String correo = Entrada.cadena();
            System.out.print("Introduce el teléfono del alumno: ");
            String telefono = Entrada.cadena();
            System.out.print("Introduce la fecha de nacimiento (formato: yyyy-MM-dd): ");
            LocalDate fechaNacimiento = leerFecha();
            return new Alumno(nombre, dni, correo, telefono, fechaNacimiento);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: Los datos introducidos para el alumno no son válidos.", e);
        }
    }

    public static Alumno getAlumnoPorDni() {
        try {
            System.out.print("Introduce el DNI del alumno: ");
            String dni = Entrada.cadena();
            return new Alumno("Alumno Ficticio", dni, "correo@ficticio.com", "600000000", LocalDate.of(2000, 1, 1));
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: No se puede crear un alumno con los datos proporcionados.", e);
        }
    }

    public static LocalDate leerFecha() {
        LocalDate fecha = null;
        do {
            try {
                System.out.print("Introduce la fecha (formato: yyyy-MM-dd): ");
                String entradaFecha = Entrada.cadena();
                fecha = LocalDate.parse(entradaFecha, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("ERROR: Formato de fecha no válido. Intenta de nuevo.");
            }
        } while (fecha == null);
        return fecha;
    }

    public static Grado leerGrado() {
        System.out.println("Grados disponibles:");
        for (Grado grado : Grado.values()) {
            System.out.println("- " + grado);
        }
        Grado gradoElegido = null;
        do {
            try {
                System.out.print("Elige un grado: ");
                String gradoStr = Entrada.cadena();
                gradoElegido = Grado.valueOf(gradoStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: Grado no válido. Intenta de nuevo.");
            }
        } while (gradoElegido == null);
        return gradoElegido;
    }

    public static CicloFormativo leerCicloFormativo() {
        try {
            System.out.print("Introduce el código del ciclo formativo: ");
            int codigo = Entrada.entero();
            System.out.print("Introduce el nombre del ciclo formativo: ");
            String nombre = Entrada.cadena();
            System.out.print("Introduce la familia profesional: ");
            String familia = Entrada.cadena();
            Grado grado = leerGrado();
            System.out.print("Introduce el número de horas: ");
            int horas = Entrada.entero();
            return new CicloFormativo(codigo, familia, grado, nombre, horas);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: Los datos introducidos para el ciclo formativo no son válidos.", e);
        }
    }

    public static void mostrarCiclosFormativos(CicloFormativo[] ciclos) {
        if (ciclos == null || ciclos.length == 0) {
            System.out.println("No hay ciclos formativos registrados.");
            return;
        }
        System.out.println("Ciclos formativos registrados:");
        for (CicloFormativo ciclo : ciclos) {
            if (ciclo != null) {
                System.out.println(ciclo);
            }
        }
    }

    public static CicloFormativo getCicloFormativoPorCodigo() {
        try {
            System.out.print("Introduce el código del ciclo formativo: ");
            int codigo = Entrada.entero();
            return new CicloFormativo(codigo, "Ficticio", Grado.GDCFGS, "Ficticio", 2000);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: No se puede crear un ciclo formativo con los datos proporcionados.", e);
        }
    }

    public static Curso leerCurso() {
        System.out.println("Cursos disponibles:");
        for (Curso curso : Curso.values()) {
            System.out.println("- " + curso);
        }
        Curso cursoElegido = null;
        do {
            try {
                System.out.print("Elige un curso: ");
                String cursoStr = Entrada.cadena();
                cursoElegido = Curso.valueOf(cursoStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: Curso no válido. Intenta de nuevo.");
            }
        } while (cursoElegido == null);
        return cursoElegido;
    }

    public static EspecialidadProfesorado leerEspecialidadProfesorado() {
        System.out.println("Especialidades disponibles:");
        for (EspecialidadProfesorado especialidad : EspecialidadProfesorado.values()) {
            System.out.println("- " + especialidad);
        }
        EspecialidadProfesorado especialidadElegida = null;
        do {
            try {
                System.out.print("Elige una especialidad: ");
                String especialidadStr = Entrada.cadena();
                especialidadElegida = EspecialidadProfesorado.valueOf(especialidadStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: Especialidad no válida. Intenta de nuevo.");
            }
        } while (especialidadElegida == null);
        return especialidadElegida;
    }

    public static Asignatura leerAsignatura() {
        try {
            System.out.print("Introduce el código de la asignatura: ");
            String codigo = Entrada.cadena();
            System.out.print("Introduce el nombre de la asignatura: ");
            String nombre = Entrada.cadena();
            System.out.print("Introduce las horas anuales: ");
            int horas = Entrada.entero();
            Curso curso = leerCurso();
            System.out.print("Introduce las horas de desdoble: ");
            int horasDesdoble = Entrada.entero();
            EspecialidadProfesorado especialidad = leerEspecialidadProfesorado();
            CicloFormativo ciclo = leerCicloFormativo();
            return new Asignatura(codigo, nombre, horas, curso, horasDesdoble, especialidad, ciclo);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: Los datos introducidos para la asignatura no son válidos.", e);
        }
    }

    public static boolean asignaturaYaMatriculada(Asignatura[] asignaturas, Asignatura asignatura) {
        if (asignaturas == null || asignatura == null) {
            throw new IllegalArgumentException("ERROR: Las asignaturas o la asignatura pasada no pueden ser nulas.");
        }
        for (Asignatura a : asignaturas) {
            if (a != null && a.equals(asignatura)) {
                return true;
            }
        }
        return false;
    }

    public static Matricula leerMatricula() {
        try {
            System.out.print("Introduce el identificador de la matrícula: ");
            int id = Entrada.entero();
            System.out.print("Introduce el curso académico (e.g., 24-25): ");
            String cursoAcademico = Entrada.cadena();
            System.out.print("Introduce la fecha de matriculación (formato: yyyy-MM-dd): ");
            LocalDate fechaMatriculacion = leerFecha();
            Alumno alumno = leerAlumno();

            List<Asignatura> asignaturasMatriculadas = new ArrayList<>();
            char continuar;
            do {
                Asignatura asignatura = leerAsignatura();
                if (asignaturaYaMatriculada(asignaturasMatriculadas.toArray(new Asignatura[0]), asignatura)) {
                    System.out.println("La asignatura ya está matriculada. No se puede añadir.");
                } else {
                    asignaturasMatriculadas.add(asignatura);
                }
                System.out.print("¿Deseas añadir otra asignatura? (s/n): ");
                continuar = Entrada.caracter();
            } while (continuar == 's' || continuar == 'S');

            return new Matricula(id, cursoAcademico, fechaMatriculacion, alumno, asignaturasMatriculadas.toArray(new Asignatura[0]));
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: Datos introducidos incorrectos para la matrícula.", e);
        }
    }

    public static Asignatura getAsignaturaPorCodigo() {
        try {
            System.out.print("Introduce el código de la asignatura: ");
            String codigo = Entrada.cadena();
            return new Asignatura(codigo, "Asignatura Ficticia", 100, Curso.PRIMERO, 0,
                    EspecialidadProfesorado.INFORMATICA,
                    new CicloFormativo(1234, "Familia Ficticia", Grado.GDCFGS, "Ciclo Ficticio", 2000));
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: No se puede crear una asignatura con los datos proporcionados.", e);
        }
    }

    public static Matricula getMatriculaPorIdentificador() {
        try {
            System.out.print("Introduce el identificador de la matrícula: ");
            int id = Entrada.entero();

            Alumno alumnoFicticio = new Alumno("Nombre ficticio", "12345678A", "correo@ficticio.com", "600000000", LocalDate.of(2000, 1, 1));
            CicloFormativo cicloFormativoFicticio = new CicloFormativo(1000, "Ficticio", Grado.GDCFGS, "Ficticio", 2000);
            Asignatura asignaturaFicticia = new Asignatura("100", "Ficticia", 120, Curso.PRIMERO, 0, EspecialidadProfesorado.INFORMATICA, cicloFormativoFicticio);

            return new Matricula(id, "24-25", LocalDate.now(), alumnoFicticio, new Asignatura[]{asignaturaFicticia});
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: No se puede crear una matrícula con los datos proporcionados.", e);
        }
    }

}



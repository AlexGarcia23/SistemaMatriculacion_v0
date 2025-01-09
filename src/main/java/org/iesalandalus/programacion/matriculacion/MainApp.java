package org.iesalandalus.programacion.matriculacion;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;
import org.iesalandalus.programacion.matriculacion.negocio.Alumnos;
import org.iesalandalus.programacion.matriculacion.negocio.Asignaturas;
import org.iesalandalus.programacion.matriculacion.negocio.CiclosFormativos;
import org.iesalandalus.programacion.matriculacion.negocio.Matriculas;
import org.iesalandalus.programacion.matriculacion.vista.Consola;
import org.iesalandalus.programacion.matriculacion.vista.Opcion;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static final int CAPACIDAD = 3; // Puedes ajustar esta capacidad según tus necesidades.

    private static Alumnos alumnos = new Alumnos(CAPACIDAD);
    private static Asignaturas asignaturas = new Asignaturas(CAPACIDAD);
    private static CiclosFormativos ciclosFormativos = new CiclosFormativos(CAPACIDAD);
    private static Matriculas matriculas = new Matriculas(CAPACIDAD);

    // Ejecutar opción
    private static void ejecutarOpcion(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_ALUMNO -> insertarAlumno();
            case BUSCAR_ALUMNO -> buscarAlumno();
            case BORRAR_ALUMNO -> borrarAlumno();
            case MOSTRAR_ALUMNOS -> mostrarAlumnos();
            case INSERTAR_ASIGNATURA -> insertarAsignatura();
            case BUSCAR_ASIGNATURA -> buscarAsignatura();
            case BORRAR_ASIGNATURA -> borrarAsignatura();
            case MOSTRAR_ASIGNATURAS -> mostrarAsignaturas();
            case INSERTAR_CICLO_FORMATIVO -> insertarCicloFormativo();
            case BUSCAR_CICLO_FORMATIVO -> buscarCicloFormativo();
            case BORRAR_CICLO_FORMATIVO -> borrarCicloFormativo();
            case MOSTRAR_CICLOS_FORMATIVOS -> mostrarCiclosFormativos();
            case INSERTAR_MATRICULA -> insertarMatricula();
            case BUSCAR_MATRICULA -> buscarMatricula();
            case ANULAR_MATRICULA -> anularMatricula();
            case MOSTRAR_MATRICULAS -> mostrarMatriculas();
            case MOSTRAR_MATRICULAS_POR_ALUMNO -> mostrarMatriculasPorAlumno();
            case MOSTRAR_MATRICULAS_POR_CICLO_FORMATIVO -> mostrarMatriculasPorCicloFormativo();
            case MOSTRAR_MATRICULAS_POR_CURSO_ACADEMICO -> mostrarMatriculasPorCursoAcademico();
            case SALIR -> System.out.println("¡Gracias por usar la aplicación!");
        }
    }

    // Métodos para alumnos
    private static void insertarAlumno() {
        try {
            Alumno alumno = Consola.leerAlumno();
            alumnos.insertar(alumno);
            System.out.println("Alumno insertado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            Alumno encontrado = alumnos.buscar(alumno);
            System.out.println((encontrado != null) ? encontrado : "Alumno no encontrado.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            alumnos.borrar(alumno);
            System.out.println("Alumno borrado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarAlumnos() {
        Alumno[] listaAlumnos = alumnos.get();
        if (listaAlumnos.length > 0) {
            for (Alumno alumno : listaAlumnos) {
                System.out.println(alumno);
            }
        } else {
            System.out.println("No hay alumnos registrados.");
        }
    }

    // Métodos para asignaturas
    private static void insertarAsignatura() {
        try {
            Asignatura asignatura = Consola.leerAsignatura();
            asignaturas.insertar(asignatura);
            System.out.println("Asignatura insertada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            Asignatura encontrada = asignaturas.buscar(asignatura);
            System.out.println((encontrada != null) ? encontrada : "Asignatura no encontrada.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            asignaturas.borrar(asignatura);
            System.out.println("Asignatura borrada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarAsignaturas() {
        Asignatura[] listaAsignaturas = asignaturas.get();
        if (listaAsignaturas.length > 0) {
            for (Asignatura asignatura : listaAsignaturas) {
                System.out.println(asignatura);
            }
        } else {
            System.out.println("No hay asignaturas registradas.");
        }
    }

    // Métodos para ciclos formativos
    private static void insertarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.leerCicloFormativo();
            ciclosFormativos.insertar(ciclo);
            System.out.println("Ciclo formativo insertado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            CicloFormativo encontrado = ciclosFormativos.buscar(ciclo);
            System.out.println((encontrado != null) ? encontrado : "Ciclo formativo no encontrado.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            ciclosFormativos.borrar(ciclo);
            System.out.println("Ciclo formativo borrado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarCiclosFormativos() {
        CicloFormativo[] listaCiclos = ciclosFormativos.get();
        if (listaCiclos.length > 0) {
            for (CicloFormativo ciclo : listaCiclos) {
                System.out.println(ciclo);
            }
        } else {
            System.out.println("No hay ciclos formativos registrados.");
        }
    }

    // Métodos para matrículas
    private static void insertarMatricula() {
        try {
            Matricula matricula = Consola.leerMatricula();
            matriculas.insertar(matricula);
            System.out.println("Matrícula insertada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarMatricula() {
        try {
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            Matricula encontrada = matriculas.buscar(matricula);
            System.out.println((encontrada != null) ? encontrada : "Matrícula no encontrada.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void anularMatricula() {
        if (matriculas.getTamano() == 0) {
            System.out.println("No hay matrículas disponibles para anular.");
            return;
        }

        System.out.println("Listado de matrículas existentes:");
        Matricula[] listaMatriculas = matriculas.get();
        for (int i = 0; i < matriculas.getTamano(); i++) {
            System.out.println((i + 1) + ". " + listaMatriculas[i]);
        }

        try {
            System.out.print("Seleccione el número de la matrícula que desea anular: ");
            int opcion = Entrada.entero();

            if (opcion < 1 || opcion > matriculas.getTamano()) {
                System.out.println("ERROR: Opción no válida.");
                return;
            }

            Matricula matriculaSeleccionada = listaMatriculas[opcion - 1];
            if (matriculaSeleccionada == null) {
                System.out.println("ERROR: La matrícula seleccionada no existe.");
                return;
            }

            System.out.println("Introduce la fecha de anulación (formato yyyy-MM-dd): ");
            LocalDate fechaAnulacion = Consola.leerFecha();

            if (!puedeSerAnulada(matriculaSeleccionada)) {
                System.out.println("ERROR: La matrícula seleccionada no puede ser anulada.");
                return;
            }

            matriculaSeleccionada.setFechaAnulacion(fechaAnulacion);
            System.out.println("Matrícula anulada correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR: Ha ocurrido un problema al intentar anular la matrícula. " + e.getMessage());
        }
    }

    private static boolean puedeSerAnulada(Matricula matricula) {
        if (matricula == null) {
            throw new IllegalArgumentException("ERROR: La matrícula no puede ser nula.");
        }

        // Verificar si ya tiene una fecha de anulación
        if (matricula.getFechaAnulacion() != null) {
            System.out.println("ERROR: La matrícula ya está anulada.");
            return false;
        }

        // Validación adicional: comprobar que la matrícula no sea de un curso finalizado (opcional)
        LocalDate fechaActual = LocalDate.now();
        if (matricula.getFechaMatriculacion().isBefore(fechaActual.minusYears(1))) {
            System.out.println("ERROR: No se puede anular una matrícula de un curso finalizado.");
            return false;
        }

        return true;
    }

    private static void mostrarMatriculas() {
        Matricula[] listaMatriculas = matriculas.get();
        if (listaMatriculas.length > 0) {
            for (Matricula matricula : listaMatriculas) {
                System.out.println(matricula);
            }
        } else {
            System.out.println("No hay matrículas registradas.");
        }
    }

    private static void mostrarMatriculasPorAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            Matricula[] listaMatriculas = matriculas.get(alumno);
            if (listaMatriculas.length > 0) {
                for (Matricula matricula : listaMatriculas) {
                    System.out.println(matricula);
                }
            } else {
                System.out.println("No hay matrículas registradas para este alumno.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMatriculasPorCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            Matricula[] listaMatriculas = matriculas.get(ciclo);
            if (listaMatriculas.length > 0) {
                for (Matricula matricula : listaMatriculas) {
                    System.out.println(matricula);
                }
            } else {
                System.out.println("No hay matrículas registradas para este ciclo formativo.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMatriculasPorCursoAcademico() {
        System.out.print("Introduce el curso académico: ");
        String cursoAcademico = Entrada.cadena();
        Matricula[] listaMatriculas = matriculas.get(cursoAcademico);
        if (listaMatriculas.length > 0) {
            for (Matricula matricula : listaMatriculas) {
                System.out.println(matricula);
            }
        } else {
            System.out.println("No hay matrículas registradas para este curso académico.");
        }
    }

    // Método principal
    public static void main(String[] args) {
        Opcion opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != Opcion.SALIR);
    }
}


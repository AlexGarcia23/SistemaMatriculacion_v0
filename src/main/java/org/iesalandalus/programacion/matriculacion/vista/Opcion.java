package org.iesalandalus.programacion.matriculacion.vista;

public enum Opcion {
    // Instancias del enumerado
    INSERTAR_ALUMNO("Insertar un nuevo alumno"),
    BUSCAR_ALUMNO("Buscar un alumno"),
    BORRAR_ALUMNO("Borrar un alumno"),
    MOSTRAR_ALUMNOS("Mostrar alumnos"),
    LISTAR_ALUMNOS("Listar todos los alumnos"),
    INSERTAR_ASIGNATURA("Insertar una nueva asignatura"),
    BUSCAR_ASIGNATURA("Buscar una asignatura"),
    BORRAR_ASIGNATURA("Borrar una asignatura"),
    MOSTRAR_ASIGNATURAS("Mostrar asignaturas"),
    INSERTAR_CICLO_FORMATIVO("Insertar un nuevo ciclo formativo"),
    BUSCAR_CICLO_FORMATIVO("Buscar un ciclo formativo"),
    BORRAR_CICLO_FORMATIVO("Borrar un ciclo formativo"),
    MOSTRAR_CICLOS_FORMATIVOS("Mostrar ciclos formativos"),
    INSERTAR_MATRICULA("Insertar una nueva matricula"),
    BUSCAR_MATRICULA("Buscar una matricula"),
    ANULAR_MATRICULA("Anular una matricula"),
    MOSTRAR_MATRICULAS("Motrar matriculas"),
    MOSTRAR_MATRICULAS_POR_ALUMNO("Mostrar matriculas por alumno"),
    MOSTRAR_MATRICULAS_POR_CICLO_FORMATIVO("Mostrar matriculas por ciclo formativo"),
    MOSTRAR_MATRICULAS_POR_CURSO_ACADEMICO("Mostrar matriculas por curso academico"),
    LISTAR_ASIGNATURAS("Listar todas las asignaturas"),
    SALIR("Salir de la aplicación");

    // Atributo
    private final String mensaje;

    // Constructor
    private Opcion(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para obtener el mensaje de cada opción
    public String getMensaje() {
        return mensaje;
    }

    // Sobrescritura de toString
    @Override
    public String toString() {
        return String.format("%d .- %s", ordinal(), mensaje);
    }
}


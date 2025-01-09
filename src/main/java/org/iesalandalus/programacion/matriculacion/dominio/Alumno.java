package org.iesalandalus.programacion.matriculacion.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumno {

    // Constantes
    private static final String FORMATO_FECHA = "dd/MM/yyyy";
    private static final String REGEX_DNI = "^(\\d{8})([A-Z])$";
    private static final String REGEX_TELEFONO = "^\\d{9}$";
    private static final String REGEX_CORREO = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
    private static final int MIN_EDAD_ALUMNADO = 16;

    // Atributos
    private String nombre;
    private String dni;
    private String nia;
    private String telefono;
    private String correo;
    private LocalDate fechaNacimiento;

    // Constructor con parámetros
    public Alumno(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {
        setNombre(nombre);
        setDni(dni);
        setCorreo(correo);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
        generarNia();
    }

    // Constructor copia
    public Alumno(Alumno otro) {
        if (otro == null) {
            throw new NullPointerException("ERROR: No es posible copiar un alumno nulo.");
        }
        this.nombre = otro.nombre;
        this.dni = otro.dni;
        this.nia = otro.nia;
        this.telefono = otro.telefono;
        this.correo = otro.correo;
        this.fechaNacimiento = otro.fechaNacimiento;
    }

    // Métodos de acceso y modificación
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new NullPointerException("ERROR: El nombre de un alumno no puede ser nulo.");
        }
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: El nombre de un alumno no puede estar vacío.");
        }
        this.nombre = formateaNombre(nombre);
        generarNia();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni == null) {
            throw new NullPointerException("ERROR: El dni de un alumno no puede ser nulo.");
        }
        if (!dni.matches(REGEX_DNI)) {
            throw new IllegalArgumentException("ERROR: El dni del alumno no tiene un formato válido.");
        }
        if (!comprobarLetraDni(dni)) {
            throw new IllegalArgumentException("ERROR: La letra del dni del alumno no es correcta.");
        }
        this.dni = dni;
        generarNia();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null) {
            throw new NullPointerException("ERROR: El teléfono de un alumno no puede ser nulo.");
        }
        if (!telefono.matches(REGEX_TELEFONO)) {
            throw new IllegalArgumentException("ERROR: El teléfono del alumno no tiene un formato válido.");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null) {
            throw new NullPointerException("ERROR: El correo de un alumno no puede ser nulo.");
        }
        if (!correo.matches(REGEX_CORREO)) {
            throw new IllegalArgumentException("ERROR: El correo del alumno no tiene un formato válido.");
        }
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new NullPointerException("ERROR: La fecha de nacimiento de un alumno no puede ser nula.");
        }
        if (!esMayorDeEdad(fechaNacimiento)) {
            throw new IllegalArgumentException("ERROR: La edad del alumno debe ser mayor o igual a 16 años.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNia() {
        return nia;
    }

    private void generarNia() {
        if (nombre != null && dni != null) {
            String[] palabras = nombre.toLowerCase().split(" ");
            String iniciales = palabras[0].substring(0, 1);
            for (int i = 1; i < palabras.length; i++) {
                iniciales += palabras[i].substring(0, 1);
            }
            this.nia = nombre.toLowerCase().substring(0, 4) + dni.substring(5, 8);
        }
    }

    // Métodos adicionales
    private boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= MIN_EDAD_ALUMNADO;
    }

    private String formateaNombre(String nombre) {
        String[] palabras = nombre.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String palabra : palabras) {
            sb.append(palabra.substring(0, 1).toUpperCase()).append(palabra.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    private boolean comprobarLetraDni(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        Pattern pattern = Pattern.compile(REGEX_DNI);
        Matcher matcher = pattern.matcher(dni);
        if (matcher.matches()) {
            int numero = Integer.parseInt(matcher.group(1));
            char letra = matcher.group(2).charAt(0);
            return letras.charAt(numero % 23) == letra;
        }
        return false;
    }

    public String getIniciales() {
        String[] palabras = nombre.split(" ");
        StringBuilder iniciales = new StringBuilder();
        for (String palabra : palabras) {
            iniciales.append(palabra.charAt(0));
        }
        return iniciales.toString().toUpperCase();
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    // Métodos imprimir y toString
    public String imprimir() {
        return String.format("Número de Identificación del Alumnado (NIA)=%s " +
                        "nombre=%s (%s), DNI=%s, correo=%s, teléfono=%s, fecha nacimiento=%s",
                nia, nombre, getIniciales(), dni, correo, telefono,
                fechaNacimiento.format(DateTimeFormatter.ofPattern(FORMATO_FECHA)));
    }

    @Override
    public String toString() {
        return imprimir();
    }
}
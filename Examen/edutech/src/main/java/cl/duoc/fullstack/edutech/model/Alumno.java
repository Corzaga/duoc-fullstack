package cl.duoc.fullstack.edutech.model;

import jakarta.persistence.Entity;

@Entity
public class Alumno extends Usuario {

    private String asignatura;

    public Alumno() {
        this.asignatura = "";
    }

    public Alumno(String rut, String nombre, String apellido, String correo, String contrasena, String asignatura) {
        super(rut, nombre, apellido, correo, contrasena);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

}


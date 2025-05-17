package cl.duoc.fullstack.edutech.model;

import jakarta.persistence.Entity;

@Entity
public class Estudiante extends Usuario {

    private String asignatura;

    public Estudiante() {
        this.asignatura = "";
    }

    public Estudiante(String rut, String nombre, String apellido, String correo, String asignatura) {
        super(rut, nombre, apellido, correo);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

}


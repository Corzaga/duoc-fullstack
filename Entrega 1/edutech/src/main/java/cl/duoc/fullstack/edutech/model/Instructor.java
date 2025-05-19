package cl.duoc.fullstack.edutech.model;

import jakarta.persistence.Entity;

@Entity
public class Instructor extends Usuario {

    private String clase;

    public Instructor() {
        this.clase = "";
    }

    public Instructor(String rut, String nombre, String apellido, String correo, String contrasena, String clase) {
        super(rut, nombre, apellido, correo, contrasena);
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}

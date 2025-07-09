package cl.duoc.fullstack.edutech.model;

import jakarta.persistence.Entity;

@Entity
public class Gerente extends Usuario{

    public Gerente(){

    }

    public Gerente(String rut, String nombre, String apellido, String correo, String contrasena, String asignatura) {
        super(rut, nombre, apellido, correo, contrasena);
    }

}

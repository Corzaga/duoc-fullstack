package cl.duoc.fullstack.edutech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class IncidenciaCurso {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidenciaCurso;

    private String descripcion;
    private Boolean estadoIncidencia;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    @JsonBackReference
    private Curso curso;

    //constructores

    public IncidenciaCurso() {
    }

    public IncidenciaCurso(String descripcion, Boolean estadoIncidencia) {
        this.descripcion = descripcion;
        this.estadoIncidencia = estadoIncidencia;
    }

    //getters and setters

    public int getIdIncidenciaCurso() {
        return idIncidenciaCurso;
    }

    public void setIdIncidenciaCurso(int idIncidenciaCurso) {
        this.idIncidenciaCurso = idIncidenciaCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstadoIncidencia() {
        return estadoIncidencia;
    }

    public void setEstadoIncidencia(Boolean estadoIncidencia) {
        this.estadoIncidencia = estadoIncidencia;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
}

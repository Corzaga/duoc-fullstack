package cl.duoc.fullstack.edutech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ResenaCurso {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResenaCurso;

    private String nombreAlumno;
    private String descripcion;
    private int calificacion;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    @JsonBackReference
    private Curso curso;

    //constructores

    public ResenaCurso() {
        this.nombreAlumno = "";
        this.descripcion = "";
        this.calificacion = 1;
    }

    public ResenaCurso(String nombreAlumno, String descripcion, int calificacion) {
        this.nombreAlumno = nombreAlumno;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
    }

    //getters and setters

    public int getIdResenaCurso() {
        return idResenaCurso;
    }

    public void setIdResenaCurso(int idResenaCurso) {
        this.idResenaCurso = idResenaCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    
}
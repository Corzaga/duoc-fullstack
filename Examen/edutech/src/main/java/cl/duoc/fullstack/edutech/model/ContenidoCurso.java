package cl.duoc.fullstack.edutech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ContenidoCurso {
    
    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContenidoCurso;

    private String descripcion;
    private String unidad;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    @JsonBackReference
    private Curso curso;

    //constructores

    public ContenidoCurso() {
        this.descripcion = "";
        this.unidad = "";
    }

    public ContenidoCurso(String descripcion, String unidad) {
        this.descripcion = descripcion;
        this.unidad = unidad;
    }

    //getters and setters

    public int getIdContenidoCurso() {
        return idContenidoCurso;
    }

    public void setIdContenidoCurso(int idContenidoCurso) {
        this.idContenidoCurso = idContenidoCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
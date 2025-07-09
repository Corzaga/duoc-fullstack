package cl.duoc.fullstack.edutech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ForoCurso {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idForoCurso;

    private String pregunta;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    @JsonBackReference
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
    

    //constructores

    public ForoCurso() {
        this.pregunta = "";
    }

    public int getIdForoCurso() {
        return idForoCurso;
    }

    public void setIdForoCurso(int idForoCurso) {
        this.idForoCurso = idForoCurso;
    }

    public List<RespuestaForo> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaForo> respuestas) {
        this.respuestas = respuestas;
    }

    public ForoCurso(String pregunta) {
        this.pregunta = pregunta;
    }

    //getters and setters

    @OneToMany(mappedBy = "foro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespuestaForo> respuestas;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }



}

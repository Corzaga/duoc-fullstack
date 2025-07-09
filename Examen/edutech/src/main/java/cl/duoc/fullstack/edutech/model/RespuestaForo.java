package cl.duoc.fullstack.edutech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RespuestaForo {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuestaForo;
    
    private String respuesta;

    @ManyToOne
    @JoinColumn(name = "idForoRespuesta")
    @JsonBackReference
    private ForoCurso foro;
    
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    //constructores

    public RespuestaForo() {
        this.respuesta = "";
    }

    public RespuestaForo(String respuesta) {
        this.respuesta = respuesta;
    }

    //getters and setters

    public int getIdRespuestaForo() {
        return idRespuestaForo;
    }

    public void setIdRespuestaForo(int idRespuestaForo) {
        this.idRespuestaForo = idRespuestaForo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public ForoCurso getForo() {
        return foro;
    }

    public void setForo(ForoCurso foro) {
        this.foro = foro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
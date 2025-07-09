package cl.duoc.fullstack.edutech.dto;


public class ForoCursoDTO {
    private String pregunta;
    private String nombreSeccion;
    private String rutAlumno;


    public ForoCursoDTO(){
        this.rutAlumno="";
        this.nombreSeccion="";
        this.pregunta="";
    }


    public ForoCursoDTO(String pregunta, String nombreSeccion, String rutAlumno) {
        this.pregunta = pregunta;
        this.nombreSeccion = nombreSeccion;
        this.rutAlumno= rutAlumno;
    }


    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getNombreSeccion() {
        return nombreSeccion;
    }
    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }


    public String getRutAlumno() {
        return rutAlumno;
    }


    public void setRutAlumno(String rutAlumno) {
        this.rutAlumno = rutAlumno;
    }


 
}
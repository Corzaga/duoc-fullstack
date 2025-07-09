package cl.duoc.fullstack.edutech.dto;

public class RespuestaForoDTO {
    private String respuesta;
    private int idForoCurso;   // para asociar la respuesta a un foro
    private String rutAlumno;  

    

    public RespuestaForoDTO(String respuesta, int idForoCurso, String rutAlumno) {
        this.respuesta = respuesta;
        this.idForoCurso = idForoCurso;
        this.rutAlumno = rutAlumno;
    }
    
    public RespuestaForoDTO(){
        this.idForoCurso=0;
        this.respuesta="";
        this.rutAlumno="";
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getIdForoCurso() {
        return idForoCurso;
    }

    public void setIdForoCurso(int idForoCurso) {
        this.idForoCurso = idForoCurso;
    }

    public String getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(String rutAlumno) {
        this.rutAlumno = rutAlumno;
    }
}



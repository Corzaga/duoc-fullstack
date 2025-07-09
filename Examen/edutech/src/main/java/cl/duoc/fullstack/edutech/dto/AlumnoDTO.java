package cl.duoc.fullstack.edutech.dto;

public class AlumnoDTO {

    private String rut;
    private String seccionCurso;

    public AlumnoDTO(){
        this.rut="";
        this.seccionCurso="";
    }

    public AlumnoDTO(String rut, String seccionCurso) {
        this.rut = rut;
        this.seccionCurso = seccionCurso;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getSeccionCurso() {
        return seccionCurso;
    }

    public void setSeccionCurso(String seccionCurso) {
        this.seccionCurso = seccionCurso;
    }

    

  

    
}

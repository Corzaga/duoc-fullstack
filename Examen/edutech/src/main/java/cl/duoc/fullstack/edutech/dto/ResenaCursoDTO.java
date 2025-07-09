package cl.duoc.fullstack.edutech.dto;

public class ResenaCursoDTO {

    private String nombreAlumno;
    private String descripcion;
    private int calificacion;
    private String seccionCurso;

    public ResenaCursoDTO(){
        this.nombreAlumno="";
        this.descripcion="";
        this.seccionCurso="";
        this.calificacion=1;
    }

    public ResenaCursoDTO(String nombreAlumno, String descripcion, int calificacion, String seccionCurso) {
        this.nombreAlumno = nombreAlumno;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.seccionCurso = seccionCurso;
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

    public String getSeccionCurso() {
        return seccionCurso;
    }

    public void setSeccionCurso(String seccionCurso) {
        this.seccionCurso = seccionCurso;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    

}

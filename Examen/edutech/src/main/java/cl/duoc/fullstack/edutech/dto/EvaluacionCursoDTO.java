package cl.duoc.fullstack.edutech.dto;

public class EvaluacionCursoDTO {

    private String nombreEvaluacion;
    private String tipoEvaluacion;
    private String descripcion;
    private String instructor;
    private String seccionCurso;

    public EvaluacionCursoDTO(){
        this.nombreEvaluacion="";
        this.tipoEvaluacion="";
        this.descripcion="";
        this.instructor="";
        this.seccionCurso="";
    }

    public EvaluacionCursoDTO(String nombreEvaluacion, String tipoEvaluacion, String descripcion, String instructor,
            String seccionCurso) {
        this.nombreEvaluacion = nombreEvaluacion;
        this.tipoEvaluacion = tipoEvaluacion;
        this.descripcion = descripcion;
        this.instructor = instructor;
        this.seccionCurso = seccionCurso;
    }

    public String getNombreEvaluacion() {
        return nombreEvaluacion;
    }

    public void setNombreEvaluacion(String nombreEvaluacion) {
        this.nombreEvaluacion = nombreEvaluacion;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getseccionCurso() {
        return seccionCurso;
    }

    public void setseccionCurso(String seccionCurso) {
        this.seccionCurso = seccionCurso;
    }

    

}

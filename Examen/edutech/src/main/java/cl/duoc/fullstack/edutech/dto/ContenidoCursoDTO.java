package cl.duoc.fullstack.edutech.dto;

public class ContenidoCursoDTO {
    private String descripcion;
    private String unidad;
    private String seccionCurso;
    private String instructor;

    public ContenidoCursoDTO(){
        this.descripcion="";
        this.unidad="";
        this.seccionCurso="";
        this.instructor="";
    }

    public ContenidoCursoDTO(String descripcion, String unidad, String seccionCurso, String instructor) {
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.seccionCurso = seccionCurso;
        this.instructor = instructor;
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

    public String getSeccionCurso() {
        return seccionCurso;
    }

    public void setSeccionCurso(String seccionCurso) {
        this.seccionCurso = seccionCurso;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    
    
    

}


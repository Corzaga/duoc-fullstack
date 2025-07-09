package cl.duoc.fullstack.edutech.dto;

public class IncidenciaCursoDTO {

    private String descripcion;
    private Boolean estadoIncidencia;
    private String nombreSeccion; 

    public IncidenciaCursoDTO() {
        this.descripcion = "";
        this.estadoIncidencia = false;
        this.nombreSeccion = "";
    }
    

    public IncidenciaCursoDTO(String descripcion, Boolean estadoIncidencia, String nombreSeccion) {
        this.descripcion = descripcion;
        this.estadoIncidencia = estadoIncidencia;
        this.nombreSeccion = nombreSeccion;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstadoIncidencia() {
        return estadoIncidencia;
    }

    public void setEstadoIncidencia(Boolean estadoIncidencia) {
        this.estadoIncidencia = estadoIncidencia;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }
}

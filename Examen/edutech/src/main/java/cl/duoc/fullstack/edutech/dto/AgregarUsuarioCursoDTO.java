package cl.duoc.fullstack.edutech.dto;

public class AgregarUsuarioCursoDTO {
    private String rut;
    private String nombreSeccion;


    public AgregarUsuarioCursoDTO(String rut, String nombreSeccion) {
        this.rut = rut;
        this.nombreSeccion = nombreSeccion;
    }
    public AgregarUsuarioCursoDTO(){
        this.nombreSeccion="";
        this.rut="";

    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getNombreSeccion() {
        return nombreSeccion;
    }
    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    

    

}

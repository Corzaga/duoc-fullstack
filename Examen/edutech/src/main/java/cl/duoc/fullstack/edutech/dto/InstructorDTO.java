package cl.duoc.fullstack.edutech.dto;

public class InstructorDTO {

    private int idUsuario;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String curso;
    //private String contrasena;

    public InstructorDTO(){
        this.idUsuario = 0;
        this.rut = "";
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.curso = "";    
    }

    public InstructorDTO(int idUsuario, String rut, String nombre, String apellido, String correo, String curso) {
        this.idUsuario = idUsuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.curso = curso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    

}

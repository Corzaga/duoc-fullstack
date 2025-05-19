package cl.duoc.fullstack.edutech.dto;

public class AlumnoDTO {

    private int idUsuario;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String asignatura;
    //private String contrasena;

     public AlumnoDTO() {
        this.idUsuario = 0;
        this.rut = "";
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.asignatura = "";
    }
    
    public AlumnoDTO(int idUsuario, String rut, String nombre, String apellido, String correo, String asignatura) {
        this.idUsuario = idUsuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.asignatura = asignatura;
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

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    
}

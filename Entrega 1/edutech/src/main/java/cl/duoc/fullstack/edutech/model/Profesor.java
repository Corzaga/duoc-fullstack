package cl.duoc.fullstack.edutech.model;

public class Profesor extends Usuario {

    private String clase;

    public Profesor() {
        this.clase = "";
    }

    public Profesor(String rut, String nombre, String apellido, String correo, String clase) {
        super(rut, nombre, apellido, correo);
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}

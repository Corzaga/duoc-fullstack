package cl.duoc.fullstack.edutech.model;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;

    private String nombreCurso;
    private String nombreSeccion;
    private String fechaInicio;
    private String fechaTermino;

    @ManyToMany(mappedBy = "cursos")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "curso")
    private List<ResenaCurso> resenas;

    @OneToMany(mappedBy = "curso")
    private List<EvaluacionCurso> evaluaciones;

    @OneToMany(mappedBy = "curso")
    private List<IncidenciaCurso> incidencias;

    @OneToMany(mappedBy = "curso")
    private List<ContenidoCurso> contenidos;

    @OneToMany(mappedBy = "curso")
    private List<ForoCurso> foros;

    //constructores

    public Curso(){
        this.nombreCurso = "";
        this.nombreSeccion = "";
        this.fechaInicio = "";
        this.fechaTermino = "";
    }

    public Curso(String nombreCurso, String nombreSeccion, String fechaInicio, String fechaTermino) {
        this.nombreCurso = nombreCurso;
        this.nombreSeccion = nombreSeccion;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    //getters and setters
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<ResenaCurso> getResenas() {
        return resenas;
    }

    public void setResenas(List<ResenaCurso> resenas) {
        this.resenas = resenas;
    }

    public List<EvaluacionCurso> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<EvaluacionCurso> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public List<IncidenciaCurso> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(List<IncidenciaCurso> incidencias) {
        this.incidencias = incidencias;
    }

    public List<ContenidoCurso> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<ContenidoCurso> contenidos) {
        this.contenidos = contenidos;
    }

    public List<ForoCurso> getForos() {
        return foros;
    }

    public void setForos(List<ForoCurso> foros) {
        this.foros = foros;
    }

}

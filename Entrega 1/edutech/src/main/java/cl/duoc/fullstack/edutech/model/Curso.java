package cl.duoc.fullstack.edutech.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;

    private String nombreCurso;
    private String fechaInicio;
    private String fechaTermino;

    @ManyToMany(mappedBy = "cursos")
    private List<Usuario> usuarios;

}

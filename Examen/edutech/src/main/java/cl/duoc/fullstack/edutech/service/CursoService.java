package cl.duoc.fullstack.edutech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.dto.AgregarUsuarioCursoDTO;
import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.model.Instructor;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.InstructorRepository;


//hecho en china por pablo
@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

  
    private InstructorRepository instructorRepository;


// asigna un instructor a un curso
    public String asignarCursoInstructor(AgregarUsuarioCursoDTO agregarUsuarioCursoDTO) {
    if (!instructorRepository.findByRut(agregarUsuarioCursoDTO.getRut()).isPresent()) {
        return "El Instructor no existe";
    } else if (!cursoRepository.findByNombreSeccion(agregarUsuarioCursoDTO.getNombreSeccion()).isPresent()) {
        return "El Instructor existe pero el curso no";
    } else {
        Instructor instructor = instructorRepository.findByRut(agregarUsuarioCursoDTO.getRut()).get();
        Curso curso = cursoRepository.findByNombreSeccion(agregarUsuarioCursoDTO.getNombreSeccion()).get();

        if (curso.getUsuarios() == null) {
            curso.setUsuarios(new ArrayList<>());
        }
        if (!curso.getUsuarios().contains(instructor)) {
            curso.getUsuarios().add(instructor);
        }

        if (instructor.getCursos() == null) {
            instructor.setCursos(new ArrayList<>());
        }
        if (!instructor.getCursos().contains(curso)) {
            instructor.getCursos().add(curso);
        }

        cursoRepository.save(curso);
        instructorRepository.save(instructor);

        return "Instructor " + instructor.getNombre() + " se agregó al curso " + curso.getNombreCurso();
    }
    
}

    // asigna un alumno a un curso
    public String asignarCursoAlumno(AgregarUsuarioCursoDTO agregarUsuarioCursoDTO) {
    if (!alumnoRepository.findByRut(agregarUsuarioCursoDTO.getRut()).isPresent()) {
        return "El Alumno no existe";
    } else if (!cursoRepository.findByNombreSeccion(agregarUsuarioCursoDTO.getNombreSeccion()).isPresent()) {
        return "El Alumno existe pero el curso no";
    } else {
        Alumno alumno = alumnoRepository.findByRut(agregarUsuarioCursoDTO.getRut()).get();
        Curso curso = cursoRepository.findByNombreSeccion(agregarUsuarioCursoDTO.getNombreSeccion()).get();

        // Inicializa la lista si es null
        if (curso.getUsuarios() == null) {
            curso.setUsuarios(new ArrayList<>());
        }
        if (!curso.getUsuarios().contains(alumno)) {
            curso.getUsuarios().add(alumno);
        }

        if (alumno.getCursos() == null) {
            alumno.setCursos(new ArrayList<>());
        }
        if (!alumno.getCursos().contains(curso)) {
            alumno.getCursos().add(curso);
        }

        cursoRepository.save(curso);
        alumnoRepository.save(alumno);

        return "Alumno " + alumno.getNombre() + " se agregó al curso " + curso.getNombreCurso();
    }
}



    //almacenar cursos
    public String almacenar(Curso curso){
    Optional<Curso> existente = cursoRepository.findByNombreSeccion(curso.getNombreSeccion());

    if (existente.isPresent()) {
        return "Ya existe un curso con la sección: " + curso.getNombreSeccion();
    }

    cursoRepository.save(curso);
    return "Curso guardado";

    }

    //listar Cursos
        public List <Curso> listar(){
        return cursoRepository.findAll();
    }
    
    //buscar curso por nombre Seccion
    public String buscarPorNombreSeccion(String nombreSeccion) {
    Optional<Curso> cursoOptional = cursoRepository.findByNombreSeccion(nombreSeccion);

    if (cursoOptional.isPresent()) {
        Curso curso = cursoOptional.get();
        return "Curso encontrado: " + curso.getNombreCurso(); // Aquí asegúrate que no sea null
    } else {
        return "Curso no existe";
    }

}
    // Actualizar curso
    public Curso actualizarCurso(Curso curso) {
        // Aquí podrías validar que exista antes
        return cursoRepository.save(curso);
    }

    //Eliminar Curso por Seccion

    public String eliminar(String nombreSeccion){
        if(cursoRepository.findByNombreSeccion(nombreSeccion).isPresent()){
            Curso curso = cursoRepository.findByNombreSeccion(nombreSeccion).get();
            cursoRepository.delete(curso);
            return "El curso a sido eliminado con exito";
        }else{
            return "El curso no existe";
        }
    }


}

    




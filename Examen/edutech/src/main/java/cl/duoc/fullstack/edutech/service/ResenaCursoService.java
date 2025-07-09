package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.dto.ResenaCursoDTO;
import cl.duoc.fullstack.edutech.model.ResenaCurso;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.ResenaCursoRepository;

@Service
public class ResenaCursoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    private ResenaCursoRepository resenaCursoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    ResenaCursoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    // Brandon Sepúlveda
    // Guardar resena del curso
    public String almacenar(ResenaCursoDTO resenaCursoDTO){
        if(!cursoRepository.findByNombreSeccion(resenaCursoDTO.getSeccionCurso()).isPresent()){
            return "El curso no existe";
        } else{
            //Se instancia curso para cuardarlo
            Curso curso = cursoRepository.findByNombreSeccion(resenaCursoDTO.getSeccionCurso()).get();
            //Se instancia el resenaCurso para encapsularlo y guardarlo
            ResenaCurso resenaCurso = new ResenaCurso();
            resenaCurso.setCurso(curso);
            resenaCurso.setNombreAlumno(resenaCursoDTO.getNombreAlumno());
            resenaCurso.setCalificacion(resenaCursoDTO.getCalificacion());
            resenaCurso.setDescripcion(resenaCursoDTO.getDescripcion());
            resenaCursoRepository.save(resenaCurso);
            return "Reseña guardada correctamente";
        }
    }
    
    // Brandon Sepúlveda
    // Listar resena del curso
    public List<ResenaCurso> listar(){
        return resenaCursoRepository.findAll();
    }
    
    // Brandon Sepúlveda
    // Eliminar resena del curso
    public String eliminar(String seccionCurso, String nombreAlumno){
        if(cursoRepository.findByNombreSeccion(seccionCurso).isPresent() && alumnoRepository.findByRut(nombreAlumno).isPresent()){
            ResenaCurso resenaCurso = resenaCursoRepository.findByNombreAlumno(nombreAlumno).get();
            resenaCursoRepository.delete(resenaCurso);
            return "Reseña eliminada correctamente";
        } else if (!cursoRepository.findByNombreSeccion(seccionCurso).isPresent()){
            return "Curso no existe";
        } else {
            return "Reseña no existe";
        }
    }
}   

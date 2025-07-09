package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.dto.EvaluacionCursoDTO;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.model.EvaluacionCurso;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.EvaluacionCursoRepository;
import cl.duoc.fullstack.edutech.repository.InstructorRepository;

@Service
public class EvaluacionCursoService {

    @Autowired
    EvaluacionCursoRepository evaluacionCursoRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    InstructorRepository instructorRepository;

    // Brandon Sepúlveda
    // -------------------------------------> ¿agregamos validador por unidad?
    // Guardar evaluacion curso  
    public String almacenar(EvaluacionCursoDTO evaluacionCursoDTO){
        if(!cursoRepository.findByNombreSeccion(evaluacionCursoDTO.getseccionCurso()).isPresent()){
            return "El curso no existe";
        } else if(!instructorRepository.findByRut(evaluacionCursoDTO.getInstructor()).isPresent()){
            return "El curso existe pero el instructor no";
        } else{
            Curso curso = cursoRepository.findByNombreSeccion(evaluacionCursoDTO.getseccionCurso()).get();
            EvaluacionCurso evaluacionCurso = new EvaluacionCurso();
            evaluacionCurso.setCurso(curso);
            evaluacionCurso.setDescripcion(evaluacionCursoDTO.getDescripcion());
            evaluacionCurso.setNombreEvaluacion(evaluacionCursoDTO.getNombreEvaluacion());
            evaluacionCurso.setTipoEvaluacion(evaluacionCursoDTO.getTipoEvaluacion());
            evaluacionCursoRepository.save(evaluacionCurso);
            return "Evaluación agregada correctamente";
        }
    };

    // Brandon Sepúlveda
    // Listar evaluacion curso
    public List<EvaluacionCurso> listar(){
        return evaluacionCursoRepository.findAll();
    }

    // Brandon Sepúlveda
    // Eliminar evaluacion curso
    public String eliminar(String seccionCurso,String nombreEvaluacion){
        if(evaluacionCursoRepository.findByNombreEvaluacion(nombreEvaluacion).isPresent() && cursoRepository.findByNombreSeccion(seccionCurso).isPresent()){
            //Encapsula contenido
            EvaluacionCurso evaluacionCurso = evaluacionCursoRepository.findByNombreEvaluacion(nombreEvaluacion).get();
            evaluacionCursoRepository.delete(evaluacionCurso);
            return "Evaluacion eliminada correctamente";
        } else if(!cursoRepository.findByNombreSeccion(seccionCurso).isPresent()){
            return "Curso no existe";
        } else{
            return "Evaluacion no existe";
        }
    }

}

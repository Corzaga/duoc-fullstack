package cl.duoc.fullstack.edutech.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.duoc.fullstack.edutech.dto.ForoCursoDTO;
import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.model.ForoCurso;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.ForoCursoRepository;
//hecho en china por pablo
@Service
public class ForoCursoService {
    @Autowired
    private ForoCursoRepository foroRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;

// guardar una pregunta asociada a un alumno que tenga curso
    public String guardarForo(ForoCursoDTO dto) {
    Optional<Curso> cursoOpt = cursoRepository.findByNombreSeccion(dto.getNombreSeccion());
    if (!cursoOpt.isPresent()) return "Curso no encontrado";

    Optional<Alumno> alumnoOpt = alumnoRepository.findByRut(dto.getRutAlumno());
    if (!alumnoOpt.isPresent()) return "Alumno no encontrado";

    Curso curso = cursoOpt.get();
    Alumno alumno = alumnoOpt.get();

    ForoCurso foro = new ForoCurso();
    foro.setPregunta(dto.getPregunta());
    foro.setCurso(curso);
    foro.setAlumno(alumno);

    foroRepository.save(foro);

    return "Pregunta guardada\nAlumno: " + alumno.getNombre() +
           "\nCurso: " + curso.getNombreCurso() +
           "\nPregunta: " + foro.getPregunta();
}
     //lista un dto
    public List<ForoCursoDTO> listardto() {
    List<ForoCurso> foros = foroRepository.findAll();

    return foros.stream().map(foro ->
        new ForoCursoDTO(
            foro.getPregunta(),
            foro.getAlumno().getNombre(),
            foro.getCurso().getNombreSeccion()
        )
    ).collect(Collectors.toList());
}



    // en lista todas las preguntas
    public List<ForoCurso> listar(){
        return foroRepository.findAll();
        
    }


     //eliminar pregunta por id
        public String eliminarPreguntaPorId(Integer id) {
        if (!foroRepository.existsById(id)) {
            return "La pregunta no existe";
        }
        foroRepository.deleteById(id);
        return "Pregunta eliminada con éxito";
    }
}




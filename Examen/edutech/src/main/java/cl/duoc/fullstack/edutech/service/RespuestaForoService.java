package cl.duoc.fullstack.edutech.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.duoc.fullstack.edutech.dto.RespuestaForoDTO;
import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.model.ForoCurso;
import cl.duoc.fullstack.edutech.model.RespuestaForo;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;
import cl.duoc.fullstack.edutech.repository.ForoCursoRepository;
import cl.duoc.fullstack.edutech.repository.RespuestaForoRepository;
//hecho en china por pablo
@Service
public class RespuestaForoService {

    @Autowired
    private RespuestaForoRepository respuestaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ForoCursoRepository foroCursoRepository;

    //guarda una respuesta verificando que foro y alumno existan
    public String guardarRespuesta(RespuestaForoDTO dto) {
    Optional<Alumno> alumnoOpt = alumnoRepository.findByRut(dto.getRutAlumno());
    if (!alumnoOpt.isPresent()) return "Alumno no encontrado";

    Optional<ForoCurso> foroOpt = foroCursoRepository.findById(dto.getIdForoCurso());
    if (!foroOpt.isPresent()) return "Foro no encontrado";

    Alumno alumno = alumnoOpt.get();
    ForoCurso foro = foroOpt.get();

    RespuestaForo respuesta = new RespuestaForo();
    respuesta.setRespuesta(dto.getRespuesta());
    respuesta.setForo(foro);
    respuesta.setAlumno(alumno);

    respuestaRepository.save(respuesta);

    return "Respuesta guardada\nAlumno: " + alumno.getNombre() +
           "\nPregunta: " + foro.getPregunta() +
           "\nRespuesta: " + dto.getRespuesta();
}
         //lista un dto
    public List<RespuestaForoDTO> listarRespuestas() {
    List<RespuestaForo> respuestas = respuestaRepository.findAll();

    return respuestas.stream().map(respuesta ->
        new RespuestaForoDTO(
            respuesta.getRespuesta(),
            respuesta.getForo().getIdForoCurso(),
            respuesta.getAlumno().getNombre()
        )
    ).collect(Collectors.toList());
}



    // Obtener todas las respuestas
    public List<RespuestaForo> obtenerTodas() {
        return respuestaRepository.findAll();
    }

    // ELIMINAR
    public String eliminarRespuesta(int idRespuesta) {
        Optional<RespuestaForo> respuestaOpt = respuestaRepository.findById(idRespuesta);
        if (!respuestaOpt.isPresent()) {
            return "Respuesta no encontrada";
        }
        respuestaRepository.delete(respuestaOpt.get());
        return "Respuesta eliminada correctamente";
    }

}

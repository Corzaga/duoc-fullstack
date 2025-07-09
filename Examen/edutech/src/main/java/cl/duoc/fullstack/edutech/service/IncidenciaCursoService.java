package cl.duoc.fullstack.edutech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.dto.IncidenciaCursoDTO;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.model.IncidenciaCurso;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.IncidenciaCursoRepository;

@Service
public class IncidenciaCursoService {

    @Autowired
    private IncidenciaCursoRepository incidenciaRepository;

    @Autowired
    private CursoRepository cursoRepository;


    public String guardar(IncidenciaCursoDTO dto) {
        Optional<Curso> cursoOpt = cursoRepository.findByNombreSeccion(dto.getNombreSeccion());
        if (!cursoOpt.isPresent()) {
            return "Curso con sección '" + dto.getNombreSeccion() + "' no encontrado";
        }

        Curso curso = cursoOpt.get();
        IncidenciaCurso incidencia = new IncidenciaCurso();
        incidencia.setDescripcion(dto.getDescripcion());
        incidencia.setEstadoIncidencia(dto.getEstadoIncidencia());
        incidencia.setCurso(curso);

        incidenciaRepository.save(incidencia);

        return "Incidencia registrada correctamente para curso: " + curso.getNombreCurso();
    }

    public List<IncidenciaCurso> listar() {
        return incidenciaRepository.findAll();
    }


    // Listar todas las incidencias
    public List<IncidenciaCurso> listarIncidencias() {
        return incidenciaRepository.findAll();
    }

    // // Actualizar una incidencia por id
    // public String actualizarIncidencia(IncidenciaCursoDTO dto) {
    //     if (dto.getIdIncidenciaCurso() == null) {
    //         return "Id de incidencia no proporcionado";
    //     }

    //     Optional<IncidenciaCurso> incidenciaOpt = incidenciaRepository.findById(dto.getIdIncidenciaCurso());
    //     if (!incidenciaOpt.isPresent()) {
    //         return "Incidencia no encontrada";
    //     }

    //     IncidenciaCurso incidencia = incidenciaOpt.get();

    //     // Actualizamos los campos
    //     incidencia.setDescripcion(dto.getDescripcion());
    //     incidencia.setEstadoIncidencia(dto.getEstadoIncidencia());

    //     // Cambiar curso si viene diferente
    //     if (dto.getIdCurso() != null && !dto.getIdCurso().equals(incidencia.getCurso().getIdCurso())) {
    //         Optional<Curso> cursoOpt = cursoRepository.findById(dto.getIdCurso());
    //         if (!cursoOpt.isPresent()) {
    //             return "Curso nuevo no encontrado";
    //         }
    //         incidencia.setCurso(cursoOpt.get());
    //     }

    //     incidenciaRepository.save(incidencia);
    //     return "Incidencia actualizada correctamente";
    // }

    // Eliminar incidencia por id
    public String eliminarIncidencia(int id) {
        Optional<IncidenciaCurso> incidenciaOpt = incidenciaRepository.findById(id);
        if (!incidenciaOpt.isPresent()) {
            return "Incidencia no encontrada";
        }
        incidenciaRepository.deleteById(id);
        return "Incidencia eliminada correctamente";
    }
    }
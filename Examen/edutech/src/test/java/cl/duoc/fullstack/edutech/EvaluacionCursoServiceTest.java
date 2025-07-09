package cl.duoc.fullstack.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import cl.duoc.fullstack.edutech.dto.EvaluacionCursoDTO;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.model.EvaluacionCurso;
import cl.duoc.fullstack.edutech.model.Instructor;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.EvaluacionCursoRepository;
import cl.duoc.fullstack.edutech.repository.InstructorRepository;
import cl.duoc.fullstack.edutech.service.EvaluacionCursoService;
//Brandon Sepulveda
// 6 TEST UNITARIOS

@ExtendWith(MockitoExtension.class)
public class EvaluacionCursoServiceTest {

    @Mock
    EvaluacionCursoRepository evaluacionCursoRepository;
    @Mock
    CursoRepository cursoRepository;
    @Mock
    InstructorRepository instructorRepository;

    @InjectMocks
    private EvaluacionCursoService evaluacionCursoService;

    @Test
    void almacenarCorrectamente(){
        EvaluacionCursoDTO dto = new EvaluacionCursoDTO();
        dto.setNombreEvaluacion("Evaluacion 1");
        dto.setTipoEvaluacion("Formativa");
        dto.setDescripcion("Evaluar contenido unidad 1");
        dto.setInstructor("12345678-9");
        dto.setseccionCurso("A1");

        Curso curso = new Curso();
        Instructor instructor = new Instructor();

        when(cursoRepository.findByNombreSeccion("A1")).thenReturn(Optional.of(curso));
        when(instructorRepository.findByRut("12345678-9")).thenReturn(Optional.of(instructor));
        

        String resultado = evaluacionCursoService.almacenar(dto);

        assertEquals("Evaluación agregada correctamente", resultado);
    }

    @Test
    void almacenarCursoNoExiste(){
        EvaluacionCursoDTO dto = new EvaluacionCursoDTO();
        dto.setNombreEvaluacion("Evaluacion 1");
        dto.setTipoEvaluacion("Formativa");
        dto.setDescripcion("Evaluar contenido unidad 1");
        dto.setInstructor("12345678-9");
        dto.setseccionCurso("A1");


        when(cursoRepository.findByNombreSeccion("A1")).thenReturn(Optional.empty());

        

        String resultado = evaluacionCursoService.almacenar(dto);

        assertEquals("El curso no existe", resultado);
    }
    
    @Test
    void almacenarInstructorNoExiste(){
        EvaluacionCursoDTO dto = new EvaluacionCursoDTO();
        dto.setNombreEvaluacion("Evaluacion 1");
        dto.setTipoEvaluacion("Formativa");
        dto.setDescripcion("Evaluar contenido unidad 1");
        dto.setInstructor("12345678-9");
        dto.setseccionCurso("A1");

        Curso curso = new Curso();
        when(cursoRepository.findByNombreSeccion("A1")).thenReturn(Optional.of(curso));
        when(instructorRepository.findByRut("12345678-9")).thenReturn(Optional.empty());
        

        String resultado = evaluacionCursoService.almacenar(dto);

        assertEquals("El curso existe pero el instructor no", resultado);
    }

    @Test
    void eliminarCorrectamente(){
        Curso curso = new Curso();
        EvaluacionCurso evaluacionCurso = new EvaluacionCurso();
        evaluacionCurso.setNombreEvaluacion("Evaluacion 1");

        when(cursoRepository.findByNombreSeccion("A1")).thenReturn(Optional.of(curso));
        when(evaluacionCursoRepository.findByNombreEvaluacion("Evaluacion 1")).thenReturn(Optional.of(evaluacionCurso));

        String resultado = evaluacionCursoService.eliminar("A1", "Evaluacion 1");

        assertEquals("Evaluacion eliminada correctamente", resultado);

    }

    @Test
    void eliminarCursoNoEncontrado(){
        EvaluacionCurso evaluacionCurso = new EvaluacionCurso();
        evaluacionCurso.setNombreEvaluacion("Evaluacion 1");

        when(cursoRepository.findByNombreSeccion("A1")).thenReturn(Optional.empty());
        when(evaluacionCursoRepository.findByNombreEvaluacion("Evaluacion 1")).thenReturn(Optional.of(evaluacionCurso));


        String resultado = evaluacionCursoService.eliminar("A1", "Evaluacion 1");

        assertEquals("Curso no existe", resultado);

    }

    @Test
    void eliminarEvaluacionNoEncontrado(){
        Curso curso = new Curso();
        when(cursoRepository.findByNombreSeccion("A1")).thenReturn(Optional.of(curso));
        String resultado = evaluacionCursoService.eliminar("A1", "Evaluacion 1");
        assertEquals("Evaluacion no existe", resultado);

    }


}

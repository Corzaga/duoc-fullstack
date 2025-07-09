package cl.duoc.fullstack.edutech;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.fullstack.edutech.dto.ForoCursoDTO;
import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.model.ForoCurso;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.ForoCursoRepository;
import cl.duoc.fullstack.edutech.service.ForoCursoService;
//Pablo Morales
@ExtendWith(MockitoExtension.class)
public class ForoCursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @Mock
    private AlumnoRepository alumnoRepository;

    @Mock
    private ForoCursoRepository foroRepository;

    @InjectMocks
    private ForoCursoService foroCursoService;

    @Test
    void testGuardarForoConExito() {
    
        ForoCursoDTO dto = new ForoCursoDTO("¿Cuál es la materia?", "005v", "12345678-9");

        Curso curso = new Curso();
        curso.setNombreSeccion("005v");
        curso.setNombreCurso("full");

        Alumno alumno = new Alumno();
        alumno.setNombre("Mario");
        alumno.setRut("12345678-9");

        when(cursoRepository.findByNombreSeccion("005v")).thenReturn(Optional.of(curso));
        when(alumnoRepository.findByRut("12345678-9")).thenReturn(Optional.of(alumno));

        String resultado = foroCursoService.guardarForo(dto);

        assertTrue(resultado.contains("Pregunta guardada"));
        assertTrue(resultado.contains("Alumno: Mario"));
        assertTrue(resultado.contains("Curso: full"));
        verify(foroRepository).save(any(ForoCurso.class));
    }

    @Test
    void testGuardarForoAlumnoNoEncontrado() {
    ForoCursoDTO dto = new ForoCursoDTO("¿Cuál es la materia?", "005v", "12345678-9");

    Curso curso = new Curso();
    curso.setNombreSeccion("005v");
    curso.setNombreCurso("full");

    // Curso sí existe
    when(cursoRepository.findByNombreSeccion("005v")).thenReturn(Optional.of(curso));

    // Alumno NO existe
    when(alumnoRepository.findByRut("12345678-9")).thenReturn(Optional.empty());

    String resultado = foroCursoService.guardarForo(dto);

    assertTrue(resultado.equals("Alumno no encontrado"));
    verify(foroRepository, org.mockito.Mockito.never()).save(any());
}

    @Test
    void testEliminarPreguntaPorIdNoExistente() {
    Integer id = 999;

    when(foroRepository.existsById(id)).thenReturn(false);

    String resultado = foroCursoService.eliminarPreguntaPorId(id);

    assertTrue(resultado.equals("La pregunta no existe"));
    verify(foroRepository, org.mockito.Mockito.never()).deleteById(id);
}


}
